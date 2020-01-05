package android.com.what2eat.fragments


import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.adapters.MaaltijdOnderdeelCheckBoxAdapter
import android.com.what2eat.adapters.MaaltijdOnderdeelListener
import android.com.what2eat.databinding.FragmentMaaltijdOnderdeelSelectBinding
import android.com.what2eat.viewmodels.MaaltijdOnderdeelSelectViewModel
import android.com.what2eat.viewmodels.viewModelFactories.MaaltijdOnderdeelSelectViewModelFactory
import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.text.InputType
import android.view.*
import android.widget.EditText
import android.widget.SearchView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration

/**
 * Fragment voor het weergeven van detail van een maaltijd
 * @property binding Binding object van het fragment
 * @property viewModelFactory [MaaltijdOnderdeelSelectViewModelFactory] dat gebruikt wordt om [MaaltijdOnderdeelSelectViewModel] aan te maken
 * @property viewModel [MaaltijdOnderdeelSelectViewModel] dat gebruikt wordt in het fragment voor business logica
 * @property tempCheckedIds Lege lijst voor het bijhouden van id's van geselecteerde maaltijdOnderdelen
 * @property args SafeArgs bundle van het fragment
 */
class MaaltijdOnderdeelSelectFragment : Fragment() {

    /**
     * Fragment Properties
     */
    private lateinit var binding: FragmentMaaltijdOnderdeelSelectBinding
    private lateinit var viewModelFactory: MaaltijdOnderdeelSelectViewModelFactory
    private lateinit var viewModel: MaaltijdOnderdeelSelectViewModel
    val tempCheckedIds = mutableListOf<Long>()
    private lateinit var args: MaaltijdOnderdeelSelectFragmentArgs
        /**
     * Functie die wordt opgeroepen wanneer het fragment aangemaakt wordt en in CREATED lifecycle state is.
     * Fragment properties worden hier geïnstantieerd.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        args = MaaltijdOnderdeelSelectFragmentArgs.fromBundle(arguments!!)
        viewModelFactory =
            MaaltijdOnderdeelSelectViewModelFactory(
                args.maaltijdId
            )
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MaaltijdOnderdeelSelectViewModel::class.java)
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
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        /**
         * DataBinding : layout inflation, viewModel binding
         */
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_onderdeel_select, container, false)
        binding.setLifecycleOwner(this)
        viewModel.initMaaltijdOnderdelen()

        /**
         * RecyclerView SetUp. Als een maaltijdonderdeel aangeklikt wordt, wordt het id bijgehouden
         * in [tempCheckedIds].
         */
        val adapter = MaaltijdOnderdeelCheckBoxAdapter(MaaltijdOnderdeelListener {
            if(tempCheckedIds.contains(it)){
                tempCheckedIds.remove(it)
            }else {
                tempCheckedIds.add(it)
            }
        })
        binding.recyclerMaaltijdOnderdelen.adapter = adapter
        val itemDecor = DividerItemDecoration(context, ClipDrawable.HORIZONTAL)
        binding.recyclerMaaltijdOnderdelen.addItemDecoration(itemDecor)

        /**
         * UI onClickListener voor Add button om terug te keren naar maaltijd Edit fragment en de geselecteerde onderdelen
         * toe te voegen aan de maaltijd. Communicatie verloopt via SafeArgs (LongArray van id's)
         */
        binding.addMaaltijdOnderdelenButton.setOnClickListener{
            findNavController().navigate(MaaltijdOnderdeelSelectFragmentDirections.actionMaaltijdOnderdeelSelectFragmentToMaaltijdEditFragment(args.maaltijdId, tempCheckedIds.toLongArray()))
        }

        /**
         * ViewModel Observer voor de maaltijdOnderdelen
         */

        viewModel.maaltijdOnderdelen.observe(this, Observer{ lijst ->
            lijst?.let{
                adapter.submitList(lijst)
            }
        })

        /**
         * SearchView
         */
        val searchView: SearchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean { // do something on text submit
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean { // do something when text changes
                viewModel.filterMaaltijdOnderdelen(newText)
                return false
            }
        })

        /**
         * ActionBar title
         */
        val activity = getActivity() as MainActivity
        activity.setCustomActionBar("maaltijdonderdelenoverzicht")

        /**
         * Other
         */
        setHasOptionsMenu(true)

        return binding.root

    }

    /**
     * Deze functie wordt gebruikt om het overflow menu weer te geven.
     * Overflowmenu is een add button om een nieuw maaltijdOnderdeel toe te voegen.
     * @param menu Gebruikte menu
     * @param inflater MenuInflater die gebruikt wordt om de menu-layout te inflaten.
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.maaltijdonderdeeloverzicht_select_overflowmenu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    /**
     * Deze functie wordt gebruikt om de gebruikte menuItem uit het overflowmenu af te handelen.
     * @param item Gekozen menuItem
     * @return Boolean
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.add_maaltijdonderdeel_button -> addMaaltijdOnderdeel()
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Deze functie toont een AlertDialog waarbij de naam van het nieuw maaltijdonderdeel gevraagd wordt.
     * Het maaltijdonderdeel wordt aangemaakt en gepersisteerd via [MaaltijdOnderdeelSelectViewModel].
     */
    private fun addMaaltijdOnderdeel(){
        val builder = AlertDialog.Builder(this.context!!)
        builder.setTitle(R.string.mealpart_name)

        val input = EditText(this.context!!)
        input.inputType = InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
        input.setSingleLine(true)
        input.setTextColor(
            ContextCompat.getColor(
                context!!,
                R.color.colorPrimaryDark
            )
        )
        builder.setView(input)

        builder.setPositiveButton(R.string.save) { _, _ ->
            viewModel.addMaaltijdOnderdeel(input.text.toString())
        }
        builder.setNegativeButton(R.string.cancel) { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
        input.requestFocus()
    }

    /**
     * Deze functie wordt opgeroepen wanneer het STARTED lifecycle wordt ingegaan door het fragment.
     * Input van SearchView wordt gereset.
     */
    override fun onStart() {
        super.onStart()
        binding.searchView.queryHint = resources.getString(R.string.search)
        binding.searchView.clearFocus()
    }
}