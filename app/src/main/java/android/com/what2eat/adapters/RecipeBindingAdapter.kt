package android.com.what2eat.adapters

import android.com.what2eat.network.Recipe
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


@BindingAdapter("recipe_naam")
fun TextView.setNaam(recipe: Recipe?){
    recipe?.let {
        text = it.recipe.naam
    }
}

@BindingAdapter("recipe_photo_circle")
fun ImageView.setPhotoCircle(recipe: Recipe?){
    recipe?.let{
        it.recipe.image_url?.let {
            var options: RequestOptions = RequestOptions()
            options.circleCrop()
            Glide.with(context).load(it).apply(options).into(this)
            contentDescription = recipe.recipe.naam+" image"
        }
    }
}