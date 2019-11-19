package android.com.what2eat.viewmodels

import android.com.what2eat.model.Maaltijd
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MaaltijdViewModel(): ViewModel() {

    private var _maaltijd = MutableLiveData<Maaltijd>()
    val maaltijd: LiveData<Maaltijd>
        get() = _maaltijd

    init{
        this._maaltijd.value = Maaltijd()
    }
    fun setNaam(naam: String){
        this._maaltijd.value?.naam = naam
    }
    fun getNaam(): String?{
        return this._maaltijd.value?.naam
    }

}