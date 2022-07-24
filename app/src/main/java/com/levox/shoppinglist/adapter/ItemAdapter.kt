package com.levox.shoppinglist.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.levox.shoppinglist.R
import com.levox.shoppinglist.model.Item

class ItemAdapter(val listOfItems: Array<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvItemName = view.findViewById<TextView>(R.id.item_name)

        fun bind(item: Item) {
            tvItemName.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfItems[position])
    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }
}