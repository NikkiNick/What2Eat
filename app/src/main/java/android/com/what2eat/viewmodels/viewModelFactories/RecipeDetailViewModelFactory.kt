package android.com.what2eat.viewmodels.viewModelFactories

import android.com.what2eat.network.RecipeData
import android.com.what2eat.viewmodels.RecipeDetailViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Factory voor het aanmaken van een [RecipeDetailViewModel]. Dit ViewModel wordt aangemaakt met
 * een gegeven recept.
 * @param recipe Gegeven recept
 */
class RecipeDetailViewModelFactory(val recipe: RecipeData): ViewModelProvider.Factory {

    /**
     * Creëert het [RecipeDetailViewModel] met gegeven recept
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeDetailViewModel::class.java)) {
            return RecipeDetailViewModel(recipe) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}