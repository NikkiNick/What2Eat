package android.com.what2eat.database

import android.com.what2eat.model.Maaltijd
import androidx.room.*

@Dao
interface MaaltijdDao {

    @Insert
    fun insert(maaltijd: Maaltijd)

    @Update
    fun update(maaltijd: Maaltijd)

    @Delete
    fun delete(maaltijd: Maaltijd)

    @Transaction
    @Query("SELECT * FROM table_maaltijden WHERE maaltijdId = :id")
    fun get(id: Long): Maaltijd?

    @Query("SELECT * FROM table_maaltijden ORDER BY maaltijdId DESC")
    fun getAll(): List<Maaltijd>?

    @Query("DELETE FROM table_maaltijden")
    fun deleteAll()

    //@Query("SELECT * FROM table_maaltijden ORDER BY date_added DESC LIMIT 1")
    //fun getLatest(): Maaltijd
}