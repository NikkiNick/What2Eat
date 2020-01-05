package android.com.what2eat.fragments


import android.Manifest
import android.app.Activity.RESULT_OK
import android.app.Application
import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.adapters.MaaltijdOnderdeelListener
import android.com.what2eat.adapters.MaaltijdOnderdeelRemoveAdapter
import android.com.what2eat.databinding.FragmentMaaltijdEditBinding
import android.com.what2eat.viewmodels.MaaltijdDetailViewModel
import android.com.what2eat.viewmodels.viewModelFactories.MaaltijdDetailViewModelFactory
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ClipDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.addCallback
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_maaltijd_edit.view.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * Fragment voor het weergeven van een editscherm van een maaltijd
 * @property binding Binding object van het fragment
 * @property viewModelFactory [MaaltijdDetailViewModelFactory] dat gebruikt wordt om [MaaltijdDetailViewModel] aan te maken
 * @property viewModel [MaaltijdDetailViewModel] dat gebruikt wordt in het fragment voor business logica
 * @property application Application
 * @property REQUEST_TAKE_PHOTO Request token
 * @property currentPhotoPath URI naar afbeelding (genomen via Camera)
 */
class MaaltijdEditFragment : Fragment() {

    /**
     * Fragment Properties
     */
    private lateinit var binding: FragmentMaaltijdEditBinding
    private lateinit var viewModelFactory: MaaltijdDetailViewModelFactory
    private lateinit var viewModel: MaaltijdDetailViewModel
    private lateinit var args: MaaltijdEditFragmentArgs
    @Inject lateinit var application: Application
    val REQUEST_TAKE_PHOTO = 1
    private lateinit var currentPhotoPath: String

    /**
     * Functie die wordt opgeroepen wanneer het fragment aangemaakt wordt en in CREATED lifecycle state is.
     * Fragment properties worden hier geïnstantieerd.
     * @param savedInstanceState Bundel die gebruikt wordt om data terug in [MaaltijdEditFragment] te initialiseren.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        android.com.what2eat.Application.component.inject(this)
        args = MaaltijdEditFragmentArgs.fromBundle(arguments!!)
        viewModelFactory =
            MaaltijdDetailViewModelFactory(
                args.maaltijdId
            )
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MaaltijdDetailViewModel::class.java)
        super.onCreate(savedInstanceState)
    }

    /**
     * Functie die wordt opgeroepen wanneer het fragment aangemaakt wordt en in CREATED lifecycle state is
     * Setup van DataBinding, RecyclerView, ViewModel Observers, UI ClickListeners, ActionBar
     * @param inflater LayoutInflater
     * @param container ViewGroup
     * @param savedInstanceState Bundle
     * @return View
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /**
         * DataBinding : layout inflation, viewModel binding.
         */
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_edit, container, false)
        binding.lifecycleOwner = this
        binding.maaltijd = viewModel

        /**
         * Wanneer gebruiker maaltijdonderdelen gekozen heeft, worden deze toegevoegd aan de maaltijd.
         * De gekozen onderdelen worden gecommuniceerd via SafeArgs (LongArray van id's).
         */
        val args = MaaltijdEditFragmentArgs.fromBundle(arguments!!)
        args.addMaaltijdOnderdelenIds?.let {
            viewModel.addMaaltijdOnderdelenToMaaltijd(it)
        }

        /**
         * RecyclerView Setup voor weergeven van de maaltijdonderdelen die momenteel horen bij de maaltijd.
         * Inclusief listener wanneer een onderdeel gekozen wordt om te verwijderen van de maaltijd.
         */
        val adapter = MaaltijdOnderdeelRemoveAdapter(MaaltijdOnderdeelListener {
            viewModel.removeMaaltijdOnderdeelFromMaaltijd(it)
        })
        binding.maaltijdOnderdelenRecycler.adapter = adapter
        val itemDecor = DividerItemDecoration(context, ClipDrawable.HORIZONTAL)
        binding.maaltijdOnderdelenRecycler.addItemDecoration(itemDecor)

        /**
         * ViewModel Observers:
         *      Observeren van de huidige maaltijd.
         *      Observeren van de maaltijdonderdelen van de huidige maaltijd
         *      Observeren van de rating display die mee veranderd bij selectie
         *      Observeren van
         */
        viewModel.maaltijd.observe(this, Observer{
            it.photo_uri?.let{
                binding.maaltijdPhotoDeleteButton.visibility = VISIBLE
            }
        })
        viewModel.maaltijdOnderdelen.observe(viewLifecycleOwner, Observer {lijst ->
            lijst?.let {
                if(it.size > 0) {
                    binding.noItemsText.visibility = GONE
                    binding.maaltijdOnderdelenRecycler.visibility = VISIBLE
                    adapter.submitList(it)
                }
                else{
                    binding.noItemsText.visibility = VISIBLE
                    binding.maaltijdOnderdelenRecycler.visibility = GONE
                }
            }
        })
        viewModel.changeRatingDisplay.observe(this, Observer{
            changeRatingDisplay(it)
        })

        /**
         * UI OnClickListeners:
         *      Listener voor de input change van de gebruiker.
         *      Listener voor de save button voor het aanpassen van de maaltijd en om te navigeren naar het Detail fragment.
         *      Listener voor de add button om maaltijdonderdelen toe te voegen.
         *      Listener voor de camera button om een foto te nemen.
         *      Listener voor het verwijderen van de afbeelding.
         *      Listener voor het bekijken van de afbeelding in een apart fragment.
         */
        binding.maaltijdNaam.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if(s?.length == 0){
                    binding.editMealButton.isEnabled = false
                    binding.editMealButton.setColorFilter(Color.GRAY)
                    binding.textInputLayout.error = resources.getString(R.string.cannot_be_empty)
                }
                else{
                    binding.textInputLayout.error = null
                    binding.editMealButton.isEnabled = true
                    binding.editMealButton.setColorFilter(R.color.colorPrimary)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })
        binding.editMealButton.setOnClickListener{
            viewModel.saveMaaltijd()
            showSnackBar("${this.binding.maaltijdNaam.text.toString()} ${resources.getString(R.string.edited)}")
            it.findNavController().navigate(MaaltijdEditFragmentDirections.actionMaaltijdEditFragmentToMaaltijdDetailFragment(viewModel.maaltijdId))
        }
        binding.addMealpartButton.setOnClickListener {
            it.findNavController().navigate(MaaltijdEditFragmentDirections.actionMaaltijdEditFragmentToMaaltijdOnderdeelSelectFragment(viewModel.maaltijdId))
        }
        binding.maaltijdCameraButton.setOnClickListener{
            if(activity!!.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {
                takePhoto()
            }
            else{
                showSnackBar("No camera available")
            }
        }
        binding.maaltijdPhotoDeleteButton.setOnClickListener {
            viewModel.removeMaaltijdPhoto()
            binding.maaltijdImage.scaleType = ImageView.ScaleType.FIT_CENTER
            Glide.with(context!!).load(R.drawable.maaltijd_blank_image_wide).into(binding.maaltijdImage)
            binding.maaltijdPhotoDeleteButton.visibility = GONE
        }
        binding.maaltijdImage.setOnClickListener {
            viewModel.maaltijd.value?.photo_uri?.let{
                findNavController().navigate(MaaltijdEditFragmentDirections.actionMaaltijdEditFragmentToMaaltijdImageShowFragment(it))
            }
        }

        /**
         * ToolBar title
         */
        val act = activity as MainActivity
        act.setCustomActionBar("edit_meal")

        /**
         * Other
         */
        setHasOptionsMenu(true)

        return binding.root
    }

    /**
     * Deze functie wordt gebruikt om het overflow menu weer te geven.
     * Overflowmenu is een delete icon om de maaltijd te verwijderen.
     * @param menu Gebruikte menu
     * @param inflater MenuInflater die gebruikt wordt om de menu-layout te inflaten.
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.detail_menu_delete, menu)
    }

    /**
     * Deze functie wordt gebruikt om de gebruikte menuItem uit het overflowmenu af te handelen.
     * @param item Gekozen menuItem
     * @return Boolean
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.delete_menuitem -> deleteMaaltijd()
            }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Deze functie wordt gebruikt om een AlertDialog weer te geven waarbij de gebruiker toestemming
     * geeft om huidige maaltijd te verwijderen.
     */
    private fun deleteMaaltijd(){
        MaterialAlertDialogBuilder(context)
            .setTitle(R.string.confirmation_delete_title)
            .setMessage(R.string.confirmation_delete_meal_content)
            .setPositiveButton(resources.getString(R.string.ok)){ dialog, num ->
                showSnackBar("${resources.getString(R.string.meal)} ${resources.getString(R.string.deleted)}")
                viewModel.deleteMaaltijd()
                findNavController().navigate(R.id.action_maaltijdEditFragment_to_maaltijdOverzichtFragment)
            }
            .setNegativeButton(resources.getString(R.string.cancel)){ dialog, num -> }
            .show()
    }

    /**
     * Deze functie wordt gebruikt om een SnackBar met bericht weer te geven
     * @param message Bericht dat weergegeven moet worden in de SnackBar
     */
    private fun showSnackBar(message: String){
        val snackbar: Snackbar = Snackbar.make(getActivity()!!.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
        val view: View = snackbar.view
        val textView: TextView = view.findViewById(R.id.snackbar_text)
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER)
        snackbar.show()
    }

    /**
     * Deze functie wordt gebruikt om na te gaan of de gebruiker de nodige toestemmingen heeft
     *  voor het gebruik van camera en storage. Indien de gebruiker niet de juiste toestemmingen heeft
     *  worden deze gevraagd.
     */
    private fun takePhoto(){
        val permissions = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)

        fun hasNoPermissions(): Boolean{
            return ContextCompat.checkSelfPermission(context!!, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(context!!, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(context!!, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
        }

        fun requestPermission(){
            ActivityCompat.requestPermissions(activity!!, permissions,0)
        }
        if(hasNoPermissions()){
            requestPermission()
        }
        dispatchTakePictureIntent()

    }

    /**
     * Deze functie wordt gebruikt om de Intent te starten voor het nemen van een foto.
     */
    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->

            takePictureIntent.resolveActivity(activity!!.packageManager)?.also {
                // Bestand aanmaken
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    null
                }
                // Als bestand succesvol is aangemaakt: verdergaan
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                        context!!,
                        "com.example.android.fileprovider",
                        it
                    )
                    viewModel.setMaaltijdPhoto(currentPhotoPath)
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    this.startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
                }
            }
        }
    }

    /**
     * Deze functie wordt gebruikt voor het creëren van een afbeeldingsbestand.
     * @return Aangemaakte bestand
     */
    @Throws(IOException::class)
    private fun createImageFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File = context!!.getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        ).apply {
            currentPhotoPath = absolutePath
        }
    }

    /**
     * Deze functie wordt gebruikt voor het aanpassen van de UI elementen (Rating stars en string)
     * voor de rating bij selectie.
     * @param aantal Rating die geselecteerd werd door de gebruiker
     */
    private fun changeRatingDisplay(aantal: Int) {
        val starViews = listOf(
            binding.maaltijdRating1,
            binding.maaltijdRating2,
            binding.maaltijdRating3,
            binding.maaltijdRating4,
            binding.maaltijdRating5)
        starViews.forEach { star -> star.setImageResource(android.R.drawable.star_big_off) }
        when (aantal) {
            1 -> {
                binding.maaltijdRating1.setImageResource(android.R.drawable.star_big_on)
                binding.ratingText.text = application.applicationContext.getString(R.string.rating1)
            }
            2 -> {
                binding.maaltijdRating1.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating2.setImageResource(android.R.drawable.star_big_on)
                binding.ratingText.text = application.applicationContext.getString(R.string.rating2)
            }
            3 -> {
                binding.maaltijdRating1.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating2.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating3.setImageResource(android.R.drawable.star_big_on)
                binding.ratingText.text = application.applicationContext.getString(R.string.rating3)
            }
            4 -> {
                binding.maaltijdRating1.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating2.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating3.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating4.setImageResource(android.R.drawable.star_big_on)
                binding.ratingText.text = application.applicationContext.getString(R.string.rating4)
            }
            5 -> {
                binding.maaltijdRating1.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating2.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating3.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating4.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating5.setImageResource(android.R.drawable.star_big_on)
                binding.ratingText.text = application.applicationContext.getString(R.string.rating5)
            }
            else -> binding.ratingText.text = application.applicationContext.getString(R.string.rating0)
        }
    }

    /**
     * Deze functie wordt opgeroepen wanneer er een Result wordt ontvangen van de Intent voor het
     * nemen van een foto.
     * @param requestCode Request token die de Intent identificeerd
     * @param resultCode Nagaan van de result status van de Intent
     * @param data
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK){
            binding.maaltijdImage.scaleType = ImageView.ScaleType.CENTER_CROP
            Glide.with(context!!).load(currentPhotoPath).into(binding.maaltijdImage)
            binding.maaltijdPhotoDeleteButton.visibility = VISIBLE

        }
    }
}
