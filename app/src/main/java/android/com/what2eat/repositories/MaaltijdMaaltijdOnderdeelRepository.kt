package android.com.what2eat.repositories

import android.com.what2eat.database.MaaltijdMaaltijdOnderdeelDao
import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdMaaltijdOnderdeel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MaaltijdMaaltijdOnderdeelRepository(val maaltijdMaaltijdOnderdeelDao: MaaltijdMaaltijdOnderdeelDao) {

    suspend fun addMaaltijdOnderdeelToMaaltijd(maaltijdId: Long, maaltijdOnderdeelId: Long){
        withContext(Dispatchers.IO) {
            maaltijdMaaltijdOnderdeelDao.insert(MaaltijdMaaltijdOnderdeel(maaltijdId, maaltijdOnderdeelId))
        }
    }
    suspend fun removeMaaltijdOnderdeelFromMaaltijd(maaltijdId: Long, maaltijdOnderdeelId: Long){
        withContext(Dispatchers.IO){
            maaltijdMaaltijdOnderdeelDao.delete(MaaltijdMaaltijdOnderdeel(maaltijdId, maaltijdOnderdeelId))
        }
    }
    suspend fun deleteMaaltijdenMaaltijdOnderdelenJoin(maaltijd: Maaltijd){
        withContext(Dispatchers.IO){
            maaltijdMaaltijdOnderdeelDao.deleteFromMaaltijd(maaltijd.maaltijdId)
        }
    }
}