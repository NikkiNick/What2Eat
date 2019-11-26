package android.com.what2eat.fragments

import android.app.Application
import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.adapters.MaaltijdAdapter
import android.com.what2eat.adapters.MaaltijdListener
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.database.MaaltijdDatabaseDao
import android.com.what2eat.databinding.FragmentMaaltijdOverzichtBinding
import android.com.what2eat.viewmodels.MaaltijdOverzichtViewModel
import android.com.what2eat.viewmodels.MaaltijdOverzichtViewModelFactory
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_maaltijd_add.view.*


class MaaltijdOverzichtFragment : Fragment() {

    private lateinit var binding: FragmentMaaltijdOverzichtBinding
    private lateinit var viewModelFactory: MaaltijdOverzichtViewModelFactory
    private lateinit var viewModel: MaaltijdOverzichtViewModel
    private lateinit var dataSource: MaaltijdDatabaseDao
    private lateinit var application: Application

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        application = requireNotNull(this.activity).application
        dataSource = MaaltijdDatabase.getInstance(application).maaltijdDatabaseDao

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_overzicht, container, false)
        viewModelFactory = MaaltijdOverzichtViewModelFactory(dataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MaaltijdOverzichtViewModel::class.java)

        val adapter = MaaltijdAdapter(MaaltijdListener{
                maaltijdId -> viewModel.onMaaltijdClicked(maaltijdId)
        })
        binding.recyclerMaaltijden.adapter = adapter
        val itemDecor = DividerItemDecoration(context, HORIZONTAL)
        binding.recyclerMaaltijden.addItemDecoration(itemDecor)

        binding.maaltijden = viewModel
        viewModel.initMaaltijden()

        viewModel.maaltijden.observe(this, Observer{ lijst ->
                lijst?.let{
                    adapter.submitList(lijst)
                }
        })
        viewModel.navigateToMaaltijdDetail.observe(this, Observer{maaltijd ->
            maaltijd?.let{
                this.findNavController().navigate(MaaltijdOverzichtFragmentDirections.actionMaaltijdOverzichtFragmentToMaaltijdDetailFragment(maaltijd))
                viewModel.onDetailNavigated()
            }
        })
        binding.addMealButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_maaltijdOverzichtFragment_to_addMaaltijd_StartFragment)
        }
        val searchView: SearchView = binding.searchView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean { // do something on text submit
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean { // do something when text changes
                viewModel.filterMaaltijden(newText)
                return false
            }
        })

        binding.setLifecycleOwner(this)

        val activity = getActivity() as MainActivity
        activity.setCustomActionBar("maaltijdoverzicht")

        this.setHasOptionsMenu(true)

        return binding.root

    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.maaltijden.removeObservers(this)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.maaltijdoverzicht_overflowmenu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.deleteAll_menuItem -> deleteMaaltijden()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteMaaltijden(){

        MaterialAlertDialogBuilder(context)
            .setTitle(R.string.confirmation_delete_title)
            .setMessage(R.string.confirmation_delete_content)
            .setPositiveButton(resources.getString(R.string.ok)){ dialog, num ->
                viewModel.clearMaaltijden()
                Toast.makeText(
                    application.applicationContext,
                    resources.getString(R.string.deletedAllMeals),
                    Toast.LENGTH_LONG
                ).show()
            }
            .setNegativeButton(resources.getString(R.string.cancel)){ dialog, num -> }
            .show()

    }

    override fun onStart() {
        super.onStart()
        binding.searchView.setQuery("", false)
        binding.searchView.clearFocus()
    }
}
