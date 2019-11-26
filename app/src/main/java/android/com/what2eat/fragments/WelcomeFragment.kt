package android.com.what2eat.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.databinding.FragmentWelcomeBinding
import android.com.what2eat.viewmodels.ActionbarViewModel
import android.com.what2eat.viewmodels.MaaltijdViewModel
import android.com.what2eat.viewmodels.MaaltijdViewModelFactory
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    //private lateinit var actionbarViewModel: ActionbarViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        val act = activity as MainActivity
        act.setCustomActionBar("welcome")

        //actionbarViewModel = ViewModelProviders.of(activity!!).get(ActionbarViewModel::class.java)
        //actionbarViewModel.setTitle(context!!.resources.getString(R.string.welcome))

        return this.binding.root

    }

}
