package android.com.what2eat.viewmodels.viewModelFactories

import android.com.what2eat.viewmodels.MaaltijdOnderdeelSelectViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Factory voor het aanmaken van een [MaaltijdOnderdeelSelectViewModel]. Dit ViewModel wordt aangemaakt met
 * een gegeven id van een maaltijd.
 * @param maaltijdId Id van de gegeven maaltijd
 */
class MaaltijdOnderdeelSelectViewModelFactory(val maaltijdId: Long) : ViewModelProvider.Factory {

    /**
     * Creëert het [MaaltijdOnderdeelSelectViewModel] met gegeven maaltijdId
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MaaltijdOnderdeelSelectViewModel::class.java)) {
            return MaaltijdOnderdeelSelectViewModel(
                maaltijdId
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}