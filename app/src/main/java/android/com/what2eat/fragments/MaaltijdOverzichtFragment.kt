package android.com.what2eat.fragments


import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.databinding.FragmentMaaltijdOverzichtBinding
import android.content.Context
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

class MaaltijdOverzichtFragment : Fragment() {

    private lateinit var binding: FragmentMaaltijdOverzichtBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_overzicht, container, false)

        this.binding.addMealButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_maaltijdOverzichtFragment_to_addMaaltijdActivity)
        }
        val activity = getActivity() as MainActivity
        activity.setCustomActionBar("maaltijdoverzicht")
        return this.binding.root

    }


}
