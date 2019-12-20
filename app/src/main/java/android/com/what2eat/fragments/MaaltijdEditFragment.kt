package android.com.what2eat.fragments


import android.Manifest
import android.app.Activity.RESULT_OK
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.adapters.MaaltijdOnderdeelListener
import android.com.what2eat.adapters.MaaltijdOnderdeelRemoveAdapter
import android.com.what2eat.adapters.setPhoto
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.database.MaaltijdMaaltijdOnderdeelDao
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.databinding.FragmentMaaltijdEditBinding
import android.com.what2eat.utils.RotationTransformUtil
import android.com.what2eat.viewmodels.MaaltijdDetailViewModel
import android.com.what2eat.viewmodels.MaaltijdDetailViewModelFactory
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.graphics.drawable.ClipDrawable
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.Gravity
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.maaltijdonderdeel_remove_item_view.*
import java.io.File
import java.io.IOException
import java.net.URI
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class MaaltijdEditFragment : Fragment() {

    private lateinit var binding: FragmentMaaltijdEditBinding
    private lateinit var viewModelFactory: MaaltijdDetailViewModelFactory
    private lateinit var viewModel: MaaltijdDetailViewModel
    private lateinit var application: Application
    private lateinit var maaaltijdDataSource: MaaltijdDao
    private lateinit var maaltijdOnderdeelDataSource: MaaltijdOnderdeelDao
    private lateinit var maaltijdMaaltijdOnderdeelDataSource: MaaltijdMaaltijdOnderdeelDao
    val REQUEST_IMAGE_CAPTURE = 1
    val REQUEST_TAKE_PHOTO = 1
    private lateinit var currentPhotoPath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        application = requireNotNull(this.activity).application
        maaaltijdDataSource = MaaltijdDatabase.getInstance(application).maaltijdDao
        maaltijdOnderdeelDataSource = MaaltijdDatabase.getInstance(application).maaltijdOnderdeelDao
        maaltijdMaaltijdOnderdeelDataSource = MaaltijdDatabase.getInstance(application).maaltijdMaaltijdOnderdeelDao
        val args = MaaltijdEditFragmentArgs.fromBundle(arguments!!)
        viewModelFactory = MaaltijdDetailViewModelFactory(args.maaltijdId, maaaltijdDataSource, maaltijdOnderdeelDataSource,maaltijdMaaltijdOnderdeelDataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MaaltijdDetailViewModel::class.java)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_edit, container, false)
        binding.lifecycleOwner = this

        val args = MaaltijdEditFragmentArgs.fromBundle(arguments!!)
        args.addMaaltijdOnderdelenIds?.let {
            viewModel.addMaaltijdOnderdelenToMaaltijd(it)
        }
        val adapter = MaaltijdOnderdeelRemoveAdapter(MaaltijdOnderdeelListener {
            viewModel.removeMaaltijdOnderdeelFromMaaltijd(it)
        })
        binding.maaltijdOnderdelenRecycler.adapter = adapter
        val itemDecor = DividerItemDecoration(context, ClipDrawable.HORIZONTAL)
        binding.maaltijdOnderdelenRecycler.addItemDecoration(itemDecor)

        binding.maaltijd = viewModel

        viewModel.maaltijd.observe(this, Observer{
            it.photo_uri?.let{
                binding.maaltijdPhotoDeleteButton.visibility = VISIBLE
            }
        })
        viewModel.maaltijdOnderdelen.observe(viewLifecycleOwner, Observer {lijst ->
            lijst?.let {
                adapter.submitList(it)
            }
        })
        viewModel.changeRatingDisplay.observe(this, Observer{
            changeRatingDisplay(it)
        })
        viewModel.ratingString.observe(this, Observer{
            binding.ratingText.text = it
        })
        binding.editMealButton.setOnClickListener{
            viewModel.setNaam(binding.maaltijdNaam.text.toString())
            viewModel.saveMaaltijd()
            val toast = Toast.makeText(
                        application.applicationContext,
                        "${this.binding.maaltijdNaam.text.toString()} ${resources.getString(R.string.edited)}",
                        Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
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
                Toast.makeText(context, "No camera available", Toast.LENGTH_LONG).show()
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
        /*
        binding.deleteMealButton.setOnClickListener {
            MaterialAlertDialogBuilder(context)
                .setTitle(R.string.confirmation_delete_title)
                .setMessage(R.string.confirmation_delete_meal_content)
                .setPositiveButton(resources.getString(R.string.ok)){ dialog, num ->
                    Toast.makeText(application.applicationContext,
                        "${this.binding.maaltijdNaam.text.toString()} ${resources.getString(R.string.deleted)}",
                        Toast.LENGTH_LONG).show()
                    viewModel.deleteMaaltijd()
                    it.findNavController().navigate(R.id.action_maaltijdEditFragment_to_maaltijdOverzichtFragment)
                }
                .setNegativeButton(resources.getString(R.string.cancel)){ dialog, num -> }
                .show()

        }*/
        val act = activity as MainActivity
        act.setCustomActionBar("edit_meal")

        return binding.root
    }

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

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Ensure that there's a camera activity to handle the intent
            takePictureIntent.resolveActivity(activity!!.packageManager)?.also {
                // Create the File where the photo should go
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    null
                }
                // Continue only if the File was successfully created
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

    private fun changeRatingDisplay(aantal: Int) {
        val starViews = listOf(
            binding.maaltijdRating1,
            binding.maaltijdRating2,
            binding.maaltijdRating3,
            binding.maaltijdRating4,
            binding.maaltijdRating5
        )
        starViews.forEach { star -> star.setImageResource(android.R.drawable.star_big_off) }
        when (aantal) {
            1 -> binding.maaltijdRating1.setImageResource(android.R.drawable.star_big_on)
            2 -> {
                binding.maaltijdRating1.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating2.setImageResource(android.R.drawable.star_big_on)
            }
            3 -> {
                binding.maaltijdRating1.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating2.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating3.setImageResource(android.R.drawable.star_big_on)
            }
            4 -> {
                binding.maaltijdRating1.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating2.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating3.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating4.setImageResource(android.R.drawable.star_big_on)
            }
            5 -> {
                binding.maaltijdRating1.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating2.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating3.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating4.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating5.setImageResource(android.R.drawable.star_big_on)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK){
            binding.maaltijdImage.scaleType = ImageView.ScaleType.CENTER_CROP
            Glide.with(context!!).load(currentPhotoPath).into(binding.maaltijdImage)
            binding.maaltijdPhotoDeleteButton.visibility = VISIBLE

        }
    }
}
