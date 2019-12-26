package android.com.what2eat.database

import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdMaaltijdOnderdeel
import androidx.room.*
/**
 * DataAccessObject om Room-database operaties uit te voeren voor [MaaltijdMaaltijdOnderdeel] entities
 */
@Dao
interface MaaltijdMaaltijdOnderdeelDao {
    /**
     * Room-database operatie om een [MaaltijdMaaltijdOnderdeel] toe te voegen
     * @param maaltijdMaaltijdOnderdeel [MaaltijdMaaltijdOnderdeel] dat toegevoegd wordt
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(maaltijdMaaltijdOnderdeel: MaaltijdMaaltijdOnderdeel)
    /**
     * Room-database operatie om een [MaaltijdMaaltijdOnderdeel] aan te passen
     * @param maaltijdMaaltijdOnderdeel [MaaltijdMaaltijdOnderdeel] dat aangepast wordt
     */
    @Update
    fun update(maaltijdMaaltijdOnderdeel: MaaltijdMaaltijdOnderdeel)
    /**
     * Room-database operatie om een [MaaltijdMaaltijdOnderdeel] te verwijderen
     * @param maaltijdMaaltijdOnderdeel [MaaltijdMaaltijdOnderdeel] dat verwijderd wordt
     */
    @Delete
    fun delete(maaltijdMaaltijdOnderdeel: MaaltijdMaaltijdOnderdeel)
    /**
     * Room-database operatie om alle [MaaltijdMaaltijdOnderdeel] op te halen (DESC order)
     * @return List van [MaaltijdMaaltijdOnderdeel]
     */
    @Query("SELECT * FROM table_maaltijdMaaltijdOnderdeel")
    fun getAll(): List<MaaltijdMaaltijdOnderdeel>?
    /**
     * Room-database operatie om alle [MaaltijdMaaltijdOnderdeel] op te halen van een opgegeven [Maaltijd]
     * @param maaltijdId Id van de opgegeven [Maaltijd]
     * @return List van [MaaltijdMaaltijdOnderdeel]
     */
    @Query("SELECT * FROM table_maaltijdMaaltijdOnderdeel WHERE maaltijdId = :maaltijdId")
    fun getFromMaaltijd(maaltijdId: Long): List<MaaltijdMaaltijdOnderdeel>?
    /**
     * Room-database operatie om alle [MaaltijdMaaltijdOnderdeel] op te halen van een opgegeven maaltijdOnderdeel
     * @param maaltijdOnderdeelId Id van de opgegeven maaltijdOnderdeel
     * @return List van [MaaltijdMaaltijdOnderdeel]
     */
    @Query("SELECT * FROM table_maaltijdMaaltijdOnderdeel WHERE maaltijdOnderdeelId = :maaltijdOnderdeelId")
    fun getFromMaaltijdOnderdeel(maaltijdOnderdeelId: Long): List<MaaltijdMaaltijdOnderdeel>?

    /**
     * Room-database operatie om alle [MaaltijdMaaltijdOnderdeel] van een opgegeven [Maaltijd] te verwijderen
     * @param maaltijdId Id van de gegeven [Maaltijd]
     */
    @Query("DELETE FROM table_maaltijdMaaltijdOnderdeel WHERE maaltijdId = :maaltijdId")
    fun deleteFromMaaltijd(maaltijdId: Long)

}