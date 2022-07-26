package com.levox.shoppinglist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.levox.shoppinglist.R
import com.levox.shoppinglist.adapters.CategoryAdapter
import com.levox.shoppinglist.data.DataSource
import com.levox.shoppinglist.databinding.FragmentAddItemBinding
import com.levox.shoppinglist.model.ListViewModel
import java.lang.Exception


class AddItemFragment : Fragment() {

    private var binding: FragmentAddItemBinding? = null

    private val sharedViewModel: ListViewModel by activityViewModels()

    private lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            category = it.getString("Category").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val addItemBinding = FragmentAddItemBinding.inflate(inflater, container, false)
        binding = addItemBinding
        return addItemBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            addItemFragment = this@AddItemFragment
        }

        val resources = requireContext().resources

        val list = when (category) {
            resources.getString(R.string.ctg_meat) -> DataSource.meatList
            resources.getString(R.string.ctg_fruit_and_vegetables) -> DataSource.fruitAndVeggiesList
            resources.getString(R.string.ctg_sweets) -> DataSource.sweetsList
            resources.getString(R.string.ctg_coffee_tea) -> DataSource.coffeeTeaList
            resources.getString(R.string.ctg_groceries) -> DataSource.groceriesList
            resources.getString(R.string.ctg_frozen) -> DataSource.frozenList
            resources.getString(R.string.ctg_dairy) -> DataSource.dairyList
            resources.getString(R.string.ctg_sea_products) -> DataSource.seaProductsList
            resources.getString(R.string.ctg_bread) -> DataSource.breadList
            resources.getString(R.string.ctg_drinks) -> DataSource.drinksList
            resources.getString(R.string.ctg_chemistry) -> DataSource.chemistryList
            else -> throw IllegalArgumentException("Нет такой категории")
        }

        val categoryAdapter = CategoryAdapter(sharedViewModel, list)

        binding?.recyclerView?.apply {
            layoutManager = LinearLayoutManager(requireContext())

            adapter = categoryAdapter
        }
    }

    fun returnToStartScreen() {
        findNavController().navigate(R.id.action_addItemFragment_to_startFragment)
    }
}