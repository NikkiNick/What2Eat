package android.com.what2eat.repositories

import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.database.MaaltijdMaaltijdOnderdeelDao
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdOnderdeel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository voor het het uitvoeren van databank-operaties voor [MaaltijdOnderdeel]
 * @param maaltijdOnderdeelDbSource DAO gebruikt voor databank-operaties
 */
class MaaltijdOnderdeelRepository(val maaltijdOnderdeelDbSource: MaaltijdOnderdeelDao) {

    /**
     * Co-Routine functie voor het ophalen van alle  maaltijdOnderdelen van de Room-databank.
     * Deze thread wordt op de achtergrond uitgevoerd.
     * @return Lijst van maaltijdOnderdelen
     */
    suspend fun getAllMaaltijdOnderdelen(): List<MaaltijdOnderdeel>?{
        return withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.getAll()
        }
    }

    /**
     * Co-Routine functie voor het ophalen van een bepaalde maaltijdOnderdeel van de Room-databank.
     * Deze thread wordt op de achtergrond uitgevoerd.
     * @param maaltijdOnderdeel_id Id van het gevraagde maaltijdOnderdeel
     * @return MaaltijdOnderdeel
     */
    suspend fun getMaaltijdOnderdeel(maaltijdOnderdeel_id: Long): MaaltijdOnderdeel? {
        return withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.get(maaltijdOnderdeel_id)
        }
    }

    /**
     * Co-Routine functie voor het ophalen van alle maaltijdOnderdelen van een gegeven maaltijdOnderdeel
     * van de Room-databank. Deze thread wordt op de achtergrond uitgevoerd.
     * @param maaltijdId Id van de gegeven maaltijd
     * @return Lijst van maaltijdOnderdelen
     */
    suspend fun getMaaltijdOnderdelenFromMaaltijd(maaltijdId: Long): List<MaaltijdOnderdeel>? {
        return withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.getMaaltijdOnderdelenVanMaaltijd(maaltijdId)
        }
    }

    /**
     * Co-Routine functie voor het ophalen van alle maaltijdOnderdelen die niet bij een gegeven
     * maaltijdOnderdeel horen van de Room-databank. Deze thread wordt op de achtergrond uitgevoerd.
     * @param maaltijdId Id van de gegeven maaltijd
     * @return Lijst van maaltijdOnderdelen
     */
    suspend fun getAllMaaltijdOnderdelenNotFromMaaltijd(maaltijdId: Long): List<MaaltijdOnderdeel>?{
        return withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.getMaaltijdOnderdelenNietVanMaaltijd(maaltijdId)
        }
    }

    /**
     * Co-Routine functie voor het toevoegen van een maaltijdOnderdeel aan de Room-databank.
     * Deze thread wordt op de achtergrond uitgevoerd.
     * @param maaltijdOnderdeel MaaltijdOndedeel dat wordt toegevoegd
     */
    suspend fun addMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.insert(maaltijdOnderdeel)
        }
    }

    /**
     * Co-Routine functie voor het aanpassen van een maaltijdOnderdeel aan de Room-databank.
     * Deze thread wordt op de achtergrond uitgevoerd.
     * @param maaltijdOnderdeel MaaltijdOndedeel dat wordt aangepast
     */
    suspend fun updateMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel) {
        withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.update(maaltijdOnderdeel)
        }
    }

    /**
     * Co-Routine functie voor het verwijderen van een maaltijdOnderdeel van de Room-databank.
     * Deze thread wordt op de achtergrond uitgevoerd.
     * @param maaltijdOnderdeel MaaltijdOndedeel dat wordt verwijderd
     */
    suspend fun deleteMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        withContext(Dispatchers.IO){
            maaltijdOnderdeelDbSource.delete(maaltijdOnderdeel)
        }
    }

}