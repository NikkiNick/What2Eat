package android.com.what2eat.repositories

import android.com.what2eat.database.MaaltijdMaaltijdOnderdeelDao
import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdMaaltijdOnderdeel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository voor het het uitvoeren van databank-operaties voor [MaaltijdMaaltijdOnderdeel]
 * @param maaltijdMaaltijdOnderdeelDao DAO gebruikt voor databank-operaties
 */
class MaaltijdMaaltijdOnderdeelRepository(val maaltijdMaaltijdOnderdeelDao: MaaltijdMaaltijdOnderdeelDao) {

    /**
     * Co-Routine functie voor het toevoegen van een maaltijdOnderdeel aan een maaltijd (JOIN table).
     * Deze thread wordt op de achtergrond uitgevoerd.
     * @param maaltijdId Id van de maaltijd
     * @param maaltijdOnderdeelId Id van het maaltijdOnderdeel
     */
    suspend fun addMaaltijdOnderdeelToMaaltijd(maaltijdId: Long, maaltijdOnderdeelId: Long){
        withContext(Dispatchers.IO) {
            maaltijdMaaltijdOnderdeelDao.insert(MaaltijdMaaltijdOnderdeel(maaltijdId, maaltijdOnderdeelId))
        }
    }

    /**
     * Co-Routine functie voor het verwijderen van een maaltijdOnderdeel van een maaltijd (JOIN table).
     * Deze thread wordt op de achtergrond uitgevoerd.
     * @param maaltijdId Id van de maaltijd
     * @param maaltijdOnderdeelId Id van het maaltijdOnderdeel
     */
    suspend fun removeMaaltijdOnderdeelFromMaaltijd(maaltijdId: Long, maaltijdOnderdeelId: Long){
        withContext(Dispatchers.IO){
            maaltijdMaaltijdOnderdeelDao.delete(MaaltijdMaaltijdOnderdeel(maaltijdId, maaltijdOnderdeelId))
        }
    }

    /**
     * Co-Routine functie voor het verwijderen van alle relaties van een gegeven maaltijd (JOIN table).
     * Deze thread wordt op de achtergrond uitgevoerd.
     * @param maaltijdId Id van de maaltijd

     */
    suspend fun deleteMaaltijdenMaaltijdOnderdelenJoin(maaltijdId: Long){
        withContext(Dispatchers.IO){
            maaltijdMaaltijdOnderdeelDao.deleteFromMaaltijd(maaltijdId)
        }
    }

}