package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.database.MaaltijdDao
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MaaltijdViewModelFactory(val maaltijdDbSource: MaaltijdDao,
                               val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MaaltijdViewModel::class.java)) {
            return MaaltijdViewModel(maaltijdDbSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}