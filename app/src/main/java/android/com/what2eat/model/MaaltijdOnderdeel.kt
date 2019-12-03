package android.com.what2eat.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "table_maaltijdonderdelen")
class MaaltijdOnderdeel {

    @PrimaryKey(autoGenerate = true)
    var maaltijdOnderdeelId: Long = 0L
    @ColumnInfo(name = "maaltijdOnderdeel_naam")
    var naam: String = ""
    /*
    var ingredienten = mutableListOf<Ingredient>()

    fun addIngredient(ingredient: Ingredient){
        this.ingredienten.add(ingredient)
    }
    fun removeIngredient(ingredient: Ingredient){
        this.ingredienten.remove(ingredient)
    }
     */

}