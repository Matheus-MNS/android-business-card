package com.example.businesscard.feature.business_card_list.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.businesscard.databinding.FragmentBusinessCardBinding
import com.example.businesscard.feature.business_card_list.presentation.adapter.BusinessCardAdapter

class BusinessCardFragment : Fragment() {

    private val binding by lazy { FragmentBusinessCardBinding.inflate(layoutInflater) }
    private val adapter by lazy { BusinessCardAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.businessCardRecyclerView.adapter = adapter

        binding.addFab.setOnClickListener {
            handleNavigation()
        }
    }

    private fun handleNavigation() {
        findNavController().navigate(
            BusinessCardFragmentDirections.actionBusinessCardFragmentToAddBusinessCardFragment()
        )
    }

}