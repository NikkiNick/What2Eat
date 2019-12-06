package android.com.what2eat.adapters

import android.com.what2eat.R
import android.com.what2eat.model.Maaltijd
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat

@BindingAdapter("maaltijd_naam")
fun TextView.setNaam(maaltijd: Maaltijd?){
    maaltijd?.let {
        text = it.naam
    }
}
@BindingAdapter("maaltijd_photo")
fun ImageView.setPhoto(maaltijd: Maaltijd?){
    maaltijd?.let{
        it.photo_uri?.let {
            Glide.with(context).load(maaltijd.photo_uri).into(this)
        }
    }
}
@BindingAdapter("maaltijd_photo_stretched")
fun ImageView.setPhotoStretched(maaltijd: Maaltijd?){
    maaltijd?.let{
        it.photo_uri?.let {
            Glide.with(context).load(maaltijd.photo_uri).into(this)
        }
    }
}
@BindingAdapter("maaltijd_rating")
fun LinearLayout.setRating(maaltijd: Maaltijd?){
    maaltijd?.let{
        var counter = 0
        while(counter < it.rating) {
            val ratingImage = getChildAt(counter) as ImageView
            ratingImage.setImageResource(android.R.drawable.star_big_on)
            counter++
        }
    }
}
@BindingAdapter("maaltijd_ratingString")
fun TextView.setRatingString(maaltijd: Maaltijd?){
    maaltijd?.let{
        val ratingStrings = listOf(
            context.getString(R.string.rating0),
            context.getString(R.string.rating1),
            context.getString(R.string.rating2),
            context.getString(R.string.rating3),
            context.getString(R.string.rating4),
            context.getString(R.string.rating5))
        text = ratingStrings.get(it.rating)
    }
}
@BindingAdapter("maaltijd_date_lastEaten")
fun TextView.setDateLastEaten(maaltijd: Maaltijd?){
    maaltijd?.let {
        maaltijd.dateLast?.let {
            val pattern = "dd-MM-yyyy"
            val simpleDateFormat = SimpleDateFormat(pattern)
            val date = simpleDateFormat.format(it)
            text = "${resources.getString(R.string.last_eaten)} ${date}"
        }
    }
}
@BindingAdapter("maaltijd_date_added")
fun TextView.setDateAdded(maaltijd: Maaltijd?){
    maaltijd?.let {
        it.dateAdded?.let {
            val pattern = "dd-MM-yyyy"
            val simpleDateFormat = SimpleDateFormat(pattern)
            val date = simpleDateFormat.format(it)
            text = "${resources.getString(R.string.date_added)}: ${date}"
        }
    }
}