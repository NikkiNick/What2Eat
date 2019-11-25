package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.database.MaaltijdDatabaseDao
import android.com.what2eat.model.Maaltijd
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MaaltijdOverzichtViewModel(val database: MaaltijdDatabaseDao, application: Application) : AndroidViewModel(application){


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

    fun initMaaltijden(){
        initializeMaaltijden()
    }

    private fun initializeMaaltijden() {
        uiScope.launch {
            _maaltijden.value = getAllMaaltijdenFromDatabase()
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