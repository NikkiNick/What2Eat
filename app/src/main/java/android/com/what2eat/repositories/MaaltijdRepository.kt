package android.com.what2eat.repositories

import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.model.Maaltijd
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MaaltijdRepository(val maaltijdDbSource: MaaltijdDao) {

    suspend fun getMaaltijd(maaltijdId: Long): Maaltijd? {
        return withContext(Dispatchers.IO){
            maaltijdDbSource.get(maaltijdId)
        }
    }
    suspend fun getMaaltijdenFromMaaltijdOnderdeel(maaltijdOnderdeel_id: Long): List<Maaltijd>?{
        return withContext(Dispatchers.IO){
            maaltijdDbSource.getMaaltijdenFromMaaltijdOnderdeel(maaltijdOnderdeel_id)
        }
    }
    suspend fun getAllMaaltijden(): List<Maaltijd>?{
        return withContext(Dispatchers.IO){
            maaltijdDbSource.getAll()
        }
    }
    suspend fun saveMaaltijd(maaltijd: Maaltijd){
        withContext(Dispatchers.IO){
            maaltijdDbSource.update(maaltijd)
        }
    }
    suspend fun deleteMaaltijd(maaltijd: Maaltijd){
        withContext(Dispatchers.IO){
            maaltijdDbSource.delete(maaltijd)
        }
    }
    suspend fun addMaaltijd(maaltijd: Maaltijd): Long{
        return withContext(Dispatchers.IO){
            maaltijdDbSource.insert(maaltijd)
        }
    }

}