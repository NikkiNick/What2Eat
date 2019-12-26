package android.com.what2eat.fragments


import android.com.what2eat.R
import android.com.what2eat.activities.MainActivity
import android.com.what2eat.adapters.MaaltijdOnderdeelAdapter
import android.com.what2eat.databinding.FragmentMaaltijdDetailBinding
import android.com.what2eat.viewmodels.MaaltijdDetailViewModel
import android.com.what2eat.viewmodels.MaaltijdDetailViewModelFactory
import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView


/**
 * [Fragment] voor maaltijd detail
 */
class MaaltijdDetailFragment : Fragment() {
    /**
     * Fragment Properties
     */

    private lateinit var binding: FragmentMaaltijdDetailBinding
    private lateinit var viewModelFactory: MaaltijdDetailViewModelFactory
    private lateinit var viewModel: MaaltijdDetailViewModel
    /**
     * Functie die wordt opgeroepen wanneer het [Fragment] aangemaakt wordt en in CREATED lifecycle state is.
     * Fragment properties worden hier geïnstantieerd.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        val args = MaaltijdDetailFragmentArgs.fromBundle(arguments!!)
        viewModelFactory = MaaltijdDetailViewModelFactory(args.maaltijdId)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MaaltijdDetailViewModel::class.java)
        super.onCreate(savedInstanceState)
    }
    /**
     * Functie die wordt opgeroepen wanneer het [Fragment] aangemaakt wordt en in CREATED lifecycle state is.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /**
         * DataBinding : layout inflation, viewModel binding.
         */
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maaltijd_detail, container, false)
        binding.setLifecycleOwner(this)
        binding.maaltijd = viewModel
        /**
         * RecyclerView setup voor het tonen van de [RecyclerView] van maaltijdonderdelen van de huidige maaltijd.
         */
        val adapter = MaaltijdOnderdeelAdapter()
        binding.maaltijdOnderdelenRecyclerView.adapter = adapter
        val itemDecor = DividerItemDecoration(context, ClipDrawable.HORIZONTAL)
        binding.maaltijdOnderdelenRecyclerView.addItemDecoration(itemDecor)
        /**
         * ViewModel Observer: Observeren van de maaltijdOnderdelen van de maaltijd en toevoegen aan de
         * [RecyclerView]. Als er geen maaltijdonderdelen zijn dan wordt de [RecyclerView] niet weergegeven.
         */
        viewModel.maaltijdOnderdelen.observe(viewLifecycleOwner, Observer {lijst ->
            lijst?.let {
                if(lijst.size == 0){
                    binding.maaltijdOnderdelenTitleText.visibility = GONE
                    binding.maaltijdOnderdelenRecyclerView.visibility = GONE
                }else {
                    binding.maaltijdOnderdelenTitleText.visibility = VISIBLE
                    binding.maaltijdOnderdelenRecyclerView.visibility = VISIBLE
                    adapter.submitList(it)
                }
            }
        })
        /**
         * UI OnClickListeners:
         *      Listener voor de Edit button om te navigeren naar het Edit fragment.
         *      Listener voor de afbeelding van de maaltijd weer te geven in een apart fragment. (Enkel wanneer er een afbeelding is)
         */
        binding.editMealButton.setOnClickListener{
            it.findNavController().navigate(MaaltijdDetailFragmentDirections.actionMaaltijdDetailFragmentToMaaltijdEditFragment(viewModel.maaltijdId, null))
        }
        binding.maaltijdImage.setOnClickListener {
            viewModel.maaltijd.value?.photo_uri?.let{
               findNavController().navigate(MaaltijdDetailFragmentDirections.actionMaaltijdDetailFragmentToMaaltijdImageShowFragment(it))
            }
        }
        /**
         * ToolBar title
         */
        val act = activity as MainActivity
        act.setCustomActionBar("maaltijddetail")
        /**
         * Other
         */
        return binding.root
    }

}