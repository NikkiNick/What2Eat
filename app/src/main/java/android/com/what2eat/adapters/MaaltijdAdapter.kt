package android.com.what2eat.adapters

import android.com.what2eat.R
import android.com.what2eat.databinding.MaaltijdItemViewBinding
import android.com.what2eat.model.Maaltijd
import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat


class MaaltijdAdapter(val clickListener: MaaltijdListener) : ListAdapter<Maaltijd, MaaltijdAdapter.ViewHolder>(MaaltijdDiffCallback()){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: MaaltijdItemViewBinding): RecyclerView.ViewHolder(binding.root){

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MaaltijdItemViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(item: Maaltijd, clickListener: MaaltijdListener) {
            binding.maaltijd = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

}
class MaaltijdDiffCallback: DiffUtil.ItemCallback<Maaltijd>(){
    override fun areItemsTheSame(oldItem: Maaltijd, newItem: Maaltijd): Boolean {
        return oldItem.maaltijdId == newItem.maaltijdId
    }
    override fun areContentsTheSame(oldItem: Maaltijd, newItem: Maaltijd): Boolean {
        return oldItem.equals(newItem)
    }
}

class MaaltijdListener(val clickListener: (maaltijdId: Long) -> Unit) {
    fun onClick(maaltijds: Maaltijd) = clickListener(maaltijds.maaltijdId)
}