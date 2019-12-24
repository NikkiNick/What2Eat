package android.com.what2eat.fragments

import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.adapters.MaaltijdAdapter
import android.com.what2eat.adapters.MaaltijdListener
import android.com.what2eat.databinding.FragmentMaaltijdOverzichtBinding
import android.com.what2eat.viewmodels.MaaltijdOverzichtViewModel
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.text.InputType
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.snackbar.Snackbar

/**
 * [Fragment] voor maaltijdoverzicht
 */
class MaaltijdOverzichtFragment : Fragment() {
    /**
     * Fragment Properties
     */
    private lateinit var binding: FragmentMaaltijdOverzichtBinding
    private lateinit var viewModel: MaaltijdOverzichtViewModel
    /*
     * Functie die wordt opgeroepen wanneer het [Fragment] aangemaakt wordt en in CREATED lifecycle state is.
     * Fragment properties worden hier geïnstantieerd.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(MaaltijdOverzichtViewModel::class.java)
        super.onCreate(savedInstanceState)
    }
    /**
     * Functie die wordt opgeroepen wanneer het [Fragment] aangemaakt wordt en in CREATED lifecycle state is.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        /**
         * DataBinding : layout inflation, viewModel binding and initialisatie.
         */
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_overzicht, container, false)
        binding.setLifecycleOwner(this)
        binding.maaltijden = viewModel
        viewModel.initMaaltijden()
        /**
         * RecyclerView setup voor lijst van maaltijden inclusief [DividerItemDecoration].
         */
        val adapter = MaaltijdAdapter(MaaltijdListener{
                maaltijdId -> viewModel.onMaaltijdClicked(maaltijdId)
        })
        binding.recyclerMaaltijden.adapter = adapter
        val itemDecor = DividerItemDecoration(context, HORIZONTAL)
        binding.recyclerMaaltijden.addItemDecoration(itemDecor)
        /**
         * ViewModel Observers:
         *      Observeren van maaltijden en toevoegen aan RecyclerView
         *      Observeren wanneer er geklikt wordt op een maaltijd om door te gaan naar detail scherm.
         */
        viewModel.maaltijden.observe(this, Observer{ lijst ->
            lijst?.let{
                binding.searchView.visibility = VISIBLE
                if(it.size > 0){
                    binding.noItemsText.visibility = GONE
                    binding.recyclerMaaltijden.visibility = VISIBLE
                    adapter.submitList(lijst)
                }
                else{
                    binding.recyclerMaaltijden.visibility = GONE
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
        viewModel.navigateToMaaltijdDetail.observe(this, Observer{maaltijd ->
            maaltijd?.let{
                this.findNavController().navigate(MaaltijdOverzichtFragmentDirections.actionMaaltijdOverzichtFragmentToMaaltijdDetailFragment(maaltijd))
                viewModel.onDetailNavigated()
            }
        })
        viewModel.navigateToMaaltijdEdit.observe(this, Observer{maaltijdId ->
            maaltijdId?.let{
                this.findNavController().navigate(MaaltijdOverzichtFragmentDirections.actionMaaltijdOverzichtFragmentToMaaltijdEditFragment(it, null))
            }
        })
        /**
         * UI OnClickListener voor Add button voor het toevoegen van een nieuwe maaltijd.
         */
        binding.addMaaltijdButton.setOnClickListener{
            show_addMaaltijdDialog()
        }
        /**
         * SearchView
         */
        val searchView: SearchView = binding.searchView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.filterMaaltijden(newText)
                return false
            }
        })
        /**
         * ToolBar title
         */
        val activity = getActivity() as MainActivity
        activity.setCustomActionBar("maaltijdoverzicht")
        /**
         * Other
         */

        return binding.root

    }
    /**
     * Deze functie toont een [AlertDialog] waarbij de naam van de nieuwe maaltijd gevraagd wordt.
     * De maaltijd wordt aangemaakt en gepersisteerd via [MaaltijdOverzichtViewModel].
     */
    private fun show_addMaaltijdDialog(){

        val builder = AlertDialog.Builder(this.context!!)
        builder.setTitle(R.string.add_new_meal)

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
            viewModel.addMaaltijd(input.text.toString())
        }
        builder.setNegativeButton(R.string.cancel) { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
        input.requestFocus()
    }

    /**
     * Deze functie wordt gebruikt om een SnackBar met bericht weer te geven
     */
    private fun showSnackBar(message: String){
        val snackbar: Snackbar = Snackbar.make(getActivity()!!.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
        val view: View = snackbar.view
        val textView: TextView = view.findViewById(R.id.snackbar_text)
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER)
        snackbar.show()
    }
    /**
     * Deze functie wordt opgeroepen wanneer het STARTED lifecycle wordt ingegaan door het [Fragment].
     * Input van [SearchView] wordt gereset.
     */
    override fun onStart() {
        super.onStart()
        binding.searchView.setQuery("", false)
        binding.searchView.clearFocus()
    }
}
