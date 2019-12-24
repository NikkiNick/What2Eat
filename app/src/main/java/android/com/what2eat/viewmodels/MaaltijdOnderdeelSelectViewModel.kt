package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.database.MaaltijdMaaltijdOnderdeelDao
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdOnderdeel
import android.com.what2eat.repositories.MaaltijdOnderdeelRepository
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject

class MaaltijdOnderdeelSelectViewModel(val maaltijdId: Long) : ViewModel(){

    @Inject lateinit var maaltijdOnderdeelRepo: MaaltijdOnderdeelRepository

    var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var _maaltijdOnderdelen = MutableLiveData<List<MaaltijdOnderdeel>>()
    val maaltijdOnderdelen: LiveData<List<MaaltijdOnderdeel>>
        get() = _maaltijdOnderdelen

    private val originalListMaaltijdOnderdelen: MutableList<MaaltijdOnderdeel> = mutableListOf()

    init {
        android.com.what2eat.Application.component.inject(this)
    }

    fun initMaaltijdOnderdelen(){
        initializeMaaltijdOnderdelen()
    }
    fun filterMaaltijdOnderdelen(filter: String){
        val filterString = filter.toLowerCase(Locale.ROOT).trim()
        _maaltijdOnderdelen.value = mutableListOf()
        _maaltijdOnderdelen.value = originalListMaaltijdOnderdelen.filter{maaltijdOnderdeel -> maaltijdOnderdeel.naam.contains(filterString)}
    }
    private fun initializeMaaltijdOnderdelen() {
        uiScope.launch {
            _maaltijdOnderdelen.value = maaltijdOnderdeelRepo.getAllMaaltijdOnderdelenNotFromMaaltijd(maaltijdId)
            originalListMaaltijdOnderdelen.clear()
            originalListMaaltijdOnderdelen.addAll(_maaltijdOnderdelen.value!!)
        }
    }
    fun addMaaltijdOnderdeel(naam: String) {
        uiScope.launch {
            val mo = MaaltijdOnderdeel()
            mo.naam = naam
            maaltijdOnderdeelRepo.addMaaltijdOnderdeel(mo)
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}