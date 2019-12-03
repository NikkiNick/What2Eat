package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdOnderdeel
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import java.util.*

class MaaltijdOnderdeelOverzichtViewModel(val database: MaaltijdOnderdeelDao, application: Application) : AndroidViewModel(application){


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
            _maaltijdOnderdelen.value = getAllMaaltijdOnderdelenFromDatabase()
            originalListMaaltijdOnderdelen.clear()
            originalListMaaltijdOnderdelen.addAll(_maaltijdOnderdelen.value!!)
        }
    }

    private suspend fun getAllMaaltijdOnderdelenFromDatabase(): List<MaaltijdOnderdeel>?{
        return withContext(Dispatchers.IO){
            val maaltijdOnderdelen = database.getAll()
            maaltijdOnderdelen
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}