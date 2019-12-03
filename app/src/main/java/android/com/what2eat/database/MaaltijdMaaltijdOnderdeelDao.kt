package android.com.what2eat.database

import android.com.what2eat.model.MaaltijdMaaltijdOnderdeel
import android.com.what2eat.model.MaaltijdOnderdeel
import androidx.room.*

@Dao
interface MaaltijdMaaltijdOnderdeelDao {

    @Insert
    fun insert(maaltijd: MaaltijdMaaltijdOnderdeel)

    @Update
    fun update(maaltijd: MaaltijdMaaltijdOnderdeel)

    @Delete
    fun delete(maaltijd: MaaltijdMaaltijdOnderdeel)

    @Query("SELECT * FROM table_maaltijdonderdelen AS mo INNER JOIN table_maaltijdMaaltijdOnderdeel AS mmo ON mo.maaltijdOnderdeelId = mmo.maaltijdOnderdeelId WHERE mmo.maaltijdId = :maaltijdId")
    fun getMaaltijdOnderdelenVanMaaltijd(maaltijdId: Long): List<MaaltijdOnderdeel>?
}