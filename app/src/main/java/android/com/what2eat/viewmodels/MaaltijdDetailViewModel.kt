package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.R
import android.com.what2eat.database.MaaltijdDatabaseDao
import android.com.what2eat.model.Maaltijd
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class MaaltijdDetailViewModel(val maaltijdId: Long, val db: MaaltijdDatabaseDao, application: Application): AndroidViewModel(application) {
    /*
    CoRoutine setup
     */
    var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var _maaltijd = MutableLiveData<Maaltijd>()
    val maaltijd: LiveData<Maaltijd>
        get() = _maaltijd

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
        initializeMaaltijd()
    }

    /*
    Co-Routines
     */
    fun initializeMaaltijd(){
        uiScope.launch {
            _maaltijd.value = getMaaltijdFromDatabase()
        }
    }
    private suspend fun getMaaltijdFromDatabase(): Maaltijd? {
        return withContext(Dispatchers.IO){
            db.get(maaltijdId)
        }
    }
    fun saveMaaltijd(){
        uiScope.launch {
            saveMaaltijdToDatabase()
        }
    }
    private suspend fun saveMaaltijdToDatabase(){
        return withContext(Dispatchers.IO){
            db.update(_maaltijd.value!!)
        }
    }
    fun deleteMaaltijd(){
        uiScope.launch {
            deleteMaaltijdFromDatabase()
        }
    }
    private suspend fun deleteMaaltijdFromDatabase(){
        return withContext(Dispatchers.IO){
            db.delete(_maaltijd.value!!)
        }
    }
    fun setNaam(naam: String){
        _maaltijd.value?.naam = naam
    }
    fun setRating(rating: Int){
        _maaltijd.value?.rating = rating
        _changeRatingDisplay.value = rating
        _ratingString.value = ratingStrings.get(rating)
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}