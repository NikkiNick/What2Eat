package android.com.what2eat.database

import android.com.what2eat.model.MaaltijdMaaltijdOnderdeel
import android.com.what2eat.model.MaaltijdOnderdeel
import androidx.room.*

@Dao
interface MaaltijdMaaltijdOnderdeelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(maaltijd: MaaltijdMaaltijdOnderdeel)

    @Update
    fun update(maaltijd: MaaltijdMaaltijdOnderdeel)

    @Delete
    fun delete(maaltijd: MaaltijdMaaltijdOnderdeel)

    @Query("SELECT * FROM table_maaltijdMaaltijdOnderdeel")
    fun getAll(): List<MaaltijdMaaltijdOnderdeel>?

    @Query("SELECT * FROM table_maaltijdMaaltijdOnderdeel WHERE maaltijdId = :maaltijdId")
    fun getFromMaaltijd(maaltijdId: Long): List<MaaltijdMaaltijdOnderdeel>?

}