package android.com.what2eat.model

import androidx.room.*

/**
 * Model gebruikt voor een MaaltijdOnderdeel
 * @property maaltijdOnderdeelId Id van het maaltijdOnderdeel
 * @property naam Naam van het maaltijdOnderdeel
 * @property isSelected Waarde die bijhoudt of het maaltijdOnderdeel geselecteerd is in een select List
 */
@Entity(tableName = "table_maaltijdonderdelen")
class MaaltijdOnderdeel {

    @PrimaryKey(autoGenerate = true)
    var maaltijdOnderdeelId: Long = 0L

    @ColumnInfo(name = "maaltijdOnderdeel_naam")
    var naam: String = ""

    @Ignore
    var isSelected: Boolean? = false

    /**
     * Functie om na te gaan of het maaltijdOnderdeel gelijk is aan een opgegeven object
     * @param other Ander object om te vergelijken met het maaltijdOnderdeel
     */
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}