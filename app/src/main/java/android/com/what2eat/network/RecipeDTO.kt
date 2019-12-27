package android.com.what2eat.network

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize

/**
 * Response klasse waarnaar de API response gemapt worden.
 * Enkel 'hits' (lijst van recepten) uit de response bijgehouden
 * @property recipes Response bevat een lijst van [Recipe]
 */
@JsonClass(generateAdapter = true)
data class Response(
    @Json(name="hits")
    val recipes: List<Recipe>
)

/**
 * Recipe klasse waarnaar de API recipes gemapt worden
 * @property recipe Recipe bevat [RecipeData]
 *
 */
@JsonClass(generateAdapter = true)
data class Recipe(
    @Json(name="recipe")
    val recipe: RecipeData
)

/**
 * Recipedata klasse waarnaar de API recipe data gemapt wordt
 * @property naam Naam van het recept
 * @property image_url URL van de afbeelding van het recept
 * @property remote_site_url URL van de website waar het recept terug te vinden is
 * @property ingredienten Ingredientenlijst van het recept
 */
@Parcelize
@JsonClass(generateAdapter = true)
data class RecipeData(
    @Json(name="label")
    val naam: String?,

    @Json(name="image")
    val image_url: String?,

    @Json(name="url")
    val remote_site_url: String?,

    @Json(name="ingredientLines")
    val ingredienten: List<String>?

): Parcelable {
    constructor(parcel: Parcel): this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList()
    )

    companion object : Parceler<RecipeData> {
        /**
         * Functie voor het mappen van een Recipe naar een Parcel
         * @param parcel Parcel waarnaar gemapt wordt
         * @param flags
         */
        override fun RecipeData.write(parcel: Parcel, flags: Int) {
            parcel.writeString(naam)
            parcel.writeString(image_url)
            parcel.writeString(remote_site_url)
            parcel.writeStringList(ingredienten)
        }

        /**
         * Functie voor het mappen van een Parcel naar een RecipeData
         * @param parcel Parcel die gemapt wordt
         * @return RecipeData
         */
        override fun create(parcel: Parcel): RecipeData {
            return RecipeData(parcel)
        }
    }
}
