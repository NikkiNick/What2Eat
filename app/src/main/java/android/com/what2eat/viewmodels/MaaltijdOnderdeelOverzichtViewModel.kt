package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.database.MaaltijdMaaltijdOnderdeelDao
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdOnderdeel
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import java.util.*

class MaaltijdOnderdeelOverzichtViewModel(val maaltijdOnderdeelDbSource: MaaltijdOnderdeelDao, val maaltijdId: Long, application: Application) : AndroidViewModel(application){


    var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var _maaltijdOnderdelen = MutableLiveData<List<MaaltijdOnderdeel>>()
    val maaltijdOnderdelen: LiveData<List<MaaltijdOnderdeel>>
        get() = _maaltijdOnderdelen

    private val originalListMaaltijdOnderdelen: MutableList<MaaltijdOnderdeel> = mutableListOf()

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
            _maaltijdOnderdelen.value = getAllMaaltijdOnderdelenNotFromMaaltijdFromDatabase()
            originalListMaaltijdOnderdelen.clear()
            originalListMaaltijdOnderdelen.addAll(_maaltijdOnderdelen.value!!)
        }
    }
    fun addMO(maaltijdOnderdeel: List<MaaltijdOnderdeel>){
        uiScope.launch {
            maaltijdOnderdeel.forEach { mo -> addMODatabase(mo) }
        }
    }
    private suspend fun addMODatabase(maaltijdOnderdeel: MaaltijdOnderdeel){
        withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.insert(maaltijdOnderdeel)
        }
    }
    private suspend fun getAllMaaltijdOnderdelenNotFromMaaltijdFromDatabase(): List<MaaltijdOnderdeel>?{
        return withContext(Dispatchers.IO){
            val maaltijdOnderdelen = maaltijdOnderdeelDbSource.getMaaltijdOnderdelenNietVanMaaltijd(maaltijdId)
            maaltijdOnderdelen
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}