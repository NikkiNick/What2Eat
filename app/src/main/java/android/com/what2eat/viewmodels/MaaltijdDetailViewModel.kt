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

    /*
    Co-Routines
     */
    init{
        initializeMaaltijd()
    }
    private fun initializeMaaltijd(){
        uiScope.launch {
            _maaltijd.value = getMaaltijdFromDatabase()
            _maaltijdOnderdelen.value = getMaaltijdOnderdelenFromDatabase()
        }
    }
    suspend fun addMO(mo: MaaltijdOnderdeel){
        withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.insert(mo)
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
    fun addMaaltijdOnderdelenToMaaltijd(maaltijdOnderdeelIds: LongArray){
        uiScope.launch {
            maaltijdOnderdeelIds.forEach { id ->
                addMaaltijdOnderdeelToMaaltijdToDatabase(id)
            }
            initializeMaaltijd()
        }
    }
    fun removeMaaltijdOnderdeelFromMaaltijd(maaltijdOnderdeelId: Long){
        uiScope.launch {
            removeMaaltijdOnderdeelFromMaaltijdFromDatabase(maaltijdOnderdeelId)
        }
    }
    private suspend fun removeMaaltijdOnderdeelFromMaaltijdFromDatabase(maaltijdOnderdeelId: Long){
        withContext(Dispatchers.IO){
            maaltijdMaaltijdOnderdeelDbSource.delete(MaaltijdMaaltijdOnderdeel(maaltijdId, maaltijdOnderdeelId))
            initializeMaaltijd()
        }
    }
    private suspend fun addMaaltijdOnderdeelToMaaltijdToDatabase(maaltijdOnderdeelId: Long){
        withContext(Dispatchers.IO) {
            maaltijdMaaltijdOnderdeelDbSource.insert(MaaltijdMaaltijdOnderdeel(maaltijdId, maaltijdOnderdeelId))
        }
    }
    private suspend fun getMaaltijdOnderdelenFromDatabase(): List<MaaltijdOnderdeel>? {
        return withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.getMaaltijdOnderdelenVanMaaltijd(maaltijdId)
        }
    }
    private suspend fun getMaaltijdFromDatabase(): Maaltijd? {
        return withContext(Dispatchers.IO){
            maaltijdDbSource.get(maaltijdId)
        }
    }
    private suspend fun saveMaaltijdToDatabase(){
        withContext(Dispatchers.IO){
            maaltijdDbSource.update(_maaltijd.value!!)
        }
    }
    private suspend fun deleteMaaltijdFromDatabase(){
        withContext(Dispatchers.IO){
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