package android.com.what2eat.fragments


import android.app.Application
import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.database.MaaltijdDatabaseDao
import android.com.what2eat.databinding.FragmentMaaltijdOverzichtBinding
import android.com.what2eat.viewmodels.MaaltijdOverzichtViewModel
import android.com.what2eat.viewmodels.MaaltijdOverzichtViewModelFactory
import android.com.what2eat.viewmodels.MaaltijdViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        binding.setLifecycleOwner(this)
        viewModelFactory = MaaltijdOverzichtViewModelFactory(dataSource, application)
        viewModel = ViewModelProviders.of(this.activity!!, viewModelFactory).get(MaaltijdOverzichtViewModel::class.java)

        viewModel.maaltijden.observe(this, Observer{ lijst ->
            Log.i("Aantal", "Changes observed")
            lijst?.let{
                val iter = lijst.iterator()
                val str = StringBuilder()
                iter.forEach { maaltijd ->  str.append(maaltijd.naam+"("+maaltijd.rating+") - ")}
                binding.maaltijdenText.text = str.toString()
            }
        })

        binding.maaltijden = viewModel

        val activity = getActivity() as MainActivity
        activity.setCustomActionBar("maaltijdoverzicht")

        return binding.root

    }

}
