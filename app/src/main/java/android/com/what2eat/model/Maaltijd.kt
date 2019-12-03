package android.com.what2eat.model

import android.com.what2eat.utils.DateConverter
import androidx.room.*
import java.sql.Time
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "table_maaltijden")
@TypeConverters(DateConverter::class)
class Maaltijd() {

    @PrimaryKey(autoGenerate = true)
    var maaltijdId: Long = 0L

    @ColumnInfo(name = "date_added")
    var dateAdded: Date

    @ColumnInfo(name = "maaltijd_naam")
    var  naam: String = ""

    @Ignore
    var maaltijdOnderdelen = mutableListOf<MaaltijdOnderdeel>()

    @ColumnInfo(name = "maaltijd_rating")
    var rating: Int = 0

    @ColumnInfo(name = "date_last")
    var dateLast: Date? = null

    init {
        dateAdded = Date()
    }
    fun addMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        this.maaltijdOnderdelen.add(maaltijdOnderdeel)
    }
    fun removeMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        this.maaltijdOnderdelen.remove(maaltijdOnderdeel)
    }
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}