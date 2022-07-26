package com.levox.shoppinglist.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.levox.shoppinglist.databinding.ItemInListLayoutBinding
import com.levox.shoppinglist.model.Item
import com.levox.shoppinglist.model.ListViewModel

class ItemAdapter(viewModel: ListViewModel) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val model = viewModel

    class ItemViewHolder(binding: ItemInListLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        private val tvName = binding.itemName
        private val cbGot = binding.itemCheckbox
        private val btnRemoveItem = binding.itemDelete

        fun bindText(item: Item) {
            tvName.text = item.name
        }

        fun bindButtons(adapter: ItemAdapter, position: Int) {
            btnRemoveItem.setOnClickListener {
                adapter.removeItem(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        Log.d("RECYCLER_VIEW", "ViewHolderCreated")
        return ItemViewHolder(ItemInListLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Log.d("RECYCLER_VIEW", "ViewHolderCreated")
        holder.bindText(model.listOfItems[position])
        holder.bindButtons(this, position)
    }

    override fun getItemCount(): Int {
        return model.listOfItems.size
    }

    fun removeItem(position: Int) {
        model.removeItemFromList(position)
        notifyDataSetChanged()
    }

    fun clearData() {
        model.clearList()
        notifyDataSetChanged()
    }
}