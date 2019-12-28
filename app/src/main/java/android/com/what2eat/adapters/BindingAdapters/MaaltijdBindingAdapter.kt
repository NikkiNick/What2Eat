package android.com.what2eat.adapters.BindingAdapters

import android.com.what2eat.R
import android.com.what2eat.model.Maaltijd
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
/**
 * BindingAdapter voor weergave van naam (TextView) van een [Maaltijd]
 * @param maaltijd [Maaltijd] waarvan de naam weergegeven wordt
 */
@BindingAdapter("maaltijd_naam")
fun TextView.maaltijd_setNaam(maaltijd: Maaltijd?){
    maaltijd?.let {
        text = it.naam
    }
}
/**
 * BindingAdapter voor weergavve van afbeelding (ImageView) van een [Maaltijd]
 * @param maaltijd [Maaltijd] waarvan de afbeelding weergegeven wordt
 */
@BindingAdapter("maaltijd_photo")
fun ImageView.maaltijd_setPhoto(maaltijd: Maaltijd?){
    maaltijd?.let{
        if(it.photo_uri != null && it.photo_uri != ""){
            this.scaleType = ImageView.ScaleType.CENTER_CROP
            Glide.with(context).load(maaltijd.photo_uri).into(this)
        }else{
            this.scaleType = ImageView.ScaleType.FIT_CENTER
            Glide.with(context).load(R.drawable.maaltijd_blank_image_wide).into(this)
        }
    }
}
/**
 * BindingAdapter voor weergeven van afbeelding (cropped circle) (ImageView) van een [Maaltijd]
 * @param maaltijd [Maaltijd] waarvan de afbeelding weergegeven wordt
 */
@BindingAdapter("maaltijd_photo_circle")
fun ImageView.maaltijd_setPhotoCircle(maaltijd: Maaltijd?){
    maaltijd?.let{
        it.photo_uri?.let {
            val options = RequestOptions()
            options.circleCrop()
            Glide.with(context).load(maaltijd.photo_uri).apply(options).into(this)
        }
    }
}
/**
 * BindingAdapter voor weergeven van de rating (LinearLayout) van een [Maaltijd]
 * @param maaltijd [Maaltijd] waarvan de rating weergegeven (stars) wordt
 */
@BindingAdapter("maaltijd_rating")
fun LinearLayout.maaltijd_setRating(maaltijd: Maaltijd?){
    maaltijd?.let{
        var counter = 0
        while(counter < it.rating) {
            val ratingImage = getChildAt(counter) as ImageView
            ratingImage.setImageResource(android.R.drawable.star_big_on)
            counter++
        }
    }
}
/**
 * BindingAdapter voor weergeven van de rating (TextView) van een [Maaltijd]
 * @param maaltijd [Maaltijd] waarvan de rating (String) weergegeven wordt
 */
@BindingAdapter("maaltijd_ratingString")
fun TextView.maaltijd_setRatingString(maaltijd: Maaltijd?){
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
/**
 * BindingAdapter voor weergeven van de datum (TextView) wanneer [Maaltijd] laatst gegeten is
 * @param maaltijd [Maaltijd] waarvan de datum weergegeven wordt
 */
@BindingAdapter("maaltijd_date_lastEaten")
fun TextView.maaltijd_setDateLastEaten(maaltijd: Maaltijd?){
    maaltijd?.let {
        maaltijd.dateLast?.let {
            val pattern = "dd-MM-yyyy"
            val simpleDateFormat = SimpleDateFormat(pattern)
            val date = simpleDateFormat.format(it)
            text = "${resources.getString(R.string.last_eaten)} ${date}"
        }
    }
}
/**
 * BindingAdapter voor weergeven van de datum (TextView) wanneer [Maaltijd] toegevoegd is
 * @param maaltijd [Maaltijd] waarvan de datum weergegeven wordt
 */
@BindingAdapter("maaltijd_date_added")
fun TextView.maaltijd_setDateAdded(maaltijd: Maaltijd?){
    maaltijd?.let {
        it.dateAdded.let {
            val pattern = "dd-MM-yyyy"
            val simpleDateFormat = SimpleDateFormat(pattern)
            val date = simpleDateFormat.format(it)
            text = "${resources.getString(R.string.date_added)}: ${date}"
        }
    }
}