package android.com.what2eat.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity

/**
 * Fragment voor het weergeven van about informatie
 */
class AboutFragment : Fragment() {

    /**
     * Initialiseerd het fragment in CREATED lifecycle state. De layout wordt geinflate en custom
     * actionbar wordt ingesteld
     * @param inflater LayoutInflater
     * @param container ViewGroup
     * @param savedInstanceState Bundle
     * @return View
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val act = activity as MainActivity
        act.setCustomActionBar("about")

        return inflater.inflate(R.layout.fragment_about, container, false)
    }


}
