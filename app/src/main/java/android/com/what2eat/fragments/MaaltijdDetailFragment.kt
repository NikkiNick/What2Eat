package android.com.what2eat.fragments


import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment

import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.adapters.MaaltijdAdapter
import android.com.what2eat.adapters.MaaltijdOnderdeelAdapter
import android.com.what2eat.adapters.MaaltijdOnderdeelCheckBoxAdapter
import android.com.what2eat.adapters.MaaltijdOnderdeelListener
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.database.MaaltijdMaaltijdOnderdeelDao
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.databinding.FragmentMaaltijdDetailBinding
import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdOnderdeel
import android.com.what2eat.viewmodels.MaaltijdDetailViewModel
import android.com.what2eat.viewmodels.MaaltijdDetailViewModelFactory
import android.graphics.drawable.ClipDrawable
import android.util.Log
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
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

        val adapter = MaaltijdOnderdeelAdapter()
        binding.maaltijdOnderdelenRecyclerView.adapter = adapter
        val itemDecor = DividerItemDecoration(context, ClipDrawable.HORIZONTAL)
        binding.maaltijdOnderdelenRecyclerView.addItemDecoration(itemDecor)

        binding.editMealButton.setOnClickListener{
            it.findNavController().navigate(MaaltijdDetailFragmentDirections.actionMaaltijdDetailFragmentToMaaltijdEditFragment(viewModel.maaltijdId, null))
        }

        viewModel.maaltijdOnderdelen.observe(viewLifecycleOwner, Observer {lijst ->
            lijst?.let {
                Log.i("TestN", "Aantal onderdelen:"+it.size)
                if(lijst.size == 0){
                    binding.divider.visibility = GONE
                    binding.maaltijdOnderdelenTitleText.visibility = GONE
                    //binding.maaltijdOnderdelenRecyclerView.visibility = GONE
                }else {
                    binding.divider.visibility = VISIBLE
                    binding.maaltijdOnderdelenTitleText.visibility = VISIBLE
                    binding.maaltijdOnderdelenRecyclerView.visibility = VISIBLE
                    adapter.submitList(it)
                }
            }
        })
        val act = activity as MainActivity
        act.setCustomActionBar("maaltijddetail")

        binding.setLifecycleOwner(this)
        binding.maaltijd = viewModel

        return binding.root
    }


}
