package com.levox.shoppinglist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.levox.shoppinglist.R
import com.levox.shoppinglist.databinding.FragmentAddItemBinding


class AddItemFragment : Fragment() {

    private var binding: FragmentAddItemBinding? = null

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

        binding?.addItemFragment = this

        binding?.tvCategoryName?.text = category
    }

    fun returnToStartScreen() {
        findNavController().navigate(R.id.action_addItemFragment_to_startFragment)
    }
}