package android.com.what2eat.viewmodels

import android.app.Application
import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.database.MaaltijdMaaltijdOnderdeelDao
import android.com.what2eat.database.MaaltijdOnderdeelDao
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MaaltijdDetailViewModelFactory(
    val maaltijdId: Long,
    val maaltijdDbSource: MaaltijdDao,
    val maaltijdOnderdeelDbSource: MaaltijdOnderdeelDao,
    val maaltijdMaaltijdOnderdeelDbSource: MaaltijdMaaltijdOnderdeelDao,
    val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MaaltijdDetailViewModel::class.java)) {
            return MaaltijdDetailViewModel(maaltijdId, maaltijdDbSource, maaltijdOnderdeelDbSource, maaltijdMaaltijdOnderdeelDbSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}