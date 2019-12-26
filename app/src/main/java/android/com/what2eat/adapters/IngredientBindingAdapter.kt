package android.com.what2eat.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("ingredient_naam")
fun TextView.setNaam(ingredient: String?){
    ingredient?.let {
        text = it
    }
}