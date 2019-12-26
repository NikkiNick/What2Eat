package android.com.what2eat.fragments


import android.com.what2eat.R
import android.com.what2eat.adapters.RecipeAdapter
import android.com.what2eat.adapters.RecipeListener
import android.com.what2eat.databinding.FragmentMaaltijdOnderdeelInspiratieBinding
import android.com.what2eat.utils.NetworkUtil
import android.com.what2eat.viewmodels.RecipeApiViewModel
import android.com.what2eat.viewmodels.RecipeApiViewModelFactory
import android.content.Context
import android.graphics.drawable.ClipDrawable
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration


/**
 * A simple [Fragment] subclass.
 */
class RecipeOverzichtFragment : Fragment() {

    private lateinit var binding: FragmentMaaltijdOnderdeelInspiratieBinding
    private lateinit var viewModel: RecipeApiViewModel
    private lateinit var viewModelFactory: RecipeApiViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_onderdeel_inspiratie, container, false)
        val args = RecipeOverzichtFragmentArgs.fromBundle(arguments!!)
        viewModelFactory = RecipeApiViewModelFactory(args.recipeNaam)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RecipeApiViewModel::class.java)
        /**
         * RecyclerView setup voor lijst van maaltijden inclusief [DividerItemDecoration].
         */
        val adapter = RecipeAdapter(RecipeListener { recipe ->
            findNavController().navigate(RecipeOverzichtFragmentDirections.actionRecipeOverzichtFragmentToRecipeDetailFragment(recipe))
        })
        binding.recyclerRecipes.adapter = adapter
        val itemDecor = DividerItemDecoration(context, ClipDrawable.HORIZONTAL)
        binding.recyclerRecipes.addItemDecoration(itemDecor)

        if(!NetworkUtil().isInternetAvailable(context!!)){
            binding.loadingLayout.visibility = GONE
            binding.noconnectionLayout.visibility = VISIBLE
            binding.recyclerLayout.visibility = GONE
        }
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
