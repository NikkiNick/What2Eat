package android.com.what2eat.adapters.BindingAdapters

import android.com.what2eat.model.MaaltijdOnderdeel
import android.widget.CheckBox
import android.widget.TextView
import androidx.databinding.BindingAdapter
/**
 * BindingAdapter voor weergave van naam met een Checkbox van een [MaaltijdOnderdeel]
 * @param maaltijdOnderdeel [MaaltijdOnderdeel] waarvan de naam weergegeven wordt
 */
@BindingAdapter("maaltijdOnderdeel_naam")
fun CheckBox.setNaam(maaltijdOnderdeel: MaaltijdOnderdeel?){
    maaltijdOnderdeel?.let {
        text = it.naam
    }
}
/**
 * BindingAdapter voor weergave van naam (TextView) van een [MaaltijdOnderdeel]
 * @param maaltijdOnderdeel [MaaltijdOnderdeel] waarvan de naam weergegeven wordt
 */
@BindingAdapter("maaltijdOnderdeel_naamText")
fun TextView.setNaamText(maaltijdOnderdeel: MaaltijdOnderdeel?){
    maaltijdOnderdeel?.let {
        text = it.naam
    }
}