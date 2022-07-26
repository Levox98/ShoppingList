package com.levox.shoppinglist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.levox.shoppinglist.R
import com.levox.shoppinglist.data.DataSource
import com.levox.shoppinglist.databinding.FragmentChooseCategoryBinding
import com.levox.shoppinglist.model.Item
import com.levox.shoppinglist.model.ListViewModel


class ChooseCategoryFragment : Fragment() {

    private var binding: FragmentChooseCategoryBinding? = null

    private val sharedViewModel: ListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentChooseCategoryBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            chooseCategoryFragment = this@ChooseCategoryFragment
            viewModel = sharedViewModel
            dataSource = DataSource
        }
    }

    fun chooseCategory(category: String) {
        val action = ChooseCategoryFragmentDirections
            .actionChooseCategoryFragmentToAddItemFragment(category)

        findNavController().navigate(action)
    }

    private fun goToStart() {
        findNavController().navigate(R.id.action_chooseCategoryFragment_to_startFragment)
    }
}