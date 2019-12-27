package android.com.what2eat.repositories

import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.model.Maaltijd
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository voor het het uitvoeren van databank-operaties voor [Maaltijd]
 * @param maaltijdDbSource DAO gebruikt voor databank-operaties
 */
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

    /**
     * Co-Routine functie voor het ophalen van alle maaltijden van de Room-databank.
     * Deze thread wordt op de achtergrond uitgevoerd.
     * @return Lijst van maaltijden
     */
    suspend fun getAllMaaltijden(): List<Maaltijd>?{
        return withContext(Dispatchers.IO){
            maaltijdDbSource.getAll()
        }
    }

    /**
     * Co-Routine functie voor het aanpassen van een maaltijd van de Room-databank.
     * Deze thread wordt op de achtergrond uitgevoerd.
     * @param maaltijd Maaltijd dat wordt aangepast.
     */
    suspend fun saveMaaltijd(maaltijd: Maaltijd){
        withContext(Dispatchers.IO){
            maaltijdDbSource.update(maaltijd)
        }
    }

    /**
     * Co-Routine functie voor het verwijderen van een maaltijd van de Room-databank.
     * Deze thread wordt op de achtergrond uitgevoerd.
     * @param maaltijd Maaltijd dat wordt verwijderd.
     */
    suspend fun deleteMaaltijd(maaltijd: Maaltijd){
        withContext(Dispatchers.IO){
            maaltijdDbSource.delete(maaltijd)
        }
    }

    /**
     * Co-Routine functie voor het toevoegen van een maaltijd aan de Room-databank.
     * Deze thread wordt op de achtergrond uitgevoerd.
     * @param maaltijd Maaltijd dat wordt toegevoegd.
     * @return Id van de nieuwe maaltijd
     */
    suspend fun addMaaltijd(maaltijd: Maaltijd): Long{
        return withContext(Dispatchers.IO){
            maaltijdDbSource.insert(maaltijd)
        }
    }

}