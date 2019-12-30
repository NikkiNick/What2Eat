package android.com.what2eat.repositories

import android.com.what2eat.network.RecipeApi
import android.com.what2eat.network.Response
import kotlinx.coroutines.Deferred

/**
 * Repository voor het het uitvoeren van API-operaties rond recepten
 * @param recipeApi API Interface gebruikt voor API-calls
 */
class RecipeApiRepository(val recipeApi: RecipeApi) {

    /**
     * Functie voor het opzoeken van recepten aan de hand van een gegeven ingredient.
     * @param naam Naam van het inggredient
     * @return Response
     */
    fun searchRecipes(naam: String): Deferred<Response> {
        return recipeApi.getRecipes(naam)
    }

}