package android.com.what2eat.adapters

import android.com.what2eat.databinding.RecipeItemViewBinding
import android.com.what2eat.network.Recipe
import android.com.what2eat.network.RecipeData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(val clickListener: RecipeListener): ListAdapter<Recipe, RecipeAdapter.ViewHolder>(RecipeDiffCallback()){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: RecipeItemViewBinding): RecyclerView.ViewHolder(binding.root){

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecipeItemViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(item: Recipe, clickListener: RecipeListener) {
            binding.recipe = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

}
class RecipeDiffCallback: DiffUtil.ItemCallback<Recipe>(){
    override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem.recipe.naam == newItem.recipe.naam
    }
    override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem.equals(newItem)
    }
}
class RecipeListener(val clickListener: (recipe: RecipeData) -> Unit) {
    fun onClick(recipe: Recipe) = clickListener(recipe.recipe)
}