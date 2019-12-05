package android.com.what2eat.adapters

import android.com.what2eat.model.MaaltijdOnderdeel
import android.widget.CheckBox
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("maaltijdOnderdeel_naam")
fun CheckBox.setNaam(maaltijdOnderdeel: MaaltijdOnderdeel?){
    maaltijdOnderdeel?.let {
        text = it.naam
    }
}
@BindingAdapter("maaltijdOnderdeel_naamText")
fun TextView.setNaamText(maaltijdOnderdeel: MaaltijdOnderdeel?){
    maaltijdOnderdeel?.let {
        text = it.naam
    }
}