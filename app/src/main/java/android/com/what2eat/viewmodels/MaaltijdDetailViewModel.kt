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
            var con = getAllConnections()
            Log.i("TestN", "All connections: "+con.toString())
            /*var mos = mutableListOf<MaaltijdOnderdeel>()
            var mo1 = MaaltijdOnderdeel()
            mo1.naam = "Onderdeel 2"
            mos.add(mo1)
            var mo2 = MaaltijdOnderdeel()
            mo2.naam = "Onderdeel 3"
            mos.add(mo2)
            var mo3 = MaaltijdOnderdeel()
            mo3.naam = "Onderdeel 4"
            mos.add(mo3)
            var mo4 = MaaltijdOnderdeel()
            mo4.naam = "Onderdeel 5"
            mos.add(mo4)
            mos.forEach { mo -> addMO(mo) }*/
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
    suspend fun getAllConnections(): List<MaaltijdMaaltijdOnderdeel>?{
        return withContext(Dispatchers.IO){
            maaltijdMaaltijdOnderdeelDbSource.getAll()
        }
    }
    fun addMaaltijdOnderdeelToMaaltijd(maaltijdOnderdeelId: Long){
        uiScope.launch {
            var maaltijdOnderdeel = getMaaltijdOnderdeelFromDatabase(maaltijdOnderdeelId)
            maaltijdOnderdeel?.let {
                addMaaltijdOnderdeelToMaaltijdToDatabase(it.maaltijdOnderdeelId)
            }
        }
    }
    private suspend fun addMaaltijdOnderdeelToMaaltijdToDatabase(maaltijdOnderdeelId: Long){
        withContext(Dispatchers.IO) {
            maaltijdMaaltijdOnderdeelDbSource.insert(MaaltijdMaaltijdOnderdeel(maaltijdId, maaltijdOnderdeelId))
        }
    }
    private suspend fun getMaaltijdOnderdeelFromDatabase(id: Long): MaaltijdOnderdeel?{
        return withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.get(id)
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