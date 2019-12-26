package android.com.what2eat.adapters

import android.com.what2eat.R
import android.com.what2eat.network.Recipe
import android.com.what2eat.network.RecipeData
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("recipe_naam")
fun TextView.setNaam(recipe: RecipeData?){
    recipe?.let {
        text = it.naam
    }
}
@BindingAdapter("recipe_photo")
fun ImageView.setPhoto(recipe: RecipeData?){
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
@BindingAdapter("recipe_photo_circle")
fun ImageView.setPhotoCircle(recipe: RecipeData?){
    recipe?.let{
        it.image_url?.let {
            var options: RequestOptions = RequestOptions()
            options.circleCrop()
            Glide.with(context).load(it).apply(options).into(this)
            contentDescription = recipe.naam+" image"
        }
    }
}