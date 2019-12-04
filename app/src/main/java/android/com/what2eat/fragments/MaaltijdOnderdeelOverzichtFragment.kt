package android.com.what2eat.fragments


import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment

import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.adapters.MaaltijdListener
import android.com.what2eat.adapters.MaaltijdOnderdeelCheckBoxAdapter
import android.com.what2eat.adapters.MaaltijdOnderdeelListener
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.database.MaaltijdMaaltijdOnderdeelDao
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.databinding.FragmentMaaltijdOnderdeelOverzichtBinding
import android.com.what2eat.viewmodels.MaaltijdOnderdeelOverzichtViewModel
import android.com.what2eat.viewmodels.MaaltijdOnderdeelOverzichtViewModelFactory
import android.com.what2eat.viewmodels.MaaltijdViewModel
import android.com.what2eat.viewmodels.MaaltijdViewModelFactory
import android.graphics.drawable.ClipDrawable
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration

class MaaltijdOnderdeelOverzichtFragment : Fragment() {

    private lateinit var binding: FragmentMaaltijdOnderdeelOverzichtBinding
    private lateinit var viewModelFactory: MaaltijdOnderdeelOverzichtViewModelFactory
    private lateinit var viewModel: MaaltijdOnderdeelOverzichtViewModel
    private lateinit var dataSource: MaaltijdOnderdeelDao
    private lateinit var application: Application

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        application = requireNotNull(this.activity).application
        dataSource = MaaltijdDatabase.getInstance(application).maaltijdOnderdeelDao

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_onderdeel_overzicht, container, false)
        val args = MaaltijdOnderdeelOverzichtFragmentArgs.fromBundle(arguments!!)

        viewModelFactory = MaaltijdOnderdeelOverzichtViewModelFactory(dataSource, args.maaltijdId,  application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MaaltijdOnderdeelOverzichtViewModel::class.java)

        var tempCheckedIds = mutableListOf<Long>()

        val adapter = MaaltijdOnderdeelCheckBoxAdapter(MaaltijdOnderdeelListener {
            if(tempCheckedIds.contains(it)){
                tempCheckedIds.remove(it)
            }else {
                tempCheckedIds.add(it)
            }
        })
        binding.addMaaltijdOnderdelenButton.setOnClickListener{
            it.findNavController().navigate(MaaltijdOnderdeelOverzichtFragmentDirections.actionMaaltijdOnderdeelOverzichtFragmentToMaaltijdEditFragment(args.maaltijdId, tempCheckedIds.toLongArray()))
        }
        binding.recyclerMaaltijdOnderdelen.adapter = adapter
        val itemDecor = DividerItemDecoration(context, ClipDrawable.HORIZONTAL)
        binding.recyclerMaaltijdOnderdelen.addItemDecoration(itemDecor)

        viewModel.initMaaltijdOnderdelen()

        viewModel.maaltijdOnderdelen.observe(this, Observer{ lijst ->
            lijst?.let{
                adapter.submitList(lijst)
            }
        })
        val searchView: SearchView = binding.searchView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean { // do something on text submit
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean { // do something when text changes
                viewModel.filterMaaltijdOnderdelen(newText)
                return false
            }
        })

        binding.setLifecycleOwner(this)

        val activity = getActivity() as MainActivity
        activity.setCustomActionBar("maaltijdonderdelenoverzicht")

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