package android.com.what2eat.fragments


import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R
import android.com.what2eat.adapters.MaaltijdAdapter
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.database.MaaltijdDatabaseDao
import android.com.what2eat.databinding.FragmentMaaltijdDetailBinding
import android.com.what2eat.viewmodels.MaaltijdDetailViewModel
import android.com.what2eat.viewmodels.MaaltijdDetailViewModelFactory
import android.com.what2eat.viewmodels.MaaltijdViewModel
import android.com.what2eat.viewmodels.MaaltijdViewModelFactory
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

/**
 * A simple [Fragment] subclass.
 */
class MaaltijdDetailFragment : Fragment() {

    private lateinit var binding: FragmentMaaltijdDetailBinding
    private lateinit var viewModelFactory: MaaltijdDetailViewModelFactory
    private lateinit var viewModel: MaaltijdDetailViewModel
    private lateinit var application: Application
    private lateinit var dataSource: MaaltijdDatabaseDao

    override fun onCreate(savedInstanceState: Bundle?) {
        application = requireNotNull(this.activity).application
        dataSource = MaaltijdDatabase.getInstance(application).maaltijdDatabaseDao
        val args = MaaltijdDetailFragmentArgs.fromBundle(arguments!!)
        viewModelFactory = MaaltijdDetailViewModelFactory(args.maaltijdId, dataSource, application)
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

        return binding.root
    }

}
