package android.com.what2eat.adapters

import android.com.what2eat.model.Maaltijd
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputEditText

@BindingAdapter("maaltijd_edit_naam")
fun TextInputEditText.setNaam(maaltijd: Maaltijd?){
    maaltijd?.let {
        setText(it.naam)
    }
}