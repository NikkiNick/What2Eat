package android.com.what2eat.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*

@Entity(tableName = "table_maaltijden")
class Maaltijd() {

    @PrimaryKey(autoGenerate = true)
    var maaltijdId: Long = 0L

    //@ColumnInfo(name = "date_added")
    //var dateAdded: Date = Date()

    @ColumnInfo(name = "maaltijd_naam")
    var  naam: String = ""


    //ar maaltijdOnderdelen = mutableListOf<MaaltijdOnderdeel>()

    @ColumnInfo(name = "maaltijd_rating")
    var rating: Int = 0

    /*
    fun addMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        this.maaltijdOnderdelen.add(maaltijdOnderdeel)
    }
    fun removeMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        this.maaltijdOnderdelen.remove(maaltijdOnderdeel)
    }
     */


}