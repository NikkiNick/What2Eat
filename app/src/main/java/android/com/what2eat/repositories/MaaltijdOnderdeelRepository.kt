package android.com.what2eat.repositories

import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.database.MaaltijdMaaltijdOnderdeelDao
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdOnderdeel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MaaltijdOnderdeelRepository(val maaltijdOnderdeelDbSource: MaaltijdOnderdeelDao) {

    suspend fun getAllMaaltijdOnderdelen(): List<MaaltijdOnderdeel>?{
        return withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.getAll()
        }
    }
    suspend fun getMaaltijdOnderdeel(maaltijdOnderdeel_id: Long): MaaltijdOnderdeel? {
        return withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.get(maaltijdOnderdeel_id)
        }
    }
    suspend fun getMaaltijdOnderdelenFromMaaltijd(maaltijdId: Long): List<MaaltijdOnderdeel>? {
        return withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.getMaaltijdOnderdelenVanMaaltijd(maaltijdId)
        }
    }
    suspend fun getAllMaaltijdOnderdelenNotFromMaaltijd(maaltijdId: Long): List<MaaltijdOnderdeel>?{
        return withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.getMaaltijdOnderdelenNietVanMaaltijd(maaltijdId)
        }
    }
    suspend fun addMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.insert(maaltijdOnderdeel)
            //TODO: initMaaltijdOnderdelen()
        }
    }
    suspend fun updateMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel) {
        withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.update(maaltijdOnderdeel)
        }
    }
    suspend fun deleteMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.delete(maaltijdOnderdeel)
        }
    }

}