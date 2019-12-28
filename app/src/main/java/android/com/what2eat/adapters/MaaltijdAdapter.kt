package android.com.what2eat.adapters

import android.com.what2eat.databinding.MaaltijdItemViewBinding
import android.com.what2eat.model.Maaltijd
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * RecyclerView Adapter die gebruikt wordt voor het aanmaken en databinding van ViewHolders voor
 * het weergeven van een lijst van [Maaltijd] (inclusief clickListener ([MaaltijdListener]]). Inclusief
 * een diffCallBack ([MaaltijdDiffCallback] voor betere RecyclerView-performantie)
 * @constructor Constructor voor het aanmaken van een [MaaltijdAdapter] (ListAdapter)
 * @param clickListener ClickListener die gebruikt wordt voor het afhandelen van user-events (onClick) op een [Maaltijd] in de lijst
 * @see [MaaltijdAdapter.ViewHolder]
 * @see [MaaltijdDiffCallback]
 */
class MaaltijdAdapter(val clickListener: MaaltijdListener) : ListAdapter<Maaltijd, MaaltijdAdapter.ViewHolder>(MaaltijdDiffCallback()){
    /**
     * Deze functie wordt gebruikt om een [Maaltijd] en [MaaltijdListener] te binden aan de custom
     *  ViewHolder ([MaaltijdAdapter.ViewHolder])
     * @param holder Custom ViewHolder voor het bijhouden van een [Maaltijd] met [MaaltijdListener]
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
     * @see [MaaltijdAdapter.ViewHolder]
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    /**
     * Custom ViewHolder class die gebruikt wordt in de RecyclerView.
     * @constructor Constructor voor het aanmaken van de custom ViewHolder
     * @param binding LayoutBinding die gebruikt wordt door de ViewHolder
     */
    class ViewHolder private constructor(val binding: MaaltijdItemViewBinding): RecyclerView.ViewHolder(binding.root){

        companion object {
            /**
             * Deze functie wordt gebruikt om de layout te binden aan de ViewHolder
             * @param parent Parent waartoe de ViewHolder behoord
             * @return ViewHolder
             */
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MaaltijdItemViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        /**
         * Deze functie wordt gebruikt om een [Maaltijd] en [MaaltijdListener] te binden aan de ViewHolder
         * @param item [Maaltijd] die aan de ViewHolder gebind wordt
         * @param clickListener [MaaltijdListener] die aan de ViewHolder gebindt wordt
         */
        fun bind(item: Maaltijd, clickListener: MaaltijdListener) {
            binding.maaltijd = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

}

/**
 * Deze class verbeterd de performantie in een RecyclerView om verschillen tussen 2 [Maaltijd]
 * beter te kunnen uitmaken.
 * @constructor Constructor voor het aanmaken van de [MaaltijdDiffCallback] (DiffUtil.ItemCallback)
 */
class MaaltijdDiffCallback: DiffUtil.ItemCallback<Maaltijd>(){

    /**
     * Deze functie bekijkt of 2 objecten ([Maaltijd]) dezelfde te zijn door beide id's te vergelijken
     * @param oldItem [Maaltijd] 1
     * @param newItem [Maaltijd] 2
     * @return Boolean
     */
    override fun areItemsTheSame(oldItem: Maaltijd, newItem: Maaltijd): Boolean {
        return oldItem.maaltijdId == newItem.maaltijdId
    }

    /**
     * Deze functie bekijkt of de inhoud van 2 objecten ([Maaltijd]) dezelfde te zijn
     * @param oldItem [Maaltijd] 1
     * @param newItem [Maaltijd] 2
     * @return Boolean
     */
    override fun areContentsTheSame(oldItem: Maaltijd, newItem: Maaltijd): Boolean {
        return oldItem.equals(newItem)
    }
}

/**
 * Listener die gebruikt wordt om user-events op items in de RecyclerView af te handelen.
 * Wanneer de gebruiker op een [Maaltijd] clickt in de RecyclerView wordt de id van de [Maaltijd] teruggegeven.
 * @constructor Constructor voor het aanmaken van een [MaaltijdListener]
 * @param clickListener
 */
class MaaltijdListener(val clickListener: (maaltijdId: Long) -> Unit) {
    /**
     * Deze functie wordt gebruikt om de id van de [Maaltijd] terug te geven wanneer een gebruiker een
     * [Maaltijd] gekozen heeft.
     * @param maaltijd [Maaltijd] die geselecteerd werd door de gebruiker
     */
    fun onClick(maaltijd: Maaltijd) = clickListener(maaltijd.maaltijdId)
}