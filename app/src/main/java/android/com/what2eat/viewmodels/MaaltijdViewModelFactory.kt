package android.com.what2eat.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MaaltijdViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MaaltijdViewModel::class.java)) {
            return MaaltijdViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}