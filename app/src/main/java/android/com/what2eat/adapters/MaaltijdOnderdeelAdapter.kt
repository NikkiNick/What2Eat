package android.com.what2eat.adapters

import android.com.what2eat.databinding.MaaltijdItemViewBinding
import android.com.what2eat.databinding.MaaltijdonderdeelItemViewBinding
import android.com.what2eat.model.Maaltijd
import android.com.what2eat.model.MaaltijdOnderdeel
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MaaltijdOnderdeelAdapter(val clickListener: MaaltijdOnderdeelListener) : ListAdapter<MaaltijdOnderdeel, MaaltijdOnderdeelAdapter.ViewHolder>(MaaltijdOnderdeelDiffCallback()){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: MaaltijdonderdeelItemViewBinding): RecyclerView.ViewHolder(binding.root){
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MaaltijdonderdeelItemViewBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }

        fun bind(item: MaaltijdOnderdeel, clickListener: MaaltijdOnderdeelListener) {
            binding.maaltijdOnderdeel = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

}
class MaaltijdOnderdeelDiffCallback: DiffUtil.ItemCallback<MaaltijdOnderdeel>(){
    override fun areItemsTheSame(oldItem: MaaltijdOnderdeel, newItem: MaaltijdOnderdeel): Boolean {
        return oldItem.maaltijdOnderdeelId == newItem.maaltijdOnderdeelId
    }
    override fun areContentsTheSame(oldItem: MaaltijdOnderdeel, newItem: MaaltijdOnderdeel): Boolean {
        return oldItem.equals(newItem)
    }
}
class MaaltijdOnderdeelListener(val clickListener: (maaltijdOnderdeelId: Long) -> Unit) {
    fun onClick(maaltijdOnderdeel: MaaltijdOnderdeel) = clickListener(maaltijdOnderdeel.maaltijdOnderdeelId)
}