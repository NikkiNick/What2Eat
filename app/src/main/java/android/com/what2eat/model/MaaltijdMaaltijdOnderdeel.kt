package android.com.what2eat.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "table_maaltijdMaaltijdOnderdeel",
        primaryKeys = ["maaltijdId", "maaltijdOnderdeelId"],
        indices = [Index("maaltijdOnderdeelId")])
class MaaltijdMaaltijdOnderdeel(
    var maaltijdId: Long,
    var maaltijdOnderdeelId: Long
)