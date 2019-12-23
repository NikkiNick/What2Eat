package android.com.what2eat.fragments


import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment

import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.adapters.MaaltijdOnderdeelCheckBoxAdapter
import android.com.what2eat.adapters.MaaltijdOnderdeelListener
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.databinding.FragmentMaaltijdOnderdeelSelectBinding
import android.com.what2eat.model.MaaltijdOnderdeel
import android.com.what2eat.viewmodels.MaaltijdOnderdeelSelectViewModel
import android.com.what2eat.viewmodels.MaaltijdOnderdeelSelectViewModelFactory
import android.graphics.drawable.ClipDrawable
import android.view.*
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
/**
 * [Fragment] voor een maaltijdonderdeeloverzicht met multiple selection
 */
class MaaltijdOnderdeelSelectFragment : Fragment() {
    /**
     * [Fragment] Properties
     */
    private lateinit var binding: FragmentMaaltijdOnderdeelSelectBinding
    private lateinit var viewModelFactory: MaaltijdOnderdeelSelectViewModelFactory
    private lateinit var viewModel: MaaltijdOnderdeelSelectViewModel
    private lateinit var dataSource: MaaltijdOnderdeelDao
    private lateinit var application: Application
    val tempCheckedIds = mutableListOf<Long>()
    private lateinit var args: MaaltijdOnderdeelSelectFragmentArgs
        /**
     * Functie die wordt opgeroepen wanneer het [Fragment] aangemaakt wordt en in CREATED lifecycle state is.
     * Fragment properties worden hier geïnstantieerd.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        application = requireNotNull(this.activity).application
        dataSource = MaaltijdDatabase.getInstance(application).maaltijdOnderdeelDao
        args = MaaltijdOnderdeelSelectFragmentArgs.fromBundle(arguments!!)
        viewModelFactory = MaaltijdOnderdeelSelectViewModelFactory(dataSource, args.maaltijdId,  application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MaaltijdOnderdeelSelectViewModel::class.java)
        super.onCreate(savedInstanceState)
    }
    /**
     * Functie die wordt opgeroepen wanneer het [Fragment] aangemaakt wordt en in CREATED lifecycle state is.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        /**
         * DataBinding : layout inflation, viewModel binding
         */
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_onderdeel_select, container, false)
        binding.setLifecycleOwner(this)
        viewModel.initMaaltijdOnderdelen()
        /**
         * RecyclerView SetUp
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

        return binding.root

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.maaltijdOnderdelen.removeObservers(this)
    }

    override fun onStart() {
        super.onStart()
        binding.searchView.setQuery("", false)
        binding.searchView.clearFocus()
    }
}