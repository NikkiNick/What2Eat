package android.com.what2eat.network

import android.com.what2eat.utils.EDAMAM_APP_ID
import android.com.what2eat.utils.EDAMAM_APP_KEY
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {

    //@GET("search?app_id=${EDAMAM_APP_ID}&app_key=${EDAMAM_APP_KEY}")
    //fun getRecipes(@Query("q") naam: String): Deferred<List<RecipeProperty>>

    @GET("search?q=chicken&app_id=41e1b0e7&app_key=98495ccfce84506138e6735baafbdb49")
    fun getRecipes(): Deferred<Response>
}