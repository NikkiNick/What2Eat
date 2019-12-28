package android.com.what2eat.viewmodels.viewModelFactories

import android.com.what2eat.viewmodels.RecipeOverzichtViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Factory voor het aanmaken van een [RecipeOverzichtViewModel]. Dit ViewModel wordt aangemaakt met
 * een gegeven naam van een ingredient.
 * @param naam Naam van het ingredient
 */
class RecipeOverzichtViewModelFactory(val naam: String) : ViewModelProvider.Factory {

    /**
     * Creëert het [RecipeOverzichtViewModel] met gegeven ingredientnaam
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeOverzichtViewModel::class.java)) {
            return RecipeOverzichtViewModel(naam) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}