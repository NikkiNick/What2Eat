package android.com.what2eat.repositories

import android.com.what2eat.network.RecipeApi
import android.com.what2eat.network.Response
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeApiRepository(val recipeApi: RecipeApi) {

    fun searchRecipes(naam: String): Deferred<Response> {
        return recipeApi.getRecipes(naam)
    }

}