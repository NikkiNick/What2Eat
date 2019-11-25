package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.R
import android.com.what2eat.database.MaaltijdDatabaseDao
import android.com.what2eat.model.Maaltijd
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class MaaltijdDetailViewModel(val maaltijdId: Long, val db: MaaltijdDatabaseDao, application: Application): AndroidViewModel(application) {
    /*
    CoRoutine setup
     */
    var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    /*
    Main object binding
     */
    private var _maaltijd = MutableLiveData<Maaltijd>()
    val maaltijd: LiveData<Maaltijd>
        get() = _maaltijd

    /*
    Rating binding
     */
    val ratingStrings = listOf(
        application.applicationContext.getString(R.string.rating0),
        application.applicationContext.getString(R.string.rating1),
        application.applicationContext.getString(R.string.rating2),
        application.applicationContext.getString(R.string.rating3),
        application.applicationContext.getString(R.string.rating4),
        application.applicationContext.getString(R.string.rating5))
    var _ratingString = MutableLiveData<String>()
    val ratingString: LiveData<String>
        get() = _ratingString

    init{
        initializeMaaltijd()
    }

    /*
    Co-Routines
     */
    fun initializeMaaltijd(){
        uiScope.launch {
            _maaltijd.value = getMaaltijdFromDatabase()
        }
    }
    private suspend fun getMaaltijdFromDatabase(): Maaltijd? {
        return withContext(Dispatchers.IO){
            db.get(maaltijdId)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}