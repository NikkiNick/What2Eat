package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdOnderdeel
import android.com.what2eat.repositories.MaaltijdMaaltijdOnderdeelRepository
import android.com.what2eat.repositories.MaaltijdOnderdeelRepository
import android.com.what2eat.repositories.MaaltijdRepository
import androidx.lifecycle.*
import kotlinx.coroutines.*
import javax.inject.Inject

class MaaltijdDetailViewModel(val maaltijdId: Long): ViewModel(){

    @Inject lateinit var maaltijdRepo: MaaltijdRepository
    @Inject lateinit var maaltijdOnderdeelRepo: MaaltijdOnderdeelRepository
    @Inject lateinit var maaltijdMaaltijdOnderdeelRepo: MaaltijdMaaltijdOnderdeelRepository
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

    /*
    Co-Routines
     */
    init{
        android.com.what2eat.Application.component.inject(this)
        initializeMaaltijd()
    }
    fun initializeMaaltijd(){
        uiScope.launch {
            _maaltijd.value = maaltijdRepo.getMaaltijd(maaltijdId)
            _maaltijdOnderdelen.value = maaltijdOnderdeelRepo.getMaaltijdOnderdelenFromMaaltijd(maaltijdId)
        }
    }
    fun saveMaaltijd(){
        uiScope.launch {
            maaltijdRepo.saveMaaltijd(_maaltijd.value!!)
        }
    }
    fun deleteMaaltijd(){
        uiScope.launch {
            maaltijdRepo.deleteMaaltijd(_maaltijd.value!!)
            maaltijdMaaltijdOnderdeelRepo.deleteMaaltijdenMaaltijdOnderdelenJoin(_maaltijd.value!!)
        }
    }
    fun addMaaltijdOnderdelenToMaaltijd(maaltijdOnderdeelIds: LongArray){
        uiScope.launch {
            maaltijdOnderdeelIds.forEach { id ->
                maaltijdMaaltijdOnderdeelRepo.addMaaltijdOnderdeelToMaaltijd(maaltijdId, id)
            }
            initializeMaaltijd()
        }
    }
    fun removeMaaltijdOnderdeelFromMaaltijd(maaltijdOnderdeelId: Long){
        uiScope.launch {
            maaltijdMaaltijdOnderdeelRepo.removeMaaltijdOnderdeelFromMaaltijd(maaltijdId, maaltijdOnderdeelId)
        }
    }
    fun setNaam(naam: String){
        _maaltijd.value?.naam = naam
    }
    fun setRating(rating: Int){
        _maaltijd.value?.rating = rating
        _changeRatingDisplay.value = rating
    }
    fun setMaaltijdPhoto(uri: String){
        _maaltijd.value?.photo_uri = uri
    }
    fun removeMaaltijdPhoto(){
        _maaltijd.value?.photo_uri = null
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}