package android.com.what2eat.fragments


import android.com.what2eat.R
import android.com.what2eat.adapters.RecipeAdapter
import android.com.what2eat.adapters.RecipeListener
import android.com.what2eat.databinding.FragmentMaaltijdOnderdeelInspiratieBinding
import android.com.what2eat.utils.NetworkUtil
import android.com.what2eat.viewmodels.RecipeOverzichtViewModel
import android.com.what2eat.viewmodels.viewModelFactories.RecipeOverzichtViewModelFactory
import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration


/**
 * Fragment voor recipeoverzicht
 * @property binding Binding object van het fragment
 * @property viewModelFactory [RecipeOverzichtViewModelFactory] dat gebruikt wordt om [RecipeOverzichtViewModel] aan te maken
 * @property viewModel [RecipeOverzichtViewModel] dat gebruikt wordt in het fragment voor business logica
 */
class RecipeOverzichtFragment : Fragment() {

    /**
     * Fragment Properties
     */
    private lateinit var binding: FragmentMaaltijdOnderdeelInspiratieBinding
    private lateinit var viewModel: RecipeOverzichtViewModel
    private lateinit var viewModelFactory: RecipeOverzichtViewModelFactory

    /**
     * Functie die wordt opgeroepen wanneer het fragment aangemaakt wordt en in CREATED lifecycle state is.
     * Fragment properties worden hier geïnstantieerd.
     * @param savedInstanceState Bundel die gebruikt wordt om data terug in het fragment te initialiseren.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        val args = RecipeOverzichtFragmentArgs.fromBundle(arguments!!)
        viewModelFactory =
            RecipeOverzichtViewModelFactory(
                args.recipeNaam
            )
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RecipeOverzichtViewModel::class.java)
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_onderdeel_inspiratie, container, false)

        /**
         * RecyclerView setup voor lijst van recepten inclusief DividerItemDecoration
         */
        val adapter = RecipeAdapter(RecipeListener { recipe ->
            findNavController().navigate(RecipeOverzichtFragmentDirections.actionRecipeOverzichtFragmentToRecipeDetailFragment(recipe))
        })
        binding.recyclerRecipes.adapter = adapter
        val itemDecor = DividerItemDecoration(context, ClipDrawable.HORIZONTAL)
        binding.recyclerRecipes.addItemDecoration(itemDecor)

        /**
         * Aanpassen van UI indien er geen Internet verbinding is.
         */
        if(!NetworkUtil().isInternetAvailable(context!!)){
            binding.loadingLayout.visibility = GONE
            binding.noconnectionLayout.visibility = VISIBLE
            binding.recyclerLayout.visibility = GONE
        }

        /**
         * ViewModel Observer voor opvangen van API responses in het [RecipeOverzichtViewModel].
         * Loading spinner wordt weergegeven bij het wachten op de responses.
         */
        viewModel.response.observe(this, Observer { lijst ->
            binding.loadingLayout.visibility = VISIBLE
            lijst?.let{
                binding.loadingLayout.visibility = GONE
                if(it.size == 0){
                    binding.noitemsText.visibility = VISIBLE
                    binding.recyclerRecipes.visibility = GONE
                }
                else{
                    binding.recyclerRecipes.visibility = VISIBLE
                    binding.noitemsText.visibility = GONE
                    adapter.submitList(it)
                }
            }
        })

        /**
         * Other
         */
        return binding.root
    }

}
