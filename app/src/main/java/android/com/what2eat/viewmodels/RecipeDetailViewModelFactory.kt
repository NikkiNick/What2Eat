package android.com.what2eat.viewmodels

import android.com.what2eat.network.RecipeData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RecipeDetailViewModelFactory(val recipe: RecipeData): ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeDetailViewModel::class.java)) {
            return RecipeDetailViewModel(recipe) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}