package android.com.what2eat.adapters

import android.com.what2eat.model.MaaltijdOnderdeel
import android.widget.CheckBox
import androidx.databinding.BindingAdapter

@BindingAdapter("maaltijdOnderdeel_naam")
fun CheckBox.setNaam(maaltijdOnderdeel: MaaltijdOnderdeel?){
    maaltijdOnderdeel?.let {
        text = it.naam
    }
}