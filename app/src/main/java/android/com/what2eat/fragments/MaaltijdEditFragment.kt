package android.com.what2eat.fragments


import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.adapters.MaaltijdOnderdeelAdapter
import android.com.what2eat.adapters.MaaltijdOnderdeelListener
import android.com.what2eat.adapters.MaaltijdOnderdeelRemoveAdapter
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.database.MaaltijdMaaltijdOnderdeelDao
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.databinding.FragmentMaaltijdEditBinding
import android.com.what2eat.viewmodels.MaaltijdDetailViewModel
import android.com.what2eat.viewmodels.MaaltijdDetailViewModelFactory
import android.graphics.drawable.ClipDrawable
import android.util.Log
import android.view.Gravity
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * A simple [Fragment] subclass.
 */
class MaaltijdEditFragment : Fragment() {

    private lateinit var binding: FragmentMaaltijdEditBinding
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
        val args = MaaltijdEditFragmentArgs.fromBundle(arguments!!)
        viewModelFactory = MaaltijdDetailViewModelFactory(args.maaltijdId, maaaltijdDataSource, maaltijdOnderdeelDataSource,maaltijdMaaltijdOnderdeelDataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MaaltijdDetailViewModel::class.java)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_edit, container, false)
        binding.lifecycleOwner = this

        val args = MaaltijdEditFragmentArgs.fromBundle(arguments!!)
        args.addMaaltijdOnderdelenIds?.let {
            viewModel.addMaaltijdOnderdelenToMaaltijd(it)
        }
        val adapter = MaaltijdOnderdeelRemoveAdapter(MaaltijdOnderdeelListener {
            Log.i("TestN", "Asked to remove MaaltijdOnderdeel "+it.toString())
            viewModel.removeMaaltijdOnderdeelFromMaaltijd(it)
        })
        binding.maaltijdOnderdelenRecycler.adapter = adapter
        val itemDecor = DividerItemDecoration(context, ClipDrawable.HORIZONTAL)
        binding.maaltijdOnderdelenRecycler.addItemDecoration(itemDecor)

        binding.maaltijd = viewModel

        viewModel.maaltijdOnderdelen.observe(viewLifecycleOwner, Observer {lijst ->
            lijst?.let {
                adapter.submitList(it)
            }
        })
        viewModel.changeRatingDisplay.observe(this, Observer{
            changeRatingDisplay(it)
        })
        viewModel.ratingString.observe(this, Observer{
            binding.ratingText.text = it
        })
        binding.editMealButton.setOnClickListener{
            viewModel.setNaam(binding.maaltijdNaam.text.toString())
            viewModel.saveMaaltijd()
            val toast = Toast.makeText(
                        application.applicationContext,
                        "${this.binding.maaltijdNaam.text.toString()} ${resources.getString(R.string.edited)}",
                        Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
            it.findNavController().navigate(MaaltijdEditFragmentDirections.actionMaaltijdEditFragmentToMaaltijdDetailFragment(viewModel.maaltijdId))
        }
        binding.addMealpartButton.setOnClickListener {
            it.findNavController().navigate(MaaltijdEditFragmentDirections.actionMaaltijdEditFragmentToMaaltijdOnderdeelOverzichtFragment(viewModel.maaltijdId))
        }/*
        binding.deleteMealButton.setOnClickListener {
            MaterialAlertDialogBuilder(context)
                .setTitle(R.string.confirmation_delete_title)
                .setMessage(R.string.confirmation_delete_meal_content)
                .setPositiveButton(resources.getString(R.string.ok)){ dialog, num ->
                    Toast.makeText(application.applicationContext,
                        "${this.binding.maaltijdNaam.text.toString()} ${resources.getString(R.string.deleted)}",
                        Toast.LENGTH_LONG).show()
                    viewModel.deleteMaaltijd()
                    it.findNavController().navigate(R.id.action_maaltijdEditFragment_to_maaltijdOverzichtFragment)
                }
                .setNegativeButton(resources.getString(R.string.cancel)){ dialog, num -> }
                .show()

        }*/
        val act = activity as MainActivity
        act.setCustomActionBar("edit_meal")

        return binding.root
    }

    private fun changeRatingDisplay(aantal: Int) {
        val starViews = listOf(
            binding.maaltijdRating1,
            binding.maaltijdRating2,
            binding.maaltijdRating3,
            binding.maaltijdRating4,
            binding.maaltijdRating5
        )
        starViews.forEach { star -> star.setImageResource(android.R.drawable.star_big_off) }
        when (aantal) {
            1 -> binding.maaltijdRating1.setImageResource(android.R.drawable.star_big_on)
            2 -> {
                binding.maaltijdRating1.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating2.setImageResource(android.R.drawable.star_big_on)
            }
            3 -> {
                binding.maaltijdRating1.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating2.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating3.setImageResource(android.R.drawable.star_big_on)
            }
            4 -> {
                binding.maaltijdRating1.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating2.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating3.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating4.setImageResource(android.R.drawable.star_big_on)
            }
            5 -> {
                binding.maaltijdRating1.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating2.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating3.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating4.setImageResource(android.R.drawable.star_big_on)
                binding.maaltijdRating5.setImageResource(android.R.drawable.star_big_on)
            }
        }
    }
}
