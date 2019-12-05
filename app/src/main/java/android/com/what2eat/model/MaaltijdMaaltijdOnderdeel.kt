package android.com.what2eat.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "table_maaltijdMaaltijdOnderdeel",
        primaryKeys = ["maaltijdId", "maaltijdOnderdeelId"],
        foreignKeys = [
            ForeignKey( entity = Maaltijd::class,
                        parentColumns = ["maaltijdId"],
                        childColumns = ["maaltijdId"]),
            ForeignKey( entity = MaaltijdOnderdeel::class,
                        parentColumns = ["maaltijdOnderdeelId"],
                        childColumns = ["maaltijdOnderdeelId"])
], indices = [Index("maaltijdOnderdeelId")])
class MaaltijdMaaltijdOnderdeel(
    var maaltijdId: Long,
    var maaltijdOnderdeelId: Long
)