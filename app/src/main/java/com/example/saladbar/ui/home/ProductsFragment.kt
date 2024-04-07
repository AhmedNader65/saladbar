package com.example.saladbar.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.saladbar.R
import com.example.saladbar.databinding.FragmentProductsBinding
import com.example.saladbar.ui.slot.SlotDialogFragment

class ProductsFragment : Fragment() {

    private var _binding: FragmentProductsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val dummyList = mutableListOf<String>()
        repeat(8){
            dummyList.add("$it")
        }
        binding.slotLayout.setOnClickListener {
            val dialog = SlotDialogFragment()
            dialog.show(parentFragmentManager, "dialog")
        }
        binding.recyclerView.adapter =CustomAdapter(dummyList.toList(), listener = object : ProductItemListener{
            override fun onItemClick(item: String) {
                findNavController().navigate(R.id.action_navigation_products_to_navigation_qr)
            }

        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}