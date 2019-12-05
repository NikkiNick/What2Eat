package android.com.what2eat.adapters

import android.com.what2eat.databinding.MaaltijdonderdeelItemViewBinding
import android.com.what2eat.model.MaaltijdOnderdeel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class MaaltijdOnderdeelAdapter() : ListAdapter<MaaltijdOnderdeel, MaaltijdOnderdeelAdapter.ViewHolder>(MaaltijdOnderdeelDiffCallback()){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
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

        fun bind(item: MaaltijdOnderdeel) {
            binding.maaltijdOnderdeel = item
            binding.executePendingBindings()
        }
    }
}
