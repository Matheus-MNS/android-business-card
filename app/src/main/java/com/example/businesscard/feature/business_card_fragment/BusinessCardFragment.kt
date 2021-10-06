package com.example.businesscard.feature.business_card_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.businesscard.databinding.FragmentBusinessCardBinding

class BusinessCardFragment : Fragment() {

    private val binding by lazy { FragmentBusinessCardBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

}