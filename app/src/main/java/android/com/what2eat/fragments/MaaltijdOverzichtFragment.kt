package android.com.what2eat.fragments


import android.app.Application
import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.database.MaaltijdDatabaseDao
import android.com.what2eat.databinding.FragmentMaaltijdOverzichtBinding
import android.com.what2eat.viewmodels.MaaltijdOverzichtViewModel
import android.com.what2eat.viewmodels.MaaltijdOverzichtViewModelFactory
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController

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

        binding.addMealButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_maaltijdOverzichtFragment_to_addMaaltijdActivity)
        }

        viewModelFactory = MaaltijdOverzichtViewModelFactory(dataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MaaltijdOverzichtViewModel::class.java)

        binding.maaltijden = viewModel

        val activity = getActivity() as MainActivity
        activity.setCustomActionBar("maaltijdoverzicht")

        this.setHasOptionsMenu(true)

        binding.setLifecycleOwner(this)

        return binding.root

    }

    override fun onStart() {
        super.onStart()
        viewModel.maaltijden.observe(this, Observer{ lijst ->
            lijst?.let{
                val iter = lijst.iterator()
                val str = StringBuilder()
                iter.forEach { maaltijd ->  str.append(maaltijd.naam+"("+maaltijd.rating+") - ")}
                binding.maaltijdenText.text = str.toString()
            }
        })
    }

    override fun onStop() {
        super.onStop()
        viewModel.maaltijden.removeObservers(this)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.maaltijdoverzicht_overflowmenu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.deleteAll_menuItem -> {
                viewModel.clearMaaltijden()
                Toast.makeText(
                    application.applicationContext,
                    resources.getString(R.string.deletedAllMeals),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
