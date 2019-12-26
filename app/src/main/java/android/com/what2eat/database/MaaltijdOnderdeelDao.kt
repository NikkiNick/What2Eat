package android.com.what2eat.database

import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdOnderdeel
import androidx.room.*
/**
 * DataAccessObject om Room-database operaties uit te voeren voor [MaaltijdOnderdeel] entities
 */
@Dao
interface MaaltijdOnderdeelDao {
    /**
     * Room-database operatie om een [MaaltijdOnderdeel] toe te voegen
     * @param maaltijdOnderdeel [MaaltijdOnderdeel] dat toegevoegd wordt
     */
    @Insert
    fun insert(maaltijdOnderdeel: MaaltijdOnderdeel): Long
    /**
     * Room-database operatie om een [MaaltijdOnderdeel] aan te passen
     * @param maaltijdOnderdeel [MaaltijdOnderdeel] dat aangepast wordt
     */
    @Update
    fun update(maaltijdOnderdeel: MaaltijdOnderdeel)
    /**
     * Room-database operatie om een [MaaltijdOnderdeel] te verwijderen
     * @param maaltijdOnderdeel [MaaltijdOnderdeel] dat verwijderd wordt
     */
    @Delete
    fun delete(maaltijdOnderdeel: MaaltijdOnderdeel)
    /**
     * Room-database operatie om een [MaaltijdOnderdeel] op te halen aan de hand van een opgegeven id
     * @param id Id van [MaaltijdOnderdeel] dat opgevraagd wordt
     * @return Gevraagde [MaaltijdOnderdeel] met opgegeven id
     */
    @Query("SELECT * FROM table_maaltijdonderdelen WHERE maaltijdOnderdeelId = :id")
    fun get(id: Long): MaaltijdOnderdeel?
    /**
     * Room-database operatie om alle [Maaltijd] op te halen (DESC order)
     * @return List van [Maaltijd]
     */
    @Query("SELECT * FROM table_maaltijdonderdelen ORDER BY maaltijdOnderdeelId DESC")
    fun getAll(): List<MaaltijdOnderdeel>?
    /**
     * Room-database om alle [MaaltijdOnderdeel] op te halen die bij een opgegeven [Maaltijd] horen
     * @param maaltijdId Id van gegeven [Maaltijd]
     * @return List van [MaaltijdOnderdeel]
     */
    @Query("SELECT mo.maaltijdOnderdeelId, mo.maaltijdOnderdeel_naam FROM table_maaltijdonderdelen AS mo INNER JOIN table_maaltijdMaaltijdOnderdeel AS mmo ON mo.maaltijdOnderdeelId = mmo.maaltijdOnderdeelId WHERE mmo.maaltijdId = :maaltijdId")
    fun getMaaltijdOnderdelenVanMaaltijd(maaltijdId: Long): List<MaaltijdOnderdeel>?
    /**
     * Room-database om alle [MaaltijdOnderdeel] op te halen die bij niet een opgegeven [Maaltijd] horen
     * @param maaltijdId Id van gegeven [Maaltijd]
     * @return List van [MaaltijdOnderdeel]
     */
    @Query("SELECT * FROM table_maaltijdonderdelen WHERE maaltijdOnderdeelId NOT IN (SELECT maaltijdOnderdeelId FROM table_maaltijdMaaltijdOnderdeel WHERE maaltijdId = :maaltijdId)")
    fun getMaaltijdOnderdelenNietVanMaaltijd(maaltijdId: Long): List<MaaltijdOnderdeel>?

}