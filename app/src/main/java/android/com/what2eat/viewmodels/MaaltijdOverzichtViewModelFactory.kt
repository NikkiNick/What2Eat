package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.database.MaaltijdDao
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MaaltijdOverzichtViewModelFactory(val dataSource: MaaltijdDao, val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MaaltijdOverzichtViewModel::class.java)) {
            return MaaltijdOverzichtViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}