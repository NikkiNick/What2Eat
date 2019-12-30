package android.com.what2eat.viewmodels.viewModelFactories

import android.com.what2eat.viewmodels.MaaltijdDetailViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Factory voor het aanmaken van een [MaaltijdDetailViewModel]. Dit ViewModel wordt aangemaakt met
 * een gegeven id van een maaltijd.
 * @param maaltijdId Id van de gegeven maaltijd
 */
class MaaltijdDetailViewModelFactory(val maaltijdId: Long) : ViewModelProvider.Factory {

    /**
     * Creëert het [MaaltijdDetailViewModel] met gegeven maaltijdId
     */
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MaaltijdDetailViewModel::class.java)) {
            return MaaltijdDetailViewModel(
                maaltijdId
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}