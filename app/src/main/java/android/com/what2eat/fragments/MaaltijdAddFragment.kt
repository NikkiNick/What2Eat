package android.com.what2eat.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.databinding.FragmentMaaltijdAddBinding
import android.com.what2eat.viewmodels.MaaltijdViewModel
import android.com.what2eat.viewmodels.MaaltijdViewModelFactory
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.Gravity
import android.view.inputmethod.InputMethodManager


/**
 * A simple [Fragment] subclass.
 */
class MaaltijdAddFragment : Fragment() {

    private lateinit var binding: FragmentMaaltijdAddBinding
    private lateinit var viewModel: MaaltijdViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_add, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = MaaltijdDatabase.getInstance(application).maaltijdDao
        val viewModelFactory = MaaltijdViewModelFactory(dataSource, application)
        this.viewModel = ViewModelProviders.of(this, viewModelFactory).get(MaaltijdViewModel::class.java)

        this.binding.maaltijd = this.viewModel

        this.binding.setLifecycleOwner(this)

        this.binding.maaltijdNaam.setOnFocusChangeListener { v, hasFocus ->
            val imm = activity!!.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0)
        }

        this.binding.addMaaltijdButton.setOnClickListener {
            this.viewModel.setNaam(binding.maaltijdNaam.text.toString())
            this.viewModel.saveMaaltijd()
            val toast = Toast.makeText(
                            application.applicationContext,
                            "${this.binding.maaltijdNaam.text.toString()} ${resources.getString(R.string.added)}",
                            Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
            findNavController().navigate(R.id.action_addMaaltijd_StartFragment_to_maaltijdOverzichtFragment)
        }
        viewModel.changeRatingDisplay.observe(this, Observer{
            changeRatingDisplay(it)
        })
        viewModel.ratingString.observe(this, Observer{
            binding.maaltijdRatingString.text = it
        })
        val act = activity as MainActivity
        act.setCustomActionBar("add_new_meal")

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
