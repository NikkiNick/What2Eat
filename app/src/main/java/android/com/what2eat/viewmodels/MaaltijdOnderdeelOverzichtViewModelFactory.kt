package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.database.MaaltijdMaaltijdOnderdeelDao
import android.com.what2eat.database.MaaltijdOnderdeelDao
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MaaltijdOnderdeelOverzichtViewModelFactory(val maaltijdOnderdeelDbSource: MaaltijdOnderdeelDao, val maaltijdId: Long, val application: Application) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MaaltijdOnderdeelOverzichtViewModel::class.java)) {
            return MaaltijdOnderdeelOverzichtViewModel(maaltijdOnderdeelDbSource, maaltijdId, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}