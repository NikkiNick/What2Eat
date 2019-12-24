package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdOnderdeel
import android.com.what2eat.repositories.MaaltijdOnderdeelRepository
import android.com.what2eat.repositories.MaaltijdRepository
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

class MaaltijdOnderdeelDetailViewModel(val maaltijdOnderdeel_id: Long)  : ViewModel(){

    @Inject lateinit var maaltijdOnderdeelRepo: MaaltijdOnderdeelRepository
    @Inject lateinit var maaltijdRepo: MaaltijdRepository

    var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var _maaltijdOnderdeel = MutableLiveData<MaaltijdOnderdeel>()
    val maaltijdOnderdeel: LiveData<MaaltijdOnderdeel>
        get() = _maaltijdOnderdeel

    private var _maaltijden = MutableLiveData<List<Maaltijd>?>()
    val maaltijden: LiveData<List<Maaltijd>?>
        get() = _maaltijden

    private var _showSnackBar = MutableLiveData<String>()
    val showSnackBar: LiveData<String>
        get() = _showSnackBar

    init{
        android.com.what2eat.Application.component.inject(this)
        initializeMaaltijdOnderdeel()
    }

    fun initializeMaaltijdOnderdeel(){
        uiScope.launch {
            _maaltijdOnderdeel.value = maaltijdOnderdeelRepo.getMaaltijdOnderdeel(maaltijdOnderdeel_id)
            _maaltijden.value = maaltijdRepo.getMaaltijdenFromMaaltijdOnderdeel(maaltijdOnderdeel_id)
        }
    }
    private fun updateMaaltijdOnderdeel(){
        uiScope.launch {
            maaltijdOnderdeelRepo.updateMaaltijdOnderdeel(_maaltijdOnderdeel.value!!)
        }
    }
    fun deleteMaaltijdOnderdeel(){
        uiScope.launch {
            maaltijdRepo.getMaaltijdenFromMaaltijdOnderdeel(maaltijdOnderdeel_id)?.let {
                if(it.size > 0){
                    _showSnackBar.postValue("Maaltijdonderdeel is verbonden met maaltijden")
                }
                else{
                    maaltijdOnderdeelRepo.deleteMaaltijdOnderdeel(_maaltijdOnderdeel.value!!)
                    _showSnackBar.postValue("Maaltijdonderdeel verwijderd")
                }
            }
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