package android.com.what2eat.fragments.AddMaaltijd


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R

/**
 * A simple [Fragment] subclass.
 */
class AddMaaltijd_Start : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_maaltijd__start, container, false)
    }


}
