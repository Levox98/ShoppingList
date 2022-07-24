package com.levox.shoppinglist.model

import android.util.Log
import androidx.lifecycle.ViewModel
import com.levox.shoppinglist.data.DataSource

class ListViewModel : ViewModel() {

    private val _listOfItems = mutableListOf<Item>()
    val listOfItems: List<Item>
        get() = _listOfItems

    init {
        clearList()

        Log.d("MODEL", "Model initialized")
    }

    private fun fillTestList() {
        DataSource.itemList.forEach {
            _listOfItems.add(it)
        }
    }

    fun addItemToList(item: Item) {
        _listOfItems.add(item)

        Log.d("MODEL", "Item ${item.name} added")
    }

    fun removeItemFromList(item: Item) {
        _listOfItems.remove(item)
    }

    fun clearList() {
        _listOfItems.clear()
    }
}