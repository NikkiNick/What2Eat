package android.com.what2eat.viewmodels

import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdOnderdeel
import android.com.what2eat.repositories.MaaltijdOnderdeelRepository
import android.com.what2eat.repositories.MaaltijdRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * ViewModel voor business logica rond een bepaald maaltijdOnderdeel in detail.
 * @property maaltijdOnderdeel_id Id van het maaltijdOnderdeel waarrond het ViewModel is opgebouwd
 * @property maaltijdRepo Repository voor Room databank operaties voor maaltijden
 * @property maaltijdOnderdeelRepo Repository voor Room databank operaties voor maaltijdOnderdelen
 * @property maaltijdOnderdeel [MaaltijdOnderdeel] waarrond het ViewModel opgebouwd is
 * @property maaltijden Lijst van [Maaltijd] die bij het maaltijdOnderdeel horen
 */
class MaaltijdOnderdeelDetailViewModel(val maaltijdOnderdeel_id: Long)  : ViewModel(){

    /**
     * Injected properties
     */
    @Inject lateinit var maaltijdOnderdeelRepo: MaaltijdOnderdeelRepository
    @Inject lateinit var maaltijdRepo: MaaltijdRepository

    /**
     * ViewModel LiveData Properties
     */
    private var _maaltijdOnderdeel = MutableLiveData<MaaltijdOnderdeel>()
    val maaltijdOnderdeel: LiveData<MaaltijdOnderdeel>
        get() = _maaltijdOnderdeel

    private var _maaltijden = MutableLiveData<List<Maaltijd>?>()
    val maaltijden: LiveData<List<Maaltijd>?>
        get() = _maaltijden

    private var _showSnackBar = MutableLiveData<String>()
    val showSnackBar: LiveData<String>
        get() = _showSnackBar

    /**
     * CoRoutine properties
     */
    var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    /**
     * Initialisatie van het ViewModel. Dependency injection in het ViewModel en initialisatie van het
     * maaltijdOnderdeel en gelinkte maaltijden
     */
    init{
        android.com.what2eat.Application.component.inject(this)
        initializeMaaltijdOnderdeel()
    }

    /**
     * CoRoutine launcher die het huidige maaltijdOnderdeel ophaalt van de Room-databank aan de hand van de
     * maaltijdOnderdeelId waarmee het ViewModel gecreëert is, alsook de maaltijden waaraan het
     * maaltijdOndedeel gelinkt zijn.
     * @see [MaaltijdOnderdeelRepository.getMaaltijdOnderdeel]
     * @see [MaaltijdRepository.getMaaltijdenFromMaaltijdOnderdeel]
     */
    fun initializeMaaltijdOnderdeel(){
        uiScope.launch {
            _maaltijdOnderdeel.value = maaltijdOnderdeelRepo.getMaaltijdOnderdeel(maaltijdOnderdeel_id)
            _maaltijden.value = maaltijdRepo.getMaaltijdenFromMaaltijdOnderdeel(maaltijdOnderdeel_id)
        }
    }

    /**
     * CoRoutine launcher die het huidige maaltijdOnderdeel wijzigt in de Room-databank.
     * @see [MaaltijdOnderdeelRepository.updateMaaltijdOnderdeel]
     */
    private fun updateMaaltijdOnderdeel(){
        uiScope.launch {
            maaltijdOnderdeelRepo.updateMaaltijdOnderdeel(_maaltijdOnderdeel.value!!)
        }
    }

    /**
     * CoRoutine launcher die het huidige maaltijdOnderdeel verwijderd in de Room-databank.
     * Als het maaltijdOnderdeel nog verbonden is met maaltijden kan deze niet verwijderd worden.
     * @see [MaaltijdOnderdeelRepository.deleteMaaltijdOnderdeel]
     */
    fun deleteMaaltijdOnderdeel(){
        uiScope.launch {
            maaltijdRepo.getMaaltijdenFromMaaltijdOnderdeel(maaltijdOnderdeel_id)?.let {
                if(it.size > 0){
                    _showSnackBar.postValue("Can't delete mealpart. This mealparts is already linked to meals.")
                }
                else{
                    maaltijdOnderdeelRepo.deleteMaaltijdOnderdeel(_maaltijdOnderdeel.value!!)
                    _showSnackBar.postValue("Mealpart deleted.")
                }
            }
        }
    }


    /**
     * Business logica voor het aanpassen van de naam van het maaltijdOnderdeel
     * @param naam Naam van het maaltijdOnderdeel
     */
    fun setNaam(naam: String){
        this.maaltijdOnderdeel.value?.naam = naam
        updateMaaltijdOnderdeel()
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