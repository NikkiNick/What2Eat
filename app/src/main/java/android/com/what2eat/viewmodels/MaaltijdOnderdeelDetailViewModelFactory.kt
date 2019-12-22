package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.database.MaaltijdOnderdeelDao
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MaaltijdOnderdeelDetailViewModelFactory(
    val maaltijdOnderdeelDbSource: MaaltijdOnderdeelDao,
    val maaltijdDbSource: MaaltijdDao,
    val maaltijdOnderdeelId: Long,
    val application: Application) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MaaltijdOnderdeelDetailViewModel::class.java)) {
            return MaaltijdOnderdeelDetailViewModel(maaltijdOnderdeelDbSource, maaltijdDbSource,  maaltijdOnderdeelId, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}