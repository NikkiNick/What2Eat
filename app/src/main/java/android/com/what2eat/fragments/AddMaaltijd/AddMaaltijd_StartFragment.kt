package android.com.what2eat.fragments.AddMaaltijd


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R
import android.com.what2eat.databinding.FragmentAddMaaltijdStartBinding
import androidx.databinding.DataBindingUtil

/**
 * A simple [Fragment] subclass.
 */
class AddMaaltijd_StartFragment : Fragment() {

    private lateinit var binding: FragmentAddMaaltijdStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_maaltijd__start, container, false)

        this.binding.cancelButton.setOnClickListener {
            activity!!.finish()
        }

        return this.binding.root
    }



}
