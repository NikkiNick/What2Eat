package android.com.what2eat.fragments


import android.app.Application
import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.adapters.MaaltijdOnderdeelAdapter
import android.com.what2eat.adapters.MaaltijdOnderdeelCheckBoxAdapter
import android.com.what2eat.adapters.MaaltijdOnderdeelClickableAdapter
import android.com.what2eat.adapters.MaaltijdOnderdeelListener
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.databinding.FragmentMaaltijdOnderdeelOverzichtBinding
import android.com.what2eat.databinding.FragmentMaaltijdOnderdeelSelectBinding
import android.com.what2eat.viewmodels.MaaltijdOnderdeelOverzichtViewModel
import android.com.what2eat.viewmodels.MaaltijdOnderdeelOverzichtViewModelFactory
import android.com.what2eat.viewmodels.MaaltijdOnderdeelSelectViewModel
import android.com.what2eat.viewmodels.MaaltijdOnderdeelSelectViewModelFactory
import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.SearchView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration

/**
 * A simple [Fragment] subclass.
 */
class MaaltijdOnderdeelOverzichtFragment : Fragment() {

    private lateinit var binding: FragmentMaaltijdOnderdeelOverzichtBinding
    private lateinit var viewModelFactory: MaaltijdOnderdeelOverzichtViewModelFactory
    private lateinit var viewModel: MaaltijdOnderdeelOverzichtViewModel
    private lateinit var dataSource: MaaltijdOnderdeelDao
    private lateinit var application: Application

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        application = requireNotNull(this.activity).application
        dataSource = MaaltijdDatabase.getInstance(application).maaltijdOnderdeelDao

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_maaltijd_onderdeel_overzicht,
            container,
            false
        )

        viewModelFactory = MaaltijdOnderdeelOverzichtViewModelFactory(dataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MaaltijdOnderdeelOverzichtViewModel::class.java)

        val adapter = MaaltijdOnderdeelClickableAdapter(MaaltijdOnderdeelListener {
            findNavController().navigate(MaaltijdOnderdeelOverzichtFragmentDirections.actionMaaltijdOnderdeelOverzichtFragmentToMaaltijdOnderdeelDetailFragment(it))
        })

        binding.recyclerMaaltijdOnderdelen.adapter = adapter
        val itemDecor = DividerItemDecoration(context, ClipDrawable.HORIZONTAL)
        binding.recyclerMaaltijdOnderdelen.addItemDecoration(itemDecor)

        viewModel.initMaaltijdOnderdelen()

        viewModel.maaltijdOnderdelen.observe(this, Observer{ lijst ->
            lijst?.let{
                adapter.submitList(lijst)
            }
        })
        val searchView: SearchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean { // do something on text submit
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean { // do something when text changes
                viewModel.filterMaaltijdOnderdelen(newText)
                return false
            }
        })
        binding.addMaaltijdOnderdeelButton.setOnClickListener {

            val builder = AlertDialog.Builder(this.context!!)
            builder.setTitle(R.string.mealpart_name)

            val input = EditText(this.context!!)
            input.inputType = InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
            input.setSingleLine(true)
            input.setTextColor(
                ContextCompat.getColor(
                    context!!,
                    R.color.colorPrimaryDark
                )
            )
            builder.setView(input)

            builder.setPositiveButton(R.string.save) { _, _ ->
                viewModel.addMaaltijdOnderdeel(input.text.toString())
            }
            builder.setNegativeButton(R.string.cancel) { dialog, _ ->
                dialog.cancel()
            }

            builder.show()
            input.requestFocus()
        }

        this.setHasOptionsMenu(true)
        binding.setLifecycleOwner(this)

        val activity = getActivity() as MainActivity
        activity.setCustomActionBar("maaltijdonderdelenoverzicht")

        return binding.root

    }


}
