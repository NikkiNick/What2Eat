package android.com.what2eat.viewmodels

import android.com.what2eat.model.Maaltijd
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MaaltijdOverzichtViewModel : ViewModel(){


    private var _maaltijden = MutableLiveData<List<Maaltijd>>()
    val maaltijden: LiveData<List<Maaltijd>>
        get() = _maaltijden

    init{
        
    }

}