package android.com.what2eat.adapters

import android.com.what2eat.databinding.IngredientItemViewBinding
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
 * het weergeven van een lijst van ingredienten van een recept. Inclusief een diffCallBack
 * ([MaaltijdDiffCallback] voor betere RecyclerView-performantie)
 * @constructor Constructor voor het aanmaken van een [IngredientAdapter] (ListAdapter)
 * @see [IngredientAdapter.ViewHolder]
 * @see [IngredientDiffCallback]
 */
class IngredientAdapter(): ListAdapter<String, IngredientAdapter.ViewHolder>(IngredientDiffCallback()){
    /**
     * Deze functie wordt gebruikt om een ingredient (String) te binden aan de custom
     *  ViewHolder ([IngredientAdapter.ViewHolder])
     * @param holder Custom ViewHolder voor het bijhouden van een ingredient (String)
     * @param position Huidige positie in de lijst waar de ViewHolder moet geplaatst worden
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }
    /**
     * Deze functie wordt gebruikt om de ViewHolder aan te maken.
     * @param parent Parent waartoe de ViewHolder behoord
     * @param viewType
     * @return Custom ViewHolder
     * @see [IngredientAdapter.ViewHolder]
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }
    /**
     * Custom ViewHolder class die gebruikt wordt in de RecyclerView.
     * @constructor Constructor voor het aanmaken van de custom ViewHolder
     * @param binding LayoutBinding die gebruikt wordt door de ViewHolder
     */
    class ViewHolder private constructor(val binding: IngredientItemViewBinding): RecyclerView.ViewHolder(binding.root){

        companion object {
            /**
             * Deze functie wordt gebruikt om de layout te binden aan de ViewHolder
             * @param parent Parent waartoe de ViewHolder behoord
             * @return ViewHolder
             */
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = IngredientItemViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
        /**
         * Deze functie wordt gebruikt om een ingredient (String) te binden aan de ViewHolder
         * @param item Ingredient (String) die aan de ViewHolder gebind wordt
         */
        fun bind(item: String) {
            binding.ingredient = item
            binding.executePendingBindings()
        }
    }

}
/**
 * Deze class verbeterd de performantie in een RecyclerView om verschillen tussen de ingredienten
 * beter te kunnen uitmaken.
 * @constructor Constructor voor het aanmaken van de [IngredientDiffCallback] (DiffUtil.ItemCallback)
 */
class IngredientDiffCallback: DiffUtil.ItemCallback<String>(){
    /**
     * Deze functie bekijkt of 2 ingredienten dezelfde te zijn
     * @param oldItem Ingredient 1 (String)
     * @param newItem Ingredient 2 (String)
     * @return Boolean
     */
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
    /**
     * Deze functie bekijkt of de inhoud van 2 ingredienten dezelfde te zijn
     * @param oldItem Ingredient 1 (String)
     * @param newItem Ingredient 2 (String)
     * @return Boolean
     */
    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem.equals(newItem)
    }
}