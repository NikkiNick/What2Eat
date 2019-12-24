package android.com.what2eat.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MaaltijdDetailViewModelFactory(val maaltijdId: Long) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MaaltijdDetailViewModel::class.java)) {
            return MaaltijdDetailViewModel(maaltijdId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}