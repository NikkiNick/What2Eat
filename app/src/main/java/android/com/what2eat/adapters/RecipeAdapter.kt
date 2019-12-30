package android.com.what2eat.adapters

import android.com.what2eat.databinding.RecipeItemViewBinding
import android.com.what2eat.network.Recipe
import android.com.what2eat.network.RecipeData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
/**
 * RecyclerView Adapter die gebruikt wordt voor het aanmaken en databinding van ViewHolders voor
 * het weergeven van een lijst van [Recipe] (inclusief clickListener ([RecipeListener]]). Inclusief
 * een diffCallBack ([RecipeDiffCallback] voor betere RecyclerView-performantie)
 * @constructor Constructor voor het aanmaken van een [RecipeAdapter] (ListAdapter)
 * @param clickListener ClickListener die gebruikt wordt voor het afhandelen van user-events (onClick) op een [Recipe] in de lijst
 * @see [RecipeAdapter.ViewHolder]
 * @see [RecipeDiffCallback]
 */
class RecipeAdapter(val clickListener: RecipeListener): ListAdapter<Recipe, RecipeAdapter.ViewHolder>(RecipeDiffCallback()){
    /**
     * Deze functie wordt gebruikt om een [Recipe] en [RecipeListener] te binden aan de custom
     *  ViewHolder ([RecipeAdapter.ViewHolder])
     * @param holder Custom ViewHolder voor het bijhouden van een [Recipe] met [RecipeListener]
     * @param position Huidige positie in de lijst waar de ViewHolder moet geplaatst worden
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }
    /**
     * Deze functie wordt gebruikt om de ViewHolder aan te maken.
     * @param parent Parent waartoe de ViewHolder behoord
     * @param viewType
     * @return Custom ViewHolder
     * @see [RecipeAdapter.ViewHolder]
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }
    /**
     * Custom ViewHolder class die gebruikt wordt in de RecyclerView.
     * @constructor Constructor voor het aanmaken van de custom ViewHolder
     * @param binding LayoutBinding die gebruikt wordt door de ViewHolder
     */
    class ViewHolder private constructor(val binding: RecipeItemViewBinding): RecyclerView.ViewHolder(binding.root){

        companion object {
            /**
             * Deze functie wordt gebruikt om de layout te binden aan de ViewHolder
             * @param parent Parent waartoe de ViewHolder behoord
             * @return ViewHolder
             */
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecipeItemViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
        /**
         * Deze functie wordt gebruikt om een [Recipe] en [RecipeListener] te binden aan de ViewHolder
         * @param item [Recipe] die aan de ViewHolder gebind wordt
         * @param clickListener [RecipeListener] die aan de ViewHolder gebindt wordt
         */
        fun bind(item: Recipe, clickListener: RecipeListener) {
            binding.recipe = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

}
/**
 * Deze class verbeterd de performantie in een RecyclerView om verschillen tussen de [Recipe]
 * beter te kunnen uitmaken.
 * @constructor Constructor voor het aanmaken van de [RecipeDiffCallback] (DiffUtil.ItemCallback)
 */
class RecipeDiffCallback: DiffUtil.ItemCallback<Recipe>(){
    /**
     * Deze functie bekijkt of 2 objecten ([Recipe]) dezelfde te zijn door beide id's te vergelijken
     * @param oldItem [Recipe] 1
     * @param newItem [Recipe] 2
     * @return Boolean
     */
    override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem.recipe.naam == newItem.recipe.naam
    }
    /**
     * Deze functie bekijkt of de inhoud van 2 objecten ([Recipe]) dezelfde te zijn
     * @param oldItem Ingredient 1 (String)
     * @param newItem Ingredient 2 (String)
     * @return Boolean
     */
    override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem.equals(newItem)
    }
}
/**
 * Listener die gebruikt wordt om user-events op items in de RecyclerView af te handelen.
 * Wanneer de gebruiker op een [Recipe] clickt in de RecyclerView wordt de [RecipeData] teruggegeven.
 * @constructor Constructor voor het aanmaken van een [RecipeListener]
 * @param clickListener
 */
class RecipeListener(val clickListener: (recipe: RecipeData) -> Unit) {
    fun onClick(recipe: Recipe) = clickListener(recipe.recipe)
}