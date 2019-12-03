package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.R
import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.database.MaaltijdMaaltijdOnderdeelDao
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdMaaltijdOnderdeel
import android.com.what2eat.model.MaaltijdOnderdeel
import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.*

class MaaltijdDetailViewModel(
    val maaltijdId: Long,
    val maaltijdDbSource: MaaltijdDao,
    val maaltijdOnderdeelDbSource: MaaltijdOnderdeelDao,
    val maaltijdMaaltijdOnderdeelDbSource: MaaltijdMaaltijdOnderdeelDao,
    application: Application)
    : AndroidViewModel(application) {
    /*
    CoRoutine setup
     */
    var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var _maaltijd = MutableLiveData<Maaltijd>()
    val maaltijd: LiveData<Maaltijd>
        get() = _maaltijd

    private var _maaltijdOnderdelen = MutableLiveData<List<MaaltijdOnderdeel>?>()
    val maaltijdOnderdelen: LiveData<List<MaaltijdOnderdeel>?>
        get() = _maaltijdOnderdelen

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
            _maaltijdOnderdelen.value = getMaaltijdOnderdelenFromDatabase()
        }
    }
    fun saveMaaltijd(){
        uiScope.launch {
            saveMaaltijdToDatabase()
        }
    }
    fun deleteMaaltijd(){
        uiScope.launch {
            deleteMaaltijdFromDatabase()
        }
    }
    fun addMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        uiScope.launch {
            addMaaltijdOnderdeelToDatabase(maaltijdOnderdeel)
        }
    }
    private suspend fun addMaaltijdOnderdeelToDatabase(maaltijdOnderdeel: MaaltijdOnderdeel){
        withContext(Dispatchers.IO){
            val maaltijdOnderdeelId: Long = maaltijdOnderdeelDbSource.insert(maaltijdOnderdeel)
            maaltijdMaaltijdOnderdeelDbSource.insert(MaaltijdMaaltijdOnderdeel(maaltijdId, maaltijdOnderdeelId))
        }
    }
    private suspend fun getMaaltijdOnderdelenFromDatabase(): List<MaaltijdOnderdeel>? {
        return withContext(Dispatchers.IO){
            maaltijdMaaltijdOnderdeelDbSource.getMaaltijdOnderdelenVanMaaltijd(maaltijdId)
        }
    }

    private suspend fun getMaaltijdFromDatabase(): Maaltijd? {
        return withContext(Dispatchers.IO){
            maaltijdDbSource.get(maaltijdId)
        }
    }
    private suspend fun saveMaaltijdToDatabase(){
        return withContext(Dispatchers.IO){
            maaltijdDbSource.update(_maaltijd.value!!)
        }
    }
    private suspend fun deleteMaaltijdFromDatabase(){
        return withContext(Dispatchers.IO){
            maaltijdDbSource.delete(_maaltijd.value!!)
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