package android.com.what2eat.viewmodels

import android.com.what2eat.Application
import android.com.what2eat.network.Recipe
import android.com.what2eat.repositories.RecipeApiRepository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel voor business logica rond een overzicht van recepten. Recepten die een gegeven ingredientennaam
 *  bevatten worden opgehaald en weergegeven.
 * @property naam Gegeven ingredientennaam
 * @property recipeRepo Repository voor API-calls voor recepten
 * @property response Response van de API-call
 */
class RecipeOverzichtViewModel(val naam: String): ViewModel() {

    /**
     * Injected properties
     */
    @Inject lateinit var recipeRepo: RecipeApiRepository

    /**
     * ViewModel LiveData Properties
     */
    private val _response = MutableLiveData<List<Recipe>>()
    val response: LiveData<List<Recipe>>
        get() = _response

    /**
     * CoRoutine properties
     */
    var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    /**
     * Initialisatie van het ViewModel. Dependency injection in het ViewModel en initialisatie van
     * het overzicht van recepten volgens de gegeven ingredientennaam.
     */
    init {
        Application.component.inject(this)
        searchRecipesByName(naam)
    }
    /**
     * CoRoutine launcher die recepten ophaalt van een API die een gegeven ingredientennaam bevatten
     * @param naam Naam van het gegeven ingredient
     * @see [RecipeApiRepository.searchRecipes]
     */
    private fun searchRecipesByName(naam: String){
        uiScope.launch {
            val getRecipesDeffered = recipeRepo.searchRecipes(naam)
            try{
                val recipeList = getRecipesDeffered.await()
                _response.value = recipeList.recipes
            }catch (e: Exception){
                Log.i("TestN", "Error: "+e.message)
            }
        }
    }

    /**
     * Deze functie wordt opgeroepen als het ViewModel wordt afgebroken.
     * [viewModelJob] wordt afgesloten.
     */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}