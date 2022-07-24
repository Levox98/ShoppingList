package com.levox.shoppinglist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.levox.shoppinglist.R
import com.levox.shoppinglist.adapter.ItemAdapter
import com.levox.shoppinglist.databinding.FragmentStartBinding
import com.levox.shoppinglist.model.ListViewModel

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    val sharedViewModel: ListViewModel by activityViewModels()


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

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ItemAdapter(sharedViewModel)
        }
    }

    fun chooseCategory() {
        findNavController().navigate(R.id.action_startFragment_to_chooseCategoryFragment)
    }

    private fun clearList() {
        sharedViewModel.clearList()
        binding.recyclerView
    }
}