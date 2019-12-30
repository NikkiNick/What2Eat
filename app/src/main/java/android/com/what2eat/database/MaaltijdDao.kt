package android.com.what2eat.database

import android.com.what2eat.model.Maaltijd
import androidx.room.*

/**
 * DataAccessObject om Room-database operaties uit te voeren voor [Maaltijd] entities
 */
@Dao
interface MaaltijdDao {
    /**
     * Room-database operatie om een [Maaltijd] toe te voegen
     * @param maaltijd [Maaltijd] dat toegevoegd wordt
     * @return id van toegevoegde [Maaltijd]
     */
    @Insert
    fun insert(maaltijd: Maaltijd): Long
    /**
     * Room-database operatie om een [Maaltijd] aan te passen
     * @param maaltijd [Maaltijd] dat aangepast wordt
     */
    @Update
    fun update(maaltijd: Maaltijd)
    /**
     * Room-database operatie om een [Maaltijd] te verwijderen
     * @param maaltijd [Maaltijd] dat verwijderd wordt
     */
    @Delete
    fun delete(maaltijd: Maaltijd)
    /**
     * Room-database operatie om een [Maaltijd] op te halen aan de hand van een opgegeven id
     * @param id Id van [Maaltijd] dat opgevraagd wordt
     * @return Gevraagde [Maaltijd] met opgegeven id
     */
    @Transaction
    @Query("SELECT * FROM table_maaltijden WHERE maaltijdId = :id")
    fun get(id: Long): Maaltijd?
    /**
     * Room-database operatie om alle [Maaltijd] op te halen (DESC order)
     * @return List van [Maaltijd]
     */
    @Query("SELECT * FROM table_maaltijden ORDER BY maaltijdId DESC")
    fun getAll(): List<Maaltijd>?
    /**
     * Room-database operatie om alle [Maaltijd] te verwijderen
     */
    @Query("DELETE FROM table_maaltijden")
    fun deleteAll()
    /**
     * Room-database operatie om alle [Maaltijd] op te halen die een opgegeven maaltijdOnderdeel bevat
     * @param maaltijdOnderdeelId Id van maaltijdOnderdeel dat opgevraagd wordt
     * @return List van [Maaltijd] die gegeven maaltijdOnderdeel bevatten
     */
    @Query("SELECT * FROM table_maaltijden WHERE maaltijdId IN (SELECT maaltijdId FROM table_maaltijdMaaltijdOnderdeel WHERE maaltijdOnderdeelId = :maaltijdOnderdeelId)")
    fun getMaaltijdenFromMaaltijdOnderdeel(maaltijdOnderdeelId: Long): List<Maaltijd>?

}