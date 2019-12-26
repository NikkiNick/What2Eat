package android.com.what2eat.network

import android.com.what2eat.utils.EDAMAM_APP_ID
import android.com.what2eat.utils.EDAMAM_APP_KEY
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {

    @GET("search?app_id=${EDAMAM_APP_ID}&app_key=${EDAMAM_APP_KEY}")
    fun getRecipes(@Query("q") naam: String): Deferred<Response>

}