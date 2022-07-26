package com.levox.shoppinglist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.levox.shoppinglist.R
import com.levox.shoppinglist.databinding.ItemInCategoryLayoutBinding
import com.levox.shoppinglist.fragments.AddItemFragment
import com.levox.shoppinglist.fragments.AddItemFragmentDirections
import com.levox.shoppinglist.model.Item
import com.levox.shoppinglist.model.ListViewModel

class CategoryAdapter(viewModel: ListViewModel, itemList: List<Item>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private val model = viewModel
    private val listOfItems = itemList

    class ViewHolder(val binding: ItemInCategoryLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        val image = binding.imgItem
        val name = binding.tvItemName
        val addItemBtn = binding.btnAddItemToList

        fun bind(item: Item, viewModel: ListViewModel) {
            name.text = item.name

            val action = AddItemFragmentDirections.actionAddItemFragmentToStartFragment()

            addItemBtn.setOnClickListener {
                viewModel.addItemToList(item)
                binding.root.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemInCategoryLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfItems[position], model)
    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }


}