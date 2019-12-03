package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.model.Maaltijd
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import java.util.*

class MaaltijdOverzichtViewModel(val database: MaaltijdDao, application: Application) : AndroidViewModel(application){


    var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var _maaltijden = MutableLiveData<List<Maaltijd>>()
    val maaltijden: LiveData<List<Maaltijd>>
        get() = _maaltijden

    /*
    Navigation to detail binding
     */
    private val _navigateToMaaltijdDetail = MutableLiveData<Long>()
    val navigateToMaaltijdDetail
        get() = _navigateToMaaltijdDetail

    fun onMaaltijdClicked(id: Long){
        _navigateToMaaltijdDetail.value = id
    }
    fun onDetailNavigated(){
        _navigateToMaaltijdDetail.value = null
    }

    private val originalListMaaltijden: MutableList<Maaltijd> = mutableListOf()


    fun initMaaltijden(){
        initializeMaaltijden()
    }
    fun filterMaaltijden(filter: String){
        val filterString = filter.toLowerCase(Locale.ROOT).trim()
        _maaltijden.value = mutableListOf()
        _maaltijden.value = originalListMaaltijden.filter{maaltijd -> maaltijd.naam.contains(filterString)}
    }
    private fun initializeMaaltijden() {
        uiScope.launch {
            _maaltijden.value = getAllMaaltijdenFromDatabase()
            originalListMaaltijden.clear()
            originalListMaaltijden.addAll(_maaltijden.value!!)
        }
    }

    private suspend fun getAllMaaltijdenFromDatabase(): List<Maaltijd>?{
        return withContext(Dispatchers.IO){
            val maaltijden = database.getAll()
            maaltijden
        }
    }

    fun clearMaaltijden(){
        uiScope.launch {
            _maaltijden.value = emptyList()
            clearAllMaaltijdenFromDatabase()
        }
    }
    private suspend fun clearAllMaaltijdenFromDatabase(){
        return withContext(Dispatchers.IO){
            database.deleteAll()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}