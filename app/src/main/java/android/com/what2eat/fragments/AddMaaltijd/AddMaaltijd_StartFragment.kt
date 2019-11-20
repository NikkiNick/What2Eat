package android.com.what2eat.fragments.AddMaaltijd


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R
import android.com.what2eat.databinding.FragmentAddMaaltijdStartBinding
import android.com.what2eat.viewmodels.MaaltijdViewModel
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

/**
 * A simple [Fragment] subclass.
 */
class AddMaaltijd_StartFragment : Fragment() {

    private lateinit var binding: FragmentAddMaaltijdStartBinding
    private lateinit var viewModel: MaaltijdViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_maaltijd__start, container, false)

        this.viewModel = ViewModelProviders.of(activity!!).get(MaaltijdViewModel::class.java)

        this.binding.viewModel = this.viewModel

        this.binding.setLifecycleOwner(this)

        this.binding.cancelButton.setOnClickListener {
            activity!!.finish()
        }
        return this.binding.root
    }



}
