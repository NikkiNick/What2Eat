package android.com.what2eat.fragments


import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment

import android.com.what2eat.R
import android.com.what2eat.database.MaaltijdDao
import android.com.what2eat.database.MaaltijdDatabase
import android.com.what2eat.database.MaaltijdOnderdeelDao
import android.com.what2eat.databinding.FragmentMaaltijdOnderdeelDetailBinding
import android.com.what2eat.viewmodels.MaaltijdOnderdeelDetailViewModel
import android.com.what2eat.viewmodels.MaaltijdOnderdeelDetailViewModelFactory
import android.text.InputType
import android.view.*
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * A simple [Fragment] subclass.
 */
class MaaltijdOnderdeelDetailFragment : Fragment() {

    private lateinit var binding: FragmentMaaltijdOnderdeelDetailBinding
    private lateinit var viewModelFactory: MaaltijdOnderdeelDetailViewModelFactory
    private lateinit var viewModel: MaaltijdOnderdeelDetailViewModel
    private lateinit var application: Application
    private lateinit var maaltijdOnderdeelDataSource: MaaltijdOnderdeelDao
    private lateinit var maaltijdDataSource: MaaltijdDao

    override fun onCreate(savedInstanceState: Bundle?) {

        application = requireNotNull(this.activity).application
        maaltijdOnderdeelDataSource = MaaltijdDatabase.getInstance(application).maaltijdOnderdeelDao
        maaltijdDataSource = MaaltijdDatabase.getInstance(application).maaltijdDao
        val args = MaaltijdOnderdeelDetailFragmentArgs.fromBundle(arguments!!)
        viewModelFactory = MaaltijdOnderdeelDetailViewModelFactory(maaltijdOnderdeelDataSource, maaltijdDataSource, args.maaltijdonderdeelId, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MaaltijdOnderdeelDetailViewModel::class.java)
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_onderdeel_detail, container, false)

        binding.setLifecycleOwner(this)
        binding.maaltijdOnderdeel = viewModel

        viewModel.showToast.observe(this, Observer{
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_maaltijdOnderdeelDetailFragment_to_maaltijdOnderdeelOverzichtFragment)
        })

        binding.editMealpartButton.setOnClickListener{
            val oudeNaam = viewModel.maaltijdOnderdeel.value?.naam ?: ""

            val builder = AlertDialog.Builder(this.context!!)
            builder.setTitle(R.string.mealpart_name)

            val input = EditText(this.context!!)
            input.inputType = InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
            input.setSingleLine(true)
            input.setText(oudeNaam)
            input.setTextColor(
                ContextCompat.getColor(
                    context!!,
                    R.color.colorPrimaryDark
                )
            )
            builder.setView(input)

            builder.setPositiveButton(R.string.save) { _, _ ->
                binding.maaltijdOnderdeelNaamText.text = input.text.toString()
                viewModel.setNaam(input.text.toString())
            }
            builder.setNegativeButton(R.string.cancel) { dialog, _ ->
                dialog.cancel()
            }

            builder.show()
            input.requestFocus()
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.detail_menu_delete, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete_menuitem -> {
                MaterialAlertDialogBuilder(context)
                    .setTitle(R.string.confirmation_delete_title)
                    .setMessage(R.string.confirmation_delete_mealpart_content)
                    .setPositiveButton(resources.getString(R.string.ok)){ dialog, num ->
                        viewModel.deleteMaaltijdOnderdeel()
                    }
                    .setNegativeButton(resources.getString(R.string.cancel)){ dialog, num -> }
                    .show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
