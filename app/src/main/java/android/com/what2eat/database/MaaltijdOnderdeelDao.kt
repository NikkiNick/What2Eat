package android.com.what2eat.database

import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdOnderdeel
import androidx.room.*

@Dao
interface MaaltijdOnderdeelDao {

    @Insert
    fun insert(maaltijdOnderdeel: MaaltijdOnderdeel): Long

    @Update
    fun update(maaltijdOnderdeel: MaaltijdOnderdeel)

    @Delete
    fun delete(maaltijdOnderdeel: MaaltijdOnderdeel)

    @Query("SELECT * FROM table_maaltijdonderdelen WHERE maaltijdOnderdeelId = :id")
    fun get(id: Long): MaaltijdOnderdeel?

    @Query("SELECT * FROM table_maaltijdonderdelen ORDER BY maaltijdOnderdeelId DESC")
    fun getAll(): List<MaaltijdOnderdeel>?

    @Query("DELETE FROM table_maaltijdonderdelen")
    fun deleteAll()
}