package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.model.Maaltijd
import android.com.what2eat.repositories.MaaltijdRepository
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject

class MaaltijdOverzichtViewModel() : ViewModel(){

    @Inject lateinit var maaltijdRepo: MaaltijdRepository

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

    private val _navigateToMaaltijdEdit = MutableLiveData<Long>()
    val navigateToMaaltijdEdit
        get() = _navigateToMaaltijdEdit

    fun onMaaltijdClicked(id: Long){
        _navigateToMaaltijdDetail.value = id
    }
    fun onDetailNavigated(){
        _navigateToMaaltijdDetail.value = null
    }

    private val originalListMaaltijden: MutableList<Maaltijd> = mutableListOf()

    init{
        android.com.what2eat.Application.component.inject(this)
    }

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
            _maaltijden.value = maaltijdRepo.getAllMaaltijden()
            originalListMaaltijden.clear()
            originalListMaaltijden.addAll(_maaltijden.value!!)
        }
    }
    fun addMaaltijd(maaltijd_naam: String){
        uiScope.launch {
            val maaltijd = Maaltijd()
            maaltijd.naam = maaltijd_naam
            val id = maaltijdRepo.addMaaltijd(maaltijd)
            _navigateToMaaltijdEdit.value = id
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}