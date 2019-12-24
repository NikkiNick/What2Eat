package android.com.what2eat.fragments


import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.adapters.MaaltijdOnderdeelClickableAdapter
import android.com.what2eat.adapters.MaaltijdOnderdeelListener
import android.com.what2eat.databinding.FragmentMaaltijdOnderdeelOverzichtBinding
import android.com.what2eat.viewmodels.MaaltijdOnderdeelOverzichtViewModel
import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
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
 * [Fragment] voor maaltijdonderdelenoverzicht
 */
class MaaltijdOnderdeelOverzichtFragment : Fragment() {
    /**
     * Fragment Properties
     */
    private lateinit var binding: FragmentMaaltijdOnderdeelOverzichtBinding
    private lateinit var viewModel: MaaltijdOnderdeelOverzichtViewModel
    /**
     * Functie die wordt opgeroepen wanneer het [Fragment] aangemaakt wordt en in CREATED lifecycle state is.
     * Fragment properties worden hier geïnstantieerd.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(MaaltijdOnderdeelOverzichtViewModel::class.java)
        super.onCreate(savedInstanceState)
    }
    /**
     * Functie die wordt opgeroepen wanneer het [Fragment] aangemaakt wordt en in CREATED lifecycle state is.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        /**
         * DataBinding : layout inflation, viewModel binding and initialisatie.
         */
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_maaltijd_onderdeel_overzicht,
            container,
            false
        )
        binding.setLifecycleOwner(this)
        viewModel.initMaaltijdOnderdelen()
        /**
         * RecyclerView setup voor lijst van maaltijdonderdelen inclusief [DividerItemDecoration].
         */
        val adapter = MaaltijdOnderdeelClickableAdapter(MaaltijdOnderdeelListener {
            findNavController().navigate(MaaltijdOnderdeelOverzichtFragmentDirections.actionMaaltijdOnderdeelOverzichtFragmentToMaaltijdOnderdeelDetailFragment(it))
        })
        binding.recyclerMaaltijdOnderdelen.adapter = adapter
        val itemDecor = DividerItemDecoration(context, ClipDrawable.HORIZONTAL)
        binding.recyclerMaaltijdOnderdelen.addItemDecoration(itemDecor)

        /**
         * ViewModel Observers:
         *      Observeren van maaltijdonderdelen en toevoegen aan RecyclerView
         */
        viewModel.maaltijdOnderdelen.observe(this, Observer{ lijst ->
            lijst?.let{
                binding.searchView.visibility = VISIBLE
                if(it.size > 0){
                    binding.noItemsText.visibility = GONE
                    binding.recyclerMaaltijdOnderdelen.visibility = VISIBLE
                    adapter.submitList(lijst)
                }
                else{
                    binding.recyclerMaaltijdOnderdelen.visibility = GONE
                    if(binding.searchView.query.isNullOrEmpty()){
                        binding.noItemsText.text = resources.getString(R.string.no_items_available)
                        binding.searchView.visibility = GONE
                    }
                    else{
                        binding.noItemsText.text = resources.getString(R.string.no_items_search)
                    }
                    binding.noItemsText.visibility = VISIBLE
                }
            }
        })
        /**
         * UI onClickListener voor het toevoegen van een nieuw maaltijdonderdeel
         */
        binding.addMaaltijdOnderdeelButton.setOnClickListener {
            addMaaltijdOnderdeel()
        }
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
         * Actionbar title
         */
        val activity = getActivity() as MainActivity
        activity.setCustomActionBar("maaltijdonderdelenoverzicht")
        /**
         * Other
         */
        this.setHasOptionsMenu(true)

        return binding.root

    }
    /**
     * Deze functie toont een [AlertDialog] waarbij de naam van het nieuw maaltijdonderdeel gevraagd wordt.
     * Het maaltijdonderdeel wordt aangemaakt en gepersisteerd via [MaaltijdOnderdeelOverzichtViewModel].
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

}
