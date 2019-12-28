package android.com.what2eat.adapters

import android.com.what2eat.databinding.MaaltijdonderdeelCheckboxItemViewBinding
import android.com.what2eat.model.MaaltijdOnderdeel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
/**
 * RecyclerView Adapter die gebruikt wordt voor het aanmaken en databinding van ViewHolders voor
 * het weergeven van een lijst van [MaaltijdOnderdeel] met een CheckBox (inclusief clickListener
 * ([MaaltijdOnderdeelListener]]). Inclusief een diffCallBack ([MaaltijdOnderdeelDiffCallback] voor
 * betere RecyclerView-performantie)
 * @constructor Constructor voor het aanmaken van een [MaaltijdOnderdeelAdapter] (ListAdapter)
 * @param clickListener ClickListener die gebruikt wordt voor het afhandelen van user-events (onClick) op een [MaaltijdOnderdeel] in de lijst
 * @see [MaaltijdOnderdeelAdapter.ViewHolder]
 * @see [MaaltijdOnderdeelDiffCallback]
 */
class MaaltijdOnderdeelCheckBoxAdapter(val clickListener: MaaltijdOnderdeelListener) : ListAdapter<MaaltijdOnderdeel, MaaltijdOnderdeelCheckBoxAdapter.ViewHolder>(MaaltijdOnderdeelDiffCallback()){
    /**
     * Deze functie wordt gebruikt om een [MaaltijdOnderdeel] en [MaaltijdOnderdeelListener] te
     * binden aan de customViewHolder ([MaaltijdOnderdeelAdapter.ViewHolder])
     * @param holder Custom ViewHolder voor het bijhouden van een [MaaltijdOnderdeel] met [MaaltijdOnderdeelListener]
     * @param position Huidige positie in de lijst waar de ViewHolder moet geplaatst worden
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
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
    class ViewHolder private constructor(val binding: MaaltijdonderdeelCheckboxItemViewBinding): RecyclerView.ViewHolder(binding.root){
        companion object {
            /**
             * Deze functie wordt gebruikt om de layout te binden aan de ViewHolder
             * @param parent Parent waartoe de ViewHolder behoord
             * @return ViewHolder
             */
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MaaltijdonderdeelCheckboxItemViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
        /**
         * Deze functie wordt gebruikt om een [MaaltijdOnderdeel] en [MaaltijdOnderdeelListener] te binden aan de ViewHolder
         * @param item [MaaltijdOnderdeel] die aan de ViewHolder gebind wordt
         * @param clickListener [MaaltijdOnderdeelListener] die aan de ViewHolder gebindt wordt
         */
        fun bind(item: MaaltijdOnderdeel, clickListener: MaaltijdOnderdeelListener) {
            binding.maaltijdOnderdeel = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

}

/**
 * Deze class verbeterd de performantie in een RecyclerView om verschillen tussen 2 maaltijdOnderdelen
 * beter te kunnen uitmaken.
 * @constructor Constructor voor het aanmaken van de DiffUtil.ItemCallback voor maaltijdOnderdelen
 */
class MaaltijdOnderdeelDiffCallback: DiffUtil.ItemCallback<MaaltijdOnderdeel>(){
    /**
     * Deze functie bekijkt of 2 maaltijdOnderdelen dezelfde te zijn door beide id's te vergelijken
     * @param oldItem [MaaltijdOnderdeel] 1
     * @param newItem [MaaltijdOnderdeel] 2
     * @return Boolean
     */
    override fun areItemsTheSame(oldItem: MaaltijdOnderdeel, newItem: MaaltijdOnderdeel): Boolean {
        return oldItem.maaltijdOnderdeelId == newItem.maaltijdOnderdeelId
    }

    /**
     * Deze functie bekijkt of de inhoud van 2 maaltijdOnderdelen dezelfde te zijn
     * @param oldItem [MaaltijdOnderdeel] 1
     * @param newItem [MaaltijdOnderdeel] 2
     * @return Boolean
     */
    override fun areContentsTheSame(oldItem: MaaltijdOnderdeel, newItem: MaaltijdOnderdeel): Boolean {
        return oldItem.equals(newItem)
    }
}
/**
 * Listener die gebruikt wordt om user-events op items in de RecyclerView af te handelen.
 * Wanneer de gebruiker op een [MaaltijdOnderdeel] clickt in de RecyclerView wordt de id van het
 * [MaaltijdOnderdeel] teruggegeven.
 * @constructor Constructor voor het aanmaken van de Listener
 * @param clickListener
 */
class MaaltijdOnderdeelListener(val clickListener: (maaltijdOnderdeelId: Long) -> Unit) {
    /**
     * Deze functie wordt gebruikt om de id van het [MaaltijdOnderdeel]] terug te geven wanneer een
     * gebruiker een [MaaltijdOnderdeel] gekozen heeft.
     * @param maaltijdOnderdeel [MaaltijdOnderdeel] die geselecteerd werd door de gebruiker
     */
    fun onClick(maaltijdOnderdeel: MaaltijdOnderdeel) = clickListener(maaltijdOnderdeel.maaltijdOnderdeelId)
}