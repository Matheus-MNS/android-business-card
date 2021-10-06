package com.example.businesscard.feature.add_business_card_fragmnet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.businesscard.R
import com.example.businesscard.databinding.FragmentAddBusinessCardBinding


class AddBusinessCardFragment : Fragment() {

    private val binding by lazy { FragmentAddBusinessCardBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

}