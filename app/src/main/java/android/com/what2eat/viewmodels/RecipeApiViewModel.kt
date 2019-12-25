package android.com.what2eat.viewmodels

import android.com.what2eat.Application
import android.com.what2eat.network.Recipe
import android.com.what2eat.network.RecipeApi
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class RecipeApiViewModel(): ViewModel() {

    //@Inject lateinit var recipeApi: RecipeApi

    var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _response = MutableLiveData<List<Recipe>>()
    val response: LiveData<List<Recipe>>
        get() = _response

    init {
        Application.component.inject(this)
        searchRecipesByName("chicken")
    }
    private fun searchRecipesByName(naam: String){
        uiScope.launch {
            //var getRecipesDeffered = recipeApi.getRecipes(naam)
            var getRecipesDeffered = RecipeApi2.retrofitService.getRecipes()
            try{
                var recipeList = getRecipesDeffered.await()
                _response.value = recipeList.recipes
            }catch (e: Exception){
                Log.i("TestN", "Error: "+e.message)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}