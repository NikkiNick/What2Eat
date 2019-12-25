package android.com.what2eat.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
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
@JsonClass(generateAdapter = true)
data class RecipeData(
    @Json(name="label")
    val naam: String,

    @Json(name="image")
    val image_url: String,

    @Json(name="url")
    val remote_site_url: String

    //@Json(name="ingredients")
    //val ingredienten: Array<IngredientProperty>

)

data class IngredientProperty (
    val food: FoodProperty
)

data class FoodProperty(
    @Json(name="label")
    val naam: String
)
