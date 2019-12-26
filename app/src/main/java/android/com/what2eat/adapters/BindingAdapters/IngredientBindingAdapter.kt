package android.com.what2eat.adapters.BindingAdapters

import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * BindingAdapter voor instellen van naam (TextView) van een ingredient
 * @param ingredient Naam van het ingredient
 */
@BindingAdapter("ingredient_naam")
fun TextView.setNaam(ingredient: String?){
    ingredient?.let {
        text = it
    }
}