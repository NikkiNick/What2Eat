package android.com.what2eat.adapters

import android.com.what2eat.databinding.MaaltijdonderdeelItemViewBinding
import android.com.what2eat.databinding.MaaltijdonderdeelItemViewClickableBinding
import android.com.what2eat.model.MaaltijdOnderdeel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MaaltijdOnderdeelClickableAdapter(val clickListener: MaaltijdOnderdeelListener) : ListAdapter<MaaltijdOnderdeel, MaaltijdOnderdeelClickableAdapter.ViewHolder>(MaaltijdOnderdeelDiffCallback()){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: MaaltijdonderdeelItemViewClickableBinding): RecyclerView.ViewHolder(binding.root){
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MaaltijdonderdeelItemViewClickableBinding.inflate(layoutInflater, parent, false)
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