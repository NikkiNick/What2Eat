package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdOnderdeel
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class MaaltijdOnderdeelDetailViewModel(
    val maaltijdOnderdeelDbSource: MaaltijdOnderdeelDao,
    val maaltijdDbSource: MaaltijdDao,
    val maaltijdOnderdeel_id: Long,
    application: Application)  : AndroidViewModel(application){

    var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var _maaltijdOnderdeel = MutableLiveData<MaaltijdOnderdeel>()
    val maaltijdOnderdeel: LiveData<MaaltijdOnderdeel>
        get() = _maaltijdOnderdeel

    private var _showSnackBar = MutableLiveData<String>()
    val showSnackBar: LiveData<String>
        get() = _showSnackBar

    init{
        initializeMaaltijdOnderdeel()
    }

    fun initializeMaaltijdOnderdeel(){
        uiScope.launch {
            _maaltijdOnderdeel.value = getMaaltijdOnderdeelFromDatabase()
        }
    }
    private fun updateMaaltijdOnderdeel(){
        uiScope.launch {
            updateMaaltijdOnderdeelOnDatabase()
        }
    }
    fun deleteMaaltijdOnderdeel(){
        uiScope.launch {
            deleteMaaltijdOnderdeelFromDatabase()
        }
    }

    private suspend fun deleteMaaltijdOnderdeelFromDatabase() {
        withContext(Dispatchers.IO){
            maaltijdDbSource.getMaaltijdenFromMaaltijdOnderdeel(maaltijdOnderdeel_id)?.let{
                if(it.size > 0){
                    _showSnackBar.postValue("Maaltijdonderdeel is verbonden met maaltijden")
                }
                else{
                    maaltijdOnderdeelDbSource.delete(_maaltijdOnderdeel.value!!)
                    _showSnackBar.postValue("Maaltijdonderdeel verwijderd")
                }
            }
        }
    }

    private suspend fun updateMaaltijdOnderdeelOnDatabase() {
        withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.update(_maaltijdOnderdeel.value!!)
        }
    }

    private suspend fun getMaaltijdOnderdeelFromDatabase(): MaaltijdOnderdeel? {
        return withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.get(maaltijdOnderdeel_id)
        }
    }
    fun setNaam(naam: String){
        this.maaltijdOnderdeel.value?.naam = naam
        updateMaaltijdOnderdeel()
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}