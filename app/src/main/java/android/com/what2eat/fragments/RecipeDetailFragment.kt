package android.com.what2eat.fragments

import android.com.what2eat.R
import android.com.what2eat.adapters.IngredientAdapter
import android.com.what2eat.databinding.FragmentRecipeDetailBinding
import android.com.what2eat.utils.NetworkUtil
import android.com.what2eat.viewmodels.RecipeDetailViewModel
import android.com.what2eat.viewmodels.viewModelFactories.RecipeDetailViewModelFactory
import android.content.Intent
import android.graphics.drawable.ClipDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration

/**
 * Fragment voor het weergeven van detail van een (extern) recept
 * @property binding Binding object van het fragment
 * @property viewModelFactory [RecipeDetailViewModelFactory] dat gebruikt wordt om [RecipeDetailViewModel] aan te maken
 * @property viewModel [RecipeDetailViewModel] dat gebruikt wordt in het fragment voor business logica
 */
class RecipeDetailFragment : Fragment() {

    /**
     * Fragment Properties
     */
    private lateinit var binding: FragmentRecipeDetailBinding
    private lateinit var viewModel: RecipeDetailViewModel
    private lateinit var viewModelFactory: RecipeDetailViewModelFactory

    /**
     * Functie die wordt opgeroepen wanneer het fragment aangemaakt wordt en in CREATED lifecycle state is.
     * Fragment properties worden hier geïnstantieerd.
     * @param savedInstanceState Bundel die gebruikt wordt om data terug in het fragment te initialiseren.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        val args = RecipeDetailFragmentArgs.fromBundle(arguments!!)
        viewModelFactory =
            RecipeDetailViewModelFactory(
                args.recipe
            )
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RecipeDetailViewModel::class.java)
        super.onCreate(savedInstanceState)
    }

    /**
     * Functie die wordt opgeroepen wanneer het fragment aangemaakt wordt en in CREATED lifecycle state is.
     * Setup van DataBinding, RecyclerView, ViewModel Observers, UI ClickListeners, ActionBar
     * @param inflater LayoutInflater
     * @param container ViewGroup
     * @param savedInstanceState Bundle
     * @return View
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /**
         * DataBinding : layout inflation, viewModel binding.
         */
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipe_detail, container, false)
        binding.setLifecycleOwner(this)
        binding.recipe = viewModel.recipe

        /**
         * RecyclerView setup voor het tonen van de RecyclerView van ingredienten van de huidige recept.
         */
        val adapter = IngredientAdapter()
        binding.ingredientsRecyclerView.adapter = adapter
        val itemDecor = DividerItemDecoration(context, ClipDrawable.HORIZONTAL)
        binding.ingredientsRecyclerView.addItemDecoration(itemDecor)
        adapter.submitList(viewModel.recipe.ingredienten)

        /**
         * Aanpassen van UI indien er geen Internet verbinding is.
         */
        if(!NetworkUtil().isInternetAvailable(context!!)){
            binding.noconnectionLayout.visibility = View.VISIBLE
            binding.visitButton.isEnabled = false
        }

        /**
         * UI clickListener voor de search online (inspiratie) button.
         * @see startIntent
         *
         */
        binding.visitButton.setOnClickListener {
            startIntent()
        }

        return binding.root
    }

    /**
     * Deze functie wordt gebruikt om de intent te starten om een externe website te bezoeken.
     */
    private fun startIntent(){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(viewModel.recipe.remote_site_url)
        startActivity(intent)
    }

}
