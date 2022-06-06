package developer.stlindia.diffutildemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class DataAdapter : ListAdapter<dataItem,DataAdapter.DataViewHolder>(DiffUtil()){

    class DataViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val name=view.findViewById<TextView>(R.id.name)
        val initial=view.findViewById<TextView>(R.id.initial)

        fun bind(item:dataItem){
            name.text=item.name
            initial.text=item.initial
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        val item=getItem(position)
        holder.bind(item)

    }

    class DiffUtil: androidx.recyclerview.widget.DiffUtil.ItemCallback<dataItem>() {
        override fun areItemsTheSame(oldItem: dataItem, newItem: dataItem): Boolean {
          return oldItem.id==newItem.id

        }

        override fun areContentsTheSame(oldItem: dataItem, newItem: dataItem
        ): Boolean {
                return oldItem==newItem
        }
    }
}