import android.com.what2eat.R
import android.com.what2eat.model.Maaltijd
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MaaltijdAdapter: RecyclerView.Adapter<MaaltijdAdapter.ViewHolder>(){
    var data = listOf<Maaltijd>()
        set(value){ field = value
            notifyDataSetChanged()
        }
    override fun getItemCount(): Int {
        return data.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.maaltijd_naam.text = item.naam
        when(item.rating) {
            1 -> holder.maaltijd_rating1.setImageResource(android.R.drawable.star_big_on)
            2 -> {
                holder.maaltijd_rating1.setImageResource(android.R.drawable.star_big_on)
                holder.maaltijd_rating2.setImageResource(android.R.drawable.star_big_on)
            }
            3 -> {
                holder.maaltijd_rating1.setImageResource(android.R.drawable.star_big_on)
                holder.maaltijd_rating2.setImageResource(android.R.drawable.star_big_on)
                holder.maaltijd_rating3.setImageResource(android.R.drawable.star_big_on)
            }
            4 -> {
                holder.maaltijd_rating1.setImageResource(android.R.drawable.star_big_on)
                holder.maaltijd_rating2.setImageResource(android.R.drawable.star_big_on)
                holder.maaltijd_rating3.setImageResource(android.R.drawable.star_big_on)
                holder.maaltijd_rating4.setImageResource(android.R.drawable.star_big_on)
            }
            5 -> {
                holder.maaltijd_rating1.setImageResource(android.R.drawable.star_big_on)
                holder.maaltijd_rating2.setImageResource(android.R.drawable.star_big_on)
                holder.maaltijd_rating3.setImageResource(android.R.drawable.star_big_on)
                holder.maaltijd_rating4.setImageResource(android.R.drawable.star_big_on)
                holder.maaltijd_rating5.setImageResource(android.R.drawable.star_big_on)
            }

        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.maaltijd_item_view, parent, false)
        return ViewHolder(view)
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val maaltijd_naam: TextView = itemView.findViewById(R.id.maaltijd_naam)
        val maaltijd_rating1: ImageView = itemView.findViewById(R.id.maaltijd_rating1)
        val maaltijd_rating2: ImageView = itemView.findViewById(R.id.maaltijd_rating2)
        val maaltijd_rating3: ImageView = itemView.findViewById(R.id.maaltijd_rating3)
        val maaltijd_rating4: ImageView = itemView.findViewById(R.id.maaltijd_rating4)
        val maaltijd_rating5: ImageView = itemView.findViewById(R.id.maaltijd_rating5)
    }
}