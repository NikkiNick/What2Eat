package android.com.what2eat.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActionbarViewModel: ViewModel() {

    var _title = MutableLiveData<String?>()

    val title: LiveData<String?>
        get() = _title

    init{

    }

    fun setTitle(title: String){
        this._title.value = title
    }
    fun getTitle(): String?{
        return this._title.value
    }

}