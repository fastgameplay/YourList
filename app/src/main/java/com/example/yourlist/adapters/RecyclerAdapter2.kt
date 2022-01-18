package com.example.yourlist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.yourlist.R
import com.example.yourlist.data.DataHolder
import android.widget.CompoundButton




open class RecyclerAdapter2 : RecyclerView.Adapter<RecyclerAdapter2.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_todo_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.checkBox.setOnCheckedChangeListener(null);

        holder.checkBox.isChecked = DataHolder.Todos!![DataHolder.Position].todoList[position].isDone;

        holder.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            DataHolder.Todos!![DataHolder.Position].todoList[position].isDone = isChecked
        }

        holder.checkBox.text = DataHolder.Todos!![DataHolder.Position].todoList[position].text
    }

    override fun getItemCount(): Int = DataHolder.Todos!![DataHolder.Position].todoList.count()



inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    var checkBox : CheckBox = itemView.findViewById(R.id.my_check_box)

}

}