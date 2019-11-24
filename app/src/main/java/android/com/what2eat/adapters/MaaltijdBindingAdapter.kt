package android.com.what2eat.adapters

import android.com.what2eat.R
import android.com.what2eat.model.Maaltijd
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat

@BindingAdapter("maaltijd_naam")
fun TextView.setNaam(maaltijd: Maaltijd){
    maaltijd?.let {
        text = maaltijd.naam
    }
}
@BindingAdapter("maaltijd_rating")
fun LinearLayout.setRating(maaltijd: Maaltijd){
    maaltijd?.let{
        var counter = 0
        while(counter < maaltijd.rating) {
            val ratingImage = getChildAt(counter) as ImageView
            ratingImage.setImageResource(android.R.drawable.star_big_on)
            counter++
        }
    }
}
@BindingAdapter("maaltijd_date_lastEaten")
fun TextView.setDateAdded(maaltijd: Maaltijd){
    maaltijd?.let {
        maaltijd.dateLast?.let {
            val pattern = "dd-MM-yyyy"
            val simpleDateFormat = SimpleDateFormat(pattern)
            val date = simpleDateFormat.format(maaltijd.dateLast)
            text = "${resources.getString(R.string.last_eaten)} ${date}"
        }
    }
}
