package android.com.what2eat.fragments


import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment

import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.database.MaaltijdMaaltijdOnderdeelDao
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.databinding.FragmentMaaltijdDetailBinding
import android.com.what2eat.viewmodels.MaaltijdDetailViewModel
import android.com.what2eat.viewmodels.MaaltijdDetailViewModelFactory
import android.util.Log
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import java.lang.StringBuilder

/**
 * A simple [Fragment] subclass.
 */
class MaaltijdDetailFragment : Fragment() {

    private lateinit var binding: FragmentMaaltijdDetailBinding
    private lateinit var viewModelFactory: MaaltijdDetailViewModelFactory
    private lateinit var viewModel: MaaltijdDetailViewModel
    private lateinit var application: Application
    private lateinit var maaaltijdDataSource: MaaltijdDao
    private lateinit var maaltijdOnderdeelDataSource: MaaltijdOnderdeelDao
    private lateinit var maaltijdMaaltijdOnderdeelDataSource: MaaltijdMaaltijdOnderdeelDao

    override fun onCreate(savedInstanceState: Bundle?) {
        application = requireNotNull(this.activity).application
        maaaltijdDataSource = MaaltijdDatabase.getInstance(application).maaltijdDao
        maaltijdOnderdeelDataSource = MaaltijdDatabase.getInstance(application).maaltijdOnderdeelDao
        maaltijdMaaltijdOnderdeelDataSource = MaaltijdDatabase.getInstance(application).maaltijdMaaltijdOnderdeelDao
        val args = MaaltijdDetailFragmentArgs.fromBundle(arguments!!)
        viewModelFactory = MaaltijdDetailViewModelFactory(args.maaltijdId, maaaltijdDataSource,maaltijdOnderdeelDataSource, maaltijdMaaltijdOnderdeelDataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MaaltijdDetailViewModel::class.java)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_detail, container, false)
        binding.lifecycleOwner = this
        binding.maaltijd = viewModel

        binding.editMealButton.setOnClickListener{
            it.findNavController().navigate(MaaltijdDetailFragmentDirections.actionMaaltijdDetailFragmentToMaaltijdEditFragment(viewModel.maaltijdId))
        }
        viewModel.maaltijdOnderdelen.observe(this, Observer {
            if(it?.size == 0){
                binding.maaltijdOnderdelenTitleText.visibility = GONE
                binding.maaltijdonderdelenText.text = resources.getString(R.string.no_mealparts_available)
            } else {
                binding.maaltijdOnderdelenTitleText.visibility = VISIBLE
                val str = StringBuilder()
                it?.forEach { mo -> str.append(mo.naam) }
                binding.maaltijdonderdelenText.text = str
            }
        })
        val act = activity as MainActivity
        act.setCustomActionBar("maaltijddetail")

        return binding.root
    }


}
