package android.com.what2eat.fragments


import android.com.what2eat.R
import android.com.what2eat.adapters.MaaltijdAdapter
import android.com.what2eat.adapters.MaaltijdListener
import android.com.what2eat.databinding.FragmentMaaltijdOnderdeelDetailBinding
import android.com.what2eat.utils.NetworkUtil
import android.com.what2eat.viewmodels.MaaltijdOnderdeelDetailViewModel
import android.com.what2eat.viewmodels.viewModelFactories.MaaltijdOnderdeelDetailViewModelFactory
import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.text.InputType
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

/**
 * Fragment voor het weergeven van detail van een maaltijd
 * @property binding Binding object van het fragment
 * @property viewModelFactory [MaaltijdOnderdeelDetailViewModelFactory] dat gebruikt wordt om [MaaltijdOnderdeelDetailViewModel] aan te maken
 * @property viewModel [MaaltijdOnderdeelDetailViewModel] dat gebruikt wordt in het fragment voor business logica
 */
class MaaltijdOnderdeelDetailFragment : Fragment() {

    /**
     * Fragment Properties
     */
    private lateinit var binding: FragmentMaaltijdOnderdeelDetailBinding
    private lateinit var viewModelFactory: MaaltijdOnderdeelDetailViewModelFactory
    private lateinit var viewModel: MaaltijdOnderdeelDetailViewModel

    /**
     * Functie die wordt opgeroepen wanneer het fragment aangemaakt wordt en in CREATED lifecycle state is.
     * Fragment properties worden hier geïnstantieerd.
     * @param savedInstanceState Bundel die gebruikt wordt om data terug in [MaaltijdOnderdeelDetailFragment] te initialiseren.
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        val args = MaaltijdOnderdeelDetailFragmentArgs.fromBundle(arguments!!)
        viewModelFactory =
            MaaltijdOnderdeelDetailViewModelFactory(
                args.maaltijdonderdeelId
            )
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MaaltijdOnderdeelDetailViewModel::class.java)
        super.onCreate(savedInstanceState)

    }

    /**
     * Functie die wordt opgeroepen wanneer het fragment aangemaakt wordt en in CREATED lifecycle state is.
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
         * DataBinding : layout inflation, viewModel binding
         */
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_onderdeel_detail, container, false)
        binding.setLifecycleOwner(this)
        binding.maaltijdOnderdeel = viewModel

        /**
         * RecyclerView setup voor het tonen van de RecyclerView van maaltijden waartoe het huidige maaltijdonderdeel behoort.
         */
        val adapter = MaaltijdAdapter(MaaltijdListener {
            findNavController().navigate(MaaltijdOnderdeelDetailFragmentDirections.actionMaaltijdOnderdeelDetailFragmentToMaaltijdDetailFragment(it))
        })
        binding.maaltijdenRecyclerView.adapter = adapter
        val itemDecor = DividerItemDecoration(context, ClipDrawable.HORIZONTAL)
        binding.maaltijdenRecyclerView.addItemDecoration(itemDecor)
        if(!NetworkUtil().isInternetAvailable(context!!)){
            binding.noconnectionLayout.visibility = VISIBLE
            binding.searchButton.isEnabled = false
        }

        /**
         * ViewModel Observers:
         *      Observatie voor het tonen van een SnackBar afkomstig van ViewModel en navigatie naar het overzichtfragment.
         *      Observeren van de maaltijden waartoe maaltijdOnderdeel behoort.
         */
        viewModel.showSnackBar.observe(this, Observer{
            showSnackBar(it)
            findNavController().navigate(R.id.action_maaltijdOnderdeelDetailFragment_to_maaltijdOnderdeelOverzichtFragment)
        })
        viewModel.maaltijden.observe(this, Observer{ lijst ->
            lijst?.let{
                if(it.size > 0){
                    setHasOptionsMenu(false)
                    binding.maaltijdenTitleText.visibility = VISIBLE
                    binding.maaltijdenRecyclerView.visibility = VISIBLE
                    adapter.submitList(it)
                }
                else{
                    setHasOptionsMenu(true)
                    binding.maaltijdenTitleText.visibility = GONE
                    binding.maaltijdenRecyclerView.visibility = GONE
                }
            }
        })

        /**
         * UI OnClickListeners:
         *      Listener voor de Edit button om de naam van het maaltijdOnderdeel aan te passen.
         *      Listener voor de search button om API call te doen naar externe recepten.
         */
        binding.editMealpartButton.setOnClickListener{
            editMaaltijdOnderdeel()
        }
        binding.searchButton.setOnClickListener {
            findNavController().navigate(MaaltijdOnderdeelDetailFragmentDirections.actionMaaltijdOnderdeelDetailFragmentToRecipeOverzichtFragment(viewModel.maaltijdOnderdeel.value!!.naam))
        }

        /**
         * Other
         */

        return binding.root
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
     * Deze functie toont een AlertDialog waarbij de naam van het maaltijdOnderdeel gewijzigd kan worden.
     */
    private fun editMaaltijdOnderdeel(){
        val oudeNaam = viewModel.maaltijdOnderdeel.value?.naam ?: ""

        val builder = AlertDialog.Builder(this.context!!)
        builder.setTitle(R.string.mealpart_name)

        val input = EditText(this.context!!)
        input.inputType = InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
        input.setSingleLine(true)
        input.setText(oudeNaam)
        input.setTextColor(
            ContextCompat.getColor(
                context!!,
                R.color.colorPrimaryDark
            )
        )
        builder.setView(input)

        builder.setPositiveButton(R.string.save) { _, _ ->
            binding.maaltijdOnderdeelNaamText.text = input.text.toString()
            viewModel.setNaam(input.text.toString())
        }
        builder.setNegativeButton(R.string.cancel) { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
        input.requestFocus()
    }
    /**
     * Deze functie wordt gebruikt om het overflow menu weer te geven.
     * Overflowmenu is een delete icon om het maaltijdOnderdeel te verwijderen.
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
            R.id.delete_menuitem -> deleteMaaltijdOnderdeel()
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Deze functie wordt gebruikt om een AlertDialog weer te geven waarbij de gebruiker toestemming
     * geeft om huidige maaltijdOnderdeel te verwijderen.
     */
    private fun deleteMaaltijdOnderdeel(){
        MaterialAlertDialogBuilder(context)
            .setTitle(R.string.confirmation_delete_title)
            .setMessage(R.string.confirmation_delete_mealpart_content)
            .setPositiveButton(resources.getString(R.string.ok)) { dialog, num ->
                viewModel.deleteMaaltijdOnderdeel()
            }
            .setNegativeButton(resources.getString(R.string.cancel)) { dialog, num -> }
            .show()
    }
}
