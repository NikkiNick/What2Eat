package android.com.what2eat.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R
import android.com.what2eat.databinding.FragmentMaaltijdOnderdeelInspiratieBinding
import android.com.what2eat.viewmodels.RecipeApiViewModel
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

/**
 * A simple [Fragment] subclass.
 */
class MaaltijdOnderdeelInspiratieFragment : Fragment() {

    private lateinit var binding: FragmentMaaltijdOnderdeelInspiratieBinding
    private lateinit var viewModel: RecipeApiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_onderdeel_inspiratie, container, false)
        viewModel = ViewModelProviders.of(this).get(RecipeApiViewModel::class.java)

        viewModel.response.observe(this, Observer {
            binding.recipesText.text = "Aantal: "+it.size.toString()
            Log.i("TestN", it.toString())
        })

        return binding.root
    }


}
