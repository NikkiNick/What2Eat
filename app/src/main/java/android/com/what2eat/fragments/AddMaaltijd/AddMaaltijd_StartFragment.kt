package android.com.what2eat.fragments.AddMaaltijd


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.com.what2eat.R
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.databinding.FragmentAddMaaltijdStartBinding
import android.com.what2eat.viewmodels.MaaltijdViewModel
import android.com.what2eat.viewmodels.MaaltijdViewModelFactory
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 */
class AddMaaltijd_StartFragment : Fragment() {

    private lateinit var binding: FragmentAddMaaltijdStartBinding
    private lateinit var viewModel: MaaltijdViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_maaltijd__start, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = MaaltijdDatabase.getInstance(application).maaltijdDatabaseDao
        val viewModelFactory = MaaltijdViewModelFactory(dataSource, application)
        this.viewModel = ViewModelProviders.of(this.activity!!, viewModelFactory).get(MaaltijdViewModel::class.java)

        this.binding.maaltijd = this.viewModel

        this.binding.setLifecycleOwner(this)

        this.binding.cancelButton.setOnClickListener {
            //findNavController().navigate(R.id.action_addMaaltijd_Start_to_maaltijdOverzichtFragment)
            activity!!.finish()
        }
        this.binding.saveButton.setOnClickListener {
            this.viewModel.setNaam(binding.maaltijdNaam.text.toString())
            this.viewModel.saveMaaltijd()
            Toast.makeText(
                application.applicationContext,
                "${this.binding.maaltijdNaam.text.toString()} ${resources.getString(R.string.added)}",
                Toast.LENGTH_LONG
            ).show()
            activity!!.finish()
        }
        viewModel.changeRatingDisplay.observe(this, Observer{
            changeRatingDisplay(it)
        })

        return this.binding.root
    }
    private fun changeRatingDisplay(aantal: Int){
        val starViews = listOf(binding.rate1Button, binding.rate2Button, binding.rate3Button, binding.rate4Button, binding.rate5Button)
        starViews.forEach { star -> star.setImageResource(android.R.drawable.star_big_off) }
        when(aantal){
            1-> binding.rate1Button.setImageResource(android.R.drawable.star_big_on)
            2 -> {
                binding.rate1Button.setImageResource(android.R.drawable.star_big_on)
                binding.rate2Button.setImageResource(android.R.drawable.star_big_on)
            }
            3-> {
                binding.rate1Button.setImageResource(android.R.drawable.star_big_on)
                binding.rate2Button.setImageResource(android.R.drawable.star_big_on)
                binding.rate3Button.setImageResource(android.R.drawable.star_big_on)
            }
            4 -> {
                binding.rate1Button.setImageResource(android.R.drawable.star_big_on)
                binding.rate2Button.setImageResource(android.R.drawable.star_big_on)
                binding.rate3Button.setImageResource(android.R.drawable.star_big_on)
                binding.rate4Button.setImageResource(android.R.drawable.star_big_on)
            }
            5 -> {
                binding.rate1Button.setImageResource(android.R.drawable.star_big_on)
                binding.rate2Button.setImageResource(android.R.drawable.star_big_on)
                binding.rate3Button.setImageResource(android.R.drawable.star_big_on)
                binding.rate4Button.setImageResource(android.R.drawable.star_big_on)
                binding.rate5Button.setImageResource(android.R.drawable.star_big_on)
            }
        }
    }



}
