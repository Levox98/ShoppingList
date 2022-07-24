package com.levox.shoppinglist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.levox.shoppinglist.R
import com.levox.shoppinglist.adapters.ItemAdapter
import com.levox.shoppinglist.databinding.FragmentStartBinding
import com.levox.shoppinglist.model.ListViewModel

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    private val sharedViewModel: ListViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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

        val itemAdapter = ItemAdapter(sharedViewModel)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = itemAdapter
        }

        binding.btnClearList.setOnClickListener {
            clearList(itemAdapter)
        }
    }

    fun chooseCategory() {
        findNavController().navigate(R.id.action_startFragment_to_chooseCategoryFragment)
    }

    private fun clearList(adapter: ItemAdapter) {
        sharedViewModel.clearList()
        adapter.clearData()

        Toast.makeText(requireContext(), "Список очищен", Toast.LENGTH_SHORT).show()
    }
}