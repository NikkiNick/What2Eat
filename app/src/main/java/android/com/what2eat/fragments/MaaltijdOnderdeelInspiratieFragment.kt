package android.com.what2eat.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R
import android.com.what2eat.adapters.MaaltijdAdapter
import android.com.what2eat.adapters.MaaltijdListener
import android.com.what2eat.adapters.RecipeAdapter
import android.com.what2eat.databinding.FragmentMaaltijdOnderdeelInspiratieBinding
import android.com.what2eat.viewmodels.RecipeApiViewModel
import android.graphics.drawable.ClipDrawable
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration

/**
 * A simple [Fragment] subclass.
 */
class MaaltijdOnderdeelInspiratieFragment : Fragment() {

    private lateinit var binding: FragmentMaaltijdOnderdeelInspiratieBinding
    private lateinit var viewModel: RecipeApiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_onderdeel_inspiratie, container, false)
        viewModel = ViewModelProviders.of(this).get(RecipeApiViewModel::class.java)
        /**
         * RecyclerView setup voor lijst van maaltijden inclusief [DividerItemDecoration].
         */
        val adapter = RecipeAdapter()
        binding.recyclerRecipes.adapter = adapter
        val itemDecor = DividerItemDecoration(context, ClipDrawable.HORIZONTAL)
        binding.recyclerRecipes.addItemDecoration(itemDecor)

        viewModel.response.observe(this, Observer { lijst ->
            binding.loadingLayout.visibility = VISIBLE
            lijst?.let{
                binding.loadingLayout.visibility = GONE
                if(it.size == 0){
                    binding.noitemsText.visibility = VISIBLE
                    binding.recyclerLayout.visibility = GONE
                }
                else{
                    binding.recyclerLayout.visibility = VISIBLE
                    binding.noitemsText.visibility = GONE
                    adapter.submitList(it)
                }
            }
        })

        return binding.root
    }


}
