package android.com.what2eat.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class RecipeApiViewModelFactory(val naam: String) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeApiViewModel::class.java)) {
            return RecipeApiViewModel(naam) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}