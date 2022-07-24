package com.levox.shoppinglist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.levox.shoppinglist.R
import com.levox.shoppinglist.adapter.ItemAdapter
import com.levox.shoppinglist.data.DataSource
import com.levox.shoppinglist.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            startFragment = this@StartFragment
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = ItemAdapter(DataSource.itemList)
        }
    }

    fun chooseCategory() {
        findNavController().navigate(R.id.action_startFragment_to_chooseCategoryFragment)
    }

}