package android.com.what2eat.model

import androidx.room.*

@Entity(tableName = "table_maaltijdonderdelen")
class MaaltijdOnderdeel {

    @PrimaryKey(autoGenerate = true)
    var maaltijdOnderdeelId: Long = 0L

    @ColumnInfo(name = "maaltijdOnderdeel_naam")
    var naam: String = ""

    @Ignore
    var isSelected: Boolean? = false

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}