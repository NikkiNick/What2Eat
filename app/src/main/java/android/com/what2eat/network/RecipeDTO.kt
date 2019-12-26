package android.com.what2eat.network

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
data class Response(
    @Json(name="hits")
    val recipes: List<Recipe>
)

@JsonClass(generateAdapter = true)
data class Recipe(
    @Json(name="recipe")
    val recipe: RecipeData
)
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

        override fun RecipeData.write(dest: Parcel, flags: Int) {
            dest?.writeString(naam)
            dest?.writeString(image_url)
            dest?.writeString(remote_site_url)
            dest?.writeStringList(ingredienten)
        }

        override fun create(source: Parcel): RecipeData {
            return RecipeData(source)
        }
    }
}
