package android.com.what2eat.adapters

import android.com.what2eat.databinding.MaaltijdonderdeelItemViewBinding
import android.com.what2eat.model.MaaltijdOnderdeel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * RecyclerView Adapter die gebruikt wordt voor het aanmaken en databinding van ViewHolders voor
 * het weergeven van een lijst van [MaaltijdOnderdeel] . Inclusief een diffCallBack
 * ([MaaltijdOnderdeelDiffCallback] voor betere RecyclerView-performantie)
 * @constructor Constructor voor het aanmaken van een [MaaltijdOnderdeelAdapter] (ListAdapter)
 * @see [MaaltijdOnderdeelAdapter.ViewHolder]
 * @see [MaaltijdOnderdeelDiffCallback]
 */
class MaaltijdOnderdeelAdapter() : ListAdapter<MaaltijdOnderdeel, MaaltijdOnderdeelAdapter.ViewHolder>(MaaltijdOnderdeelDiffCallback()){
    /**
     * Deze functie wordt gebruikt om een [MaaltijdOnderdeel] te binden aan de custom
     *  ViewHolder ([MaaltijdOnderdeelAdapter.ViewHolder])
     * @param holder Custom ViewHolder voor het bijhouden van een [MaaltijdOnderdeel]
     * @param position Huidige positie in de lijst waar de ViewHolder moet geplaatst worden
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }
    /**
     * Deze functie wordt gebruikt om de ViewHolder aan te maken.
     * @param parent Parent waartoe de ViewHolder behoord
     * @param viewType
     * @return Custom ViewHolder
     * @see [MaaltijdOnderdeelAdapter.ViewHolder]
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }
    /**
     * Custom ViewHolder class die gebruikt wordt in de RecyclerView.
     * @constructor Constructor voor het aanmaken van de custom ViewHolder
     * @param binding LayoutBinding die gebruikt wordt door de ViewHolder
     */
    class ViewHolder private constructor(val binding: MaaltijdonderdeelItemViewBinding): RecyclerView.ViewHolder(binding.root){
        companion object {
            /**
             * Deze functie wordt gebruikt om de layout te binden aan de ViewHolder
             * @param parent Parent waartoe de ViewHolder behoord
             * @return ViewHolder
             */
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MaaltijdonderdeelItemViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
        /**
         * Deze functie wordt gebruikt om een [MaaltijdOnderdeel] te binden aan de ViewHolder
         * @param item [MaaltijdOnderdeel] die aan de ViewHolder gebind wordt
         */
        fun bind(item: MaaltijdOnderdeel) {
            binding.maaltijdOnderdeel = item
            binding.executePendingBindings()
        }
    }
}
