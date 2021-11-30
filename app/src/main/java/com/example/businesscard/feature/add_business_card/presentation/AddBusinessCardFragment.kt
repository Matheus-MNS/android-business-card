package com.example.businesscard.feature.add_business_card.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.businesscard.common.extensions.showColorPickerDialog
import com.example.businesscard.databinding.FragmentAddBusinessCardBinding
import com.example.businesscard.feature.add_business_card.presentation.color_picker.ColorsEnum
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddBusinessCardFragment : Fragment() {

    private val binding by lazy { FragmentAddBusinessCardBinding.inflate(layoutInflater) }
    var cardColor = ColorsEnum.DEFAULT
    private val viewModel: AddBusinessCardViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardBackgroundField.setBackgroundResource(cardColor.color)
        handleClickListener()
    }

    private fun handleClickListener() {
        with(binding) {
            cardBackgroundField.setOnClickListener {
                showColorPicker()
            }
            saveCardButton.setOnClickListener {
                saveBusinessCard()
            }
        }
    }

    private fun saveBusinessCard() {
        with(binding) {
            viewModel.saveBusinessCard(
                name = editName.text.toString(),
                company = editEnterprise.text.toString(),
                phone = editPhone.text.toString(),
                email = editEmail.text.toString(),
                cardBackground = cardColor
            )
        }
        
    }

    private fun showColorPicker() {
        showColorPickerDialog(
            selectedColorAction = {
                cardColor = it
                binding.cardBackgroundField.setBackgroundResource(it.color)
                binding.hintBackground.isVisible = false
            }
        )
    }
}

