package android.com.what2eat.viewmodels

import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdOnderdeel
import android.com.what2eat.repositories.MaaltijdMaaltijdOnderdeelRepository
import android.com.what2eat.repositories.MaaltijdOnderdeelRepository
import android.com.what2eat.repositories.MaaltijdRepository
import androidx.lifecycle.*
import kotlinx.coroutines.*
import javax.inject.Inject

/**
 * ViewModel voor business logica rond een bepaalde maaltijd in detail.
 * @property maaltijdId Id van de maaltijd waarrond het ViewModel is opgebouwd
 * @property maaltijdRepo Repository voor Room databank operaties voor maaltijden
 * @property maaltijdOnderdeelRepo Repository voor Room databank operaties voor maaltijdOnderdelen
 * @property maaltijdMaaltijdOnderdeelRepo Repository voor Room databank operaties voor relaties tussen maaltijden en maaltijdOndedelen (JOIN table)
 * @property maaltijd [Maaltijd] waarrond het ViewModel opgebouwd is
 * @property maaltijdOnderdelen Lijst van [MaaltijdOnderdeel] die bij de maaltijd horen
 */
class MaaltijdDetailViewModel(val maaltijdId: Long): ViewModel(){

    /**
     * Injected properties
     */
    @Inject lateinit var maaltijdRepo: MaaltijdRepository
    @Inject lateinit var maaltijdOnderdeelRepo: MaaltijdOnderdeelRepository
    @Inject lateinit var maaltijdMaaltijdOnderdeelRepo: MaaltijdMaaltijdOnderdeelRepository

    /**
     * ViewModel LiveData Properties
     */
    private var _maaltijd = MutableLiveData<Maaltijd>()
    val maaltijd: LiveData<Maaltijd>
        get() = _maaltijd

    private var _maaltijdOnderdelen = MutableLiveData<List<MaaltijdOnderdeel>?>()
    val maaltijdOnderdelen: LiveData<List<MaaltijdOnderdeel>?>
        get() = _maaltijdOnderdelen

    private var _changeRatingDisplay = MutableLiveData<Int>()
    val changeRatingDisplay: LiveData<Int>
        get() = _changeRatingDisplay


    /**
     * CoRoutine Properties
     */
    var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    /**
     * Initialisatie van het ViewModel. Dependency injection in het ViewModel en initialisatie van de
     * maaltijd en gelinkte maaltijdOnderdelen
     */
    init{
        android.com.what2eat.Application.component.inject(this)
        initializeMaaltijd()
    }

    /**
     * CoRoutine launcher die de huidige maaltijd ophaalt van de Room-databank aan de hand van de
     * maaltijdId waarmee het ViewModel gecreëert is, alsook de maaltijdOnderdelen die horen bij de maaltijd
     * @see [MaaltijdRepository.getMaaltijd]
     * @see [MaaltijdOnderdeelRepository.getMaaltijdOnderdelenFromMaaltijd]
     */
    fun initializeMaaltijd(){
        uiScope.launch {
            _maaltijd.value = maaltijdRepo.getMaaltijd(maaltijdId)
            _maaltijdOnderdelen.value = maaltijdOnderdeelRepo.getMaaltijdOnderdelenFromMaaltijd(maaltijdId)
        }
    }

    /**
     * CoRoutine launcher die de huidige maaltijd wijzigt in de Room-databank.
     * @see [MaaltijdRepository.saveMaaltijd]
     */
    fun saveMaaltijd(){
        uiScope.launch {
            maaltijdRepo.saveMaaltijd(_maaltijd.value!!)
        }
    }

    /**
     * CoRoutine launcher die de huidige maaltijd verwijderd va de Room-databank, alsook de relaties die
     * aanwezig waren voor de huidige maaltijden en eventuele maaltijdOnderdelen (JOIN table)
     * @see [MaaltijdRepository.deleteMaaltijd]
     * @see [MaaltijdMaaltijdOnderdeelRepository.deleteMaaltijdenMaaltijdOnderdelenJoin]
     */
    fun deleteMaaltijd(){
        uiScope.launch {
            maaltijdRepo.deleteMaaltijd(_maaltijd.value!!)
            maaltijdMaaltijdOnderdeelRepo.deleteMaaltijdenMaaltijdOnderdelenJoin(_maaltijd.value!!.maaltijdId)
        }
    }

    /**
     * CoRoutine launcher die een Array van maaltijdOnderdeelIds kan verbinden met de huidige maaltijd
     * in de Room-databank. Er wordt voor elk id een relatie aangemaakt (JOIN table) tussen de maaltijd en
     * het maaltijdOnderdeel.
     * @see [MaaltijdMaaltijdOnderdeelRepository.addMaaltijdOnderdeelToMaaltijd]
     */
    fun addMaaltijdOnderdelenToMaaltijd(ids: LongArray){
        uiScope.launch {
            ids.forEach { id -> maaltijdMaaltijdOnderdeelRepo.addMaaltijdOnderdeelToMaaltijd(maaltijdId, id)}
            initializeMaaltijd()
        }
    }
    /**
     * CoRoutine launcher die maaltijdOnderdeel verwijderd van de huidige maaltijd
     * in de Room-databank. De relatie (JOIN table) tussen de maaltijd en het maaltijdOnderdeel wordt verwijderd.
     * @see [MaaltijdMaaltijdOnderdeelRepository.removeMaaltijdOnderdeelFromMaaltijd]
     */
    fun removeMaaltijdOnderdeelFromMaaltijd(maaltijdOnderdeelId: Long){
        uiScope.launch {
            maaltijdMaaltijdOnderdeelRepo.removeMaaltijdOnderdeelFromMaaltijd(maaltijdId, maaltijdOnderdeelId)
            initializeMaaltijd()
        }
    }

    /**
     * Business logica voor het aanpassen van de rating van de maaltijd
     * @param rating Rating van de maaltijd
     */
    fun setRating(rating: Int){
        _maaltijd.value?.rating = rating
        _changeRatingDisplay.value = rating
    }

    /**
     * Business logica voor het aanpassen van de afbeeldingURI van de maaltijd
     * @param uri AfbeeldingURI van de maaltijd
     */
    fun setMaaltijdPhoto(uri: String){
        _maaltijd.value?.photo_uri = uri
    }

    /**
     * Business logica voor het verwijderen van de afbeeldingURI van de maaltijd
     */
    fun removeMaaltijdPhoto(){
        _maaltijd.value?.photo_uri = null
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