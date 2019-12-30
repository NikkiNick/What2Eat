package android.com.what2eat.viewmodels.viewModelFactories

import android.com.what2eat.viewmodels.MaaltijdOnderdeelDetailViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Factory voor het aanmaken van een [MaaltijdOnderdeelDetailViewModel]. Dit ViewModel wordt aangemaakt met
 * een gegeven id van een maaltijdOnderdeel.
 * @param maaltijdOnderdeelId Id van het gegeven maaltijdOnderdeel
 */
class MaaltijdOnderdeelDetailViewModelFactory(val maaltijdOnderdeelId: Long) : ViewModelProvider.Factory {

    /**
     * Creëert het [MaaltijdOnderdeelDetailViewModel] met gegeven maaltijdOnderdeelId
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MaaltijdOnderdeelDetailViewModel::class.java)) {
            return MaaltijdOnderdeelDetailViewModel(
                maaltijdOnderdeelId
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}