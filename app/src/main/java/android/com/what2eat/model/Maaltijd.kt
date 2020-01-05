package android.com.what2eat.model

import android.com.what2eat.utils.DateConverter
import androidx.databinding.Bindable
import androidx.room.*
import java.lang.IllegalArgumentException
import java.util.*

/**
 * Model gebruikt voor een maaltijd
 * @property maaltijdId Id van de maaltijd
 * @property dateAdded Datum wanneer de maaltijd toegevoegd is
 * @property naam Naam van de maaltijd
 * @property rating Rating van de maaltijd (0-5)
 * @property dateLast Datum wanneer de maaltijd laatst gegegeten is
 * @property photo_uri URI waar de afbeelding van de maaltijd is opgeslaan
 * @property maaltijdOnderdelen MaaltijdOnderdelen ([MaaltijdOnderdeel]) die bij de maaltijd horen
 */
@Entity(tableName = "table_maaltijden")
@TypeConverters(DateConverter::class)
data class Maaltijd(

    @PrimaryKey(autoGenerate = true)
    var maaltijdId: Long = 0L,

    @ColumnInfo(name = "date_added")
    var dateAdded: Date = Date(),

    @ColumnInfo(name = "maaltijd_naam")
    var  naam: String = "",

    @ColumnInfo(name = "maaltijd_rating")
    var rating: Int = 0,

    @ColumnInfo(name = "date_last")
    var dateLast: Date? = null,

    @ColumnInfo(name = "maaltijd_photo_uri")
    var photo_uri: String? = null){

    @Ignore
    var maaltijdOnderdelen = mutableListOf<MaaltijdOnderdeel>()


    var naamProperty: String
        get() = naam
        set(value){
            if(value != null && value != ""){
                naam = value
            }
        }



    /**
     * Functie om een maaltijdOnderdeel toe te voegen aan de maaltijd
     * @param maaltijdOnderdeel MaaltijdOnderdeel dat moet worden toegevoegd
     */
    fun addMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        this.maaltijdOnderdelen.add(maaltijdOnderdeel)
    }

    /**
     * Functie om een maaltijdOnderdeel te verwijderen van de maaltijd
     * @param maaltijdOnderdeel MaaltijdOnderdeel dat moet worden verwijderd
     */
    fun removeMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        this.maaltijdOnderdelen.remove(maaltijdOnderdeel)
    }

    /**
     * Functie om na te gaan of de maaltijd gelijk is aan een opgegeven object
     * @param other Ander object om te vergelijken met de maaltijd
     */
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}