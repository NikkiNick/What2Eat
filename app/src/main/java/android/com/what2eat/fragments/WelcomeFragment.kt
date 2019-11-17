package android.com.what2eat.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R
import android.com.what2eat.databinding.FragmentWelcomeBinding
import androidx.databinding.DataBindingUtil

/**
 * Welcome Fragment
 */
class WelcomeFragment : Fragment() {

    /**
     * ======= onCreateView() =======
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Layout Binding
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        return binding.root

    }


}
