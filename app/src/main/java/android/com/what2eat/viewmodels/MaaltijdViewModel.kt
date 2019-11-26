package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.R
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.database.MaaltijdDatabaseDao
import android.com.what2eat.model.Maaltijd
import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MaaltijdViewModel(val db: MaaltijdDatabaseDao, application: Application): AndroidViewModel(application) {
    /*
    CoRoutine setup
     */
    var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    /*
    Main object binding
     */
    private var _maaltijd = MutableLiveData<Maaltijd>()
    val maaltijd: LiveData<Maaltijd>
        get() = _maaltijd

    /*
    Rating binding
     */
    private var _changeRatingDisplay = MutableLiveData<Int>()
    val changeRatingDisplay: LiveData<Int>
        get() = _changeRatingDisplay

    val ratingStrings = listOf(
        application.applicationContext.getString(R.string.rating0),
        application.applicationContext.getString(R.string.rating1),
        application.applicationContext.getString(R.string.rating2),
        application.applicationContext.getString(R.string.rating3),
        application.applicationContext.getString(R.string.rating4),
        application.applicationContext.getString(R.string.rating5))
    var _ratingString = MutableLiveData<String>()
    val ratingString: LiveData<String>
        get() = _ratingString

    init{
        this._maaltijd.value = Maaltijd()
        this._ratingString.value = ratingStrings.get(0)
    }

    fun setNaam(naam: String){
        this._maaltijd.value?.naam = naam
    }
    fun setRating(rating: Int){
        this._maaltijd.value?.rating = rating
        this._changeRatingDisplay.value = rating
        this._ratingString.value = ratingStrings.get(rating)
    }

    /*
    Co-Routines
     */
    fun saveMaaltijd(){
        uiScope.launch {
            saveMaaltijdOnDatabase()
        }
    }
    private suspend fun saveMaaltijdOnDatabase(){
        return withContext(Dispatchers.IO){
            db.insert(_maaltijd.value!!)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}