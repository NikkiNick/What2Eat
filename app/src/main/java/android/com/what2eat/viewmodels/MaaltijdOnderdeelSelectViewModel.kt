package android.com.what2eat.viewmodels

import android.com.what2eat.model.MaaltijdOnderdeel
import android.com.what2eat.repositories.MaaltijdOnderdeelRepository
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
 * ViewModel voor business logica rond een overzicht van maaltijdOnderdelen met een checkbox. Deze
 * maaltijdOnderdelen kunnen afzonderlijk geselecteerd worden. Enkel maaltijdOnderdelen die niet tot
 *  de gegeven maaltijd behoren worden weergegeven.
 * @property maaltijdId Id van de gegeven maaltijd
 * @property maaltijdOnderdeelRepo Repository voor Room databank operaties voor maaltijdOnderdelen
 * @property maaltijdOnderdelen Lijst van [MaaltijdOnderdeel] waarrond het ViewModel opgebouwd is
 */
class MaaltijdOnderdeelSelectViewModel(val maaltijdId: Long) : ViewModel(){

    /**
     * Injected properties
     */
    @Inject lateinit var maaltijdOnderdeelRepo: MaaltijdOnderdeelRepository

    /**
     * ViewModel LiveData Properties
     */
    private var _maaltijdOnderdelen = MutableLiveData<List<MaaltijdOnderdeel>>()
    val maaltijdOnderdelen: LiveData<List<MaaltijdOnderdeel>>
        get() = _maaltijdOnderdelen

    private val originalListMaaltijdOnderdelen: MutableList<MaaltijdOnderdeel> = mutableListOf()

    /**
     * CoRoutine properties
     */
    var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    /**
     * Initialisatie van het ViewModel. Dependency injection in het ViewModel.
     */
    init {
        android.com.what2eat.Application.component.inject(this)
    }

    /**
     * Deze functie initialiseerd de maaltijdOnderdelen voor het ViewModel.
     */
    fun initMaaltijdOnderdelen(){
        initializeMaaltijdOnderdelen()
    }

    /**
     * CoRoutine launcher die de alle maaltijdOnderdelen ophaalt via API-call waarmee het ViewModel
     * gecreëert is. Deze lijst wordt gedupliceerd voor de filter feature.
     * @see [MaaltijdOnderdeelRepository.getAllMaaltijdOnderdelenNotFromMaaltijd]
     */
    private fun initializeMaaltijdOnderdelen() {
        uiScope.launch {
            _maaltijdOnderdelen.value = maaltijdOnderdeelRepo.getAllMaaltijdOnderdelenNotFromMaaltijd(maaltijdId)
            originalListMaaltijdOnderdelen.clear()
            originalListMaaltijdOnderdelen.addAll(_maaltijdOnderdelen.value!!)
        }
    }

    /**
     * Deze functie filtered maaltijdOnderdelen aan de hand van user-input in de SearchView vertrekkende
     * van de originele maaltijdOnderdelenlijst.
     */
    fun filterMaaltijdOnderdelen(filter: String){
        val filterString = filter.toLowerCase(Locale.ROOT).trim()
        _maaltijdOnderdelen.value = mutableListOf()
        _maaltijdOnderdelen.value = originalListMaaltijdOnderdelen.filter{maaltijdOnderdeel -> maaltijdOnderdeel.naam.contains(filterString)}
    }

    /**
     * CoRoutine launcher die een nieuw maaltijdOnderdeel toevoegd in de Room-databank.
     * @see [MaaltijdOnderdeelRepository.addMaaltijdOnderdeel]
     */
    fun addMaaltijdOnderdeel(naam: String) {
        uiScope.launch {
            val mo = MaaltijdOnderdeel()
            mo.naam = naam
            maaltijdOnderdeelRepo.addMaaltijdOnderdeel(mo)
        }
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