package android.com.what2eat.viewmodels

import android.com.what2eat.model.Maaltijd
import android.com.what2eat.repositories.MaaltijdRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

/**
 * ViewModel voor business logica rond een overzicht van maaltijden.
 * @property maaltijdRepo Repository voor Room databank operaties voor maaltijden
 * @property maaltijden Lijst van [Maaltijd] waarrond het ViewModel opgebouwd is
 */
class MaaltijdOverzichtViewModel() : ViewModel(){

    /**
     * Injected properties
     */
    @Inject lateinit var maaltijdRepo: MaaltijdRepository

    /**
     * ViewModel LiveData Properties
     */
    private var _maaltijden = MutableLiveData<List<Maaltijd>>()
    val maaltijden: LiveData<List<Maaltijd>>
        get() = _maaltijden

    private val _navigateToMaaltijdDetail = MutableLiveData<Long>()
    val navigateToMaaltijdDetail
        get() = _navigateToMaaltijdDetail

    private val _navigateToMaaltijdEdit = MutableLiveData<Long>()
    val navigateToMaaltijdEdit
        get() = _navigateToMaaltijdEdit

    private val originalListMaaltijden: MutableList<Maaltijd> = mutableListOf()

    /**
     * CoRoutine Properties
     */
    var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    /**
     * Initialisatie van de maaltijden in van het ViewModel.
     */
    init{
        android.com.what2eat.Application.component.inject(this)
    }

    /**
     * Deze functie initialiseerd de maaltijden voor het ViewModel.
     */
    fun initMaaltijden(){
        initializeMaaltijden()
    }

    /**
     * CoRoutine launcher die de alle maaltijden ophaalt van de Room-databank waarmee het ViewModel
     * gecreëert is. Deze lijst wordt gedupliceerd voor de filter feature.
     * @see [MaaltijdRepository.getAllMaaltijden]
     */
    private fun initializeMaaltijden() {
        uiScope.launch {
            _maaltijden.value = maaltijdRepo.getAllMaaltijden()
            originalListMaaltijden.clear()
            originalListMaaltijden.addAll(_maaltijden.value!!)
        }
    }

    /**
     * Deze functie filtered maaltijden aan de hand van user-input in de SearchView vertrekkende
     * van de originele maaltijdenlijst.
     */
    fun filterMaaltijden(filter: String){
        val filterString = filter.toLowerCase(Locale.ROOT).trim()
        _maaltijden.value = mutableListOf()
        _maaltijden.value = originalListMaaltijden.filter{maaltijd -> maaltijd.naam.contains(filterString)}
    }

    /**
     * CoRoutine launcher die een nieuwe maaltijd toevoegd in de Room-databank. Hierbij wordt ook de LiveData
     * aangepast om het fragment te verwittigen dat er dient genavigeeerd te worden naar het Edit scherm
     * voor de nieuwe maaltijd
     * @see [MaaltijdRepository.addMaaltijd]
     */
    fun addMaaltijd(maaltijd_naam: String){
        uiScope.launch {
            val maaltijd = Maaltijd()
            maaltijd.naam = maaltijd_naam
            val id = maaltijdRepo.addMaaltijd(maaltijd)
            _navigateToMaaltijdEdit.value = id
        }
    }

    /**
     * Functie voor het aanpassen van de LiveData om het fragment te verwittigen te navigeren naar
     * het Detail scherm voor de geselecteerde maaltijd uit het overzicht.
     * @param id Id van de geselecteerde maaltijd
     */
    fun onMaaltijdClicked(id: Long){
        _navigateToMaaltijdDetail.value = id
    }

    /**
     * Functie voor het resetten van de LiveData wanneer het fragment heeft genavigeerd naar het
     * Detail scherm van een geselecteerde maaltijd
     */
    fun onDetailNavigated(){
        _navigateToMaaltijdDetail.value = null
    }

    /**
     * Deze functie wordt opgeroepen als het ViewModel wordt afgebroken.
     * [viewModelJob] wordt afgesloten.
     */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}