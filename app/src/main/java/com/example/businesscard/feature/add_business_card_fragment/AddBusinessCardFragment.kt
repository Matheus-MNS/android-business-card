package com.example.businesscard.feature.add_business_card_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.businesscard.adapter.ColorPickerAdapter
import com.example.businesscard.common.extensions.showColorPickerDialog
import com.example.businesscard.databinding.FragmentAddBusinessCardBinding
import com.example.businesscard.feature.ColorPickerDialogFragment
import com.example.businesscard.common.utils.ColorsEnum

class AddBusinessCardFragment : Fragment() {

    private val binding by lazy { FragmentAddBusinessCardBinding.inflate(layoutInflater) }
    var cardColor = ColorsEnum.DEFAULT.color

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            cardBackground.setOnClickListener {
                showColorPickerDialog(
                    selectedColorAction = {
                        cardColor = it
                        cardBackground.setBackgroundResource(cardColor)
                        hintBackground.isVisible = false
                    }
                )
            }
        }
    }
}

