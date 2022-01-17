package com.example.yourlist.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yourlist.R
import com.example.yourlist.fragments.data.DataHolder

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = DataHolder.Todos[position].name
    }

    override fun getItemCount(): Int = DataHolder.amount()



inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    var itemName : TextView
    init{
        itemName = itemView.findViewById(R.id.textView)

        itemView.setOnClickListener{
            val position: Int = adapterPosition
        }
    }
}

}