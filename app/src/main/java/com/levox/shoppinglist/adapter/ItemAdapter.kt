package com.levox.shoppinglist.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.levox.shoppinglist.R
import com.levox.shoppinglist.model.Item
import com.levox.shoppinglist.model.ListViewModel

class ItemAdapter(viewModel: ListViewModel) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val model = viewModel

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvName = view.findViewById<TextView>(R.id.item_name)

        fun bind(item: Item) {
            tvName.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        Log.d("RECYCLER_VIEW", "ViewHolderCreated")
        return ItemViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Log.d("RECYCLER_VIEW", "ViewHolderCreated")
        holder.bind(model.listOfItems[position])
    }

    override fun getItemCount(): Int {
        return model.listOfItems.size
    }


}