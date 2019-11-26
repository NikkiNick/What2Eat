package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.database.MaaltijdDatabaseDao
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MaaltijdViewModelFactory(val dataSource: MaaltijdDatabaseDao, val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MaaltijdViewModel::class.java)) {
            return MaaltijdViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}