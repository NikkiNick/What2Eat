package android.com.what2eat.repositories

import android.com.what2eat.network.RecipeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeApiRepository(val recipeApi: RecipeApi) {

    suspend fun searchRecipes(naam: String){
        withContext(Dispatchers.IO){
            recipeApi.getRecipes(naam)
        }
    }

}