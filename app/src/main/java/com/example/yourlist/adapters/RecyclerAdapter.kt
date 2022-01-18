package com.example.yourlist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yourlist.R
import com.example.yourlist.data.DataHolder
import com.example.yourlist.fragments.TodoHolderFragment

open class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = "${position+1})" + DataHolder.Todos[position].name
    }

    override fun getItemCount(): Int = DataHolder.amount()



inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    var itemName : TextView = itemView.findViewById(R.id.text_view)

    init{

        itemView.setOnClickListener{
            DataHolder.Position = absoluteAdapterPosition
            DataHolder.mainActivity.changeFragment(TodoHolderFragment())
        }
    }
}

}