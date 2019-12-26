package android.com.what2eat.adapters.BindingAdapters

import android.com.what2eat.R
import android.com.what2eat.network.RecipeData
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * BindingAdapter voor weergave van naam van een [RecipeData]
 * @param recipe [RecipeData] waarvan de naam weergegeven wordt
 */
@BindingAdapter("recipe_naam")
fun TextView.recipe_setNaam(recipe: RecipeData?){
    recipe?.let {
        text = it.naam
    }
}
/**
 * BindingAdapter voor weergavve van afbeelding (ImageView) van een [RecipeData]
 * @param recipe [RecipeData] waarvan de afbeelding weergegeven wordt
 */
@BindingAdapter("recipe_photo")
fun ImageView.recipe_setPhoto(recipe: RecipeData?){
    recipe?.let{
        if(it.image_url != null && it.image_url != ""){
            this.scaleType = ImageView.ScaleType.CENTER_CROP
            Glide.with(context).load(it.image_url).into(this)
        }else{
            this.scaleType = ImageView.ScaleType.FIT_CENTER
            Glide.with(context).load(R.drawable.maaltijd_blank_image_wide).into(this)
        }
    }
}
/**
 * BindingAdapter voor weergeven van afbeelding (cropped circle) (ImageView) van een [RecipeData]
 * @param recipe [RecipeData] waarvan de afbeelding weergegeven wordt
 */
@BindingAdapter("recipe_photo_circle")
fun ImageView.recipe_setPhotoCircle(recipe: RecipeData?){
    recipe?.let{
        it.image_url?.let {
            val options = RequestOptions()
            options.circleCrop()
            Glide.with(context).load(it).apply(options).into(this)
            contentDescription = recipe.naam+" image"
        }
    }
}