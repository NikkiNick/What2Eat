package android.com.what2eat.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.viewmodels.ActionbarViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * About fragment
 */
class AboutFragment : Fragment() {

    //private lateinit var actionbarViewModel: ActionbarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //actionbarViewModel = ViewModelProviders.of(activity!!).get(ActionbarViewModel::class.java)
        //actionbarViewModel.setTitle(context!!.resources.getString(R.string.about))
        val act = activity as MainActivity
        act.setCustomActionBar("about")

        return inflater.inflate(R.layout.fragment_about, container, false)
    }


}
