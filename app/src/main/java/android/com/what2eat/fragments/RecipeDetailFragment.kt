package android.com.what2eat.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R
import android.com.what2eat.adapters.IngredientAdapter
import android.com.what2eat.adapters.RecipeAdapter
import android.com.what2eat.databinding.FragmentRecipeDetailBinding
import android.com.what2eat.viewmodels.RecipeDetailViewModel
import android.com.what2eat.viewmodels.RecipeDetailViewModelFactory
import android.graphics.drawable.ClipDrawable
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration

class RecipeDetailFragment : Fragment() {

    private lateinit var binding: FragmentRecipeDetailBinding
    private lateinit var viewModel: RecipeDetailViewModel
    private lateinit var viewModelFactory: RecipeDetailViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        val args = RecipeDetailFragmentArgs.fromBundle(arguments!!)
        viewModelFactory = RecipeDetailViewModelFactory(args.recipe)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RecipeDetailViewModel::class.java)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipe_detail, container, false)
        binding.setLifecycleOwner(this)
        binding.recipe = viewModel.recipe
        /**
         * RecyclerView setup voor het tonen van de [RecyclerView] van ingredienten van de huidige recept.
         */
        val adapter = IngredientAdapter()
        binding.ingredientsRecyclerView.adapter = adapter
        val itemDecor = DividerItemDecoration(context, ClipDrawable.HORIZONTAL)
        binding.ingredientsRecyclerView.addItemDecoration(itemDecor)
        adapter.submitList(viewModel.recipe.ingredienten)

        return binding.root
    }

}
