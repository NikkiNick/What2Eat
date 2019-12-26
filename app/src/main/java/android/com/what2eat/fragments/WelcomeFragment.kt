package android.com.what2eat.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.databinding.FragmentWelcomeBinding
import androidx.databinding.DataBindingUtil

/**
 * Fragment voor het weergeven van het welkom scherm
 * @property binding Binding object van het fragment
 */
class WelcomeFragment : Fragment() {

    /**
     * Fragment properties
     */
    private lateinit var binding: FragmentWelcomeBinding

    /**
     * Initialiseerd het fragment in CREATED lifecycle state. De layout wordt geinflate en custom
     * actionbar wordt ingesteld
     * @param inflater LayoutInflater
     * @param container ViewGroup
     * @param savedInstanceState Bundle
     * @return View
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        val act = activity as MainActivity
        act.setCustomActionBar("welcome")

        return this.binding.root

    }

}
