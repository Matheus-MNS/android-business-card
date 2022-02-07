package com.example.businesscard.feature.business_card_registration.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.businesscard.common.extensions.showColorPickerDialog
import com.example.businesscard.databinding.FragmentAddBusinessCardBinding
import com.example.businesscard.feature.business_card_registration.presentation.color_picker.ColorsEnum
import org.koin.androidx.viewmodel.ext.android.viewModel

class BusinessCardRegistrationFragment : Fragment() {

    private val binding by lazy { FragmentAddBusinessCardBinding.inflate(layoutInflater) }
    var cardColor = ColorsEnum.DEFAULT
    private val viewModel: BusinessCardRegistrationViewModel by viewModel()

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
        handleObserver()
    }

    private fun handleClickListener() {
        with(binding) {
            cardBackgroundField.setOnClickListener {
                showColorPicker()
            }
            saveCardButton.setOnClickListener {
                saveBusinessCard()
                clearErrorField()
            }
            closeButton.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun clearErrorField() {
        with(binding) {
            nameTil.isErrorEnabled = false
            companyTil.isErrorEnabled = false
            phoneTil.isErrorEnabled = false
            emailTil.isErrorEnabled = false
        }
    }

    private fun saveBusinessCard() {
        with(binding) {
            viewModel.saveBusinessCard(
                name = nameEditText.text.toString(),
                company = companyEditText.text.toString(),
                phone = phoneEditText.text.toString(),
                email = emailEditText.text.toString(),
                cardBackground = cardColor
            )
        }
    }

    private fun showColorPicker() {
        showColorPickerDialog(
            selectedColorAction = {
                cardColor = it
                binding.cardBackgroundField.setBackgroundResource(it.color)
                binding.hintBackgroundTextView.isVisible = false
            }
        )
    }

    private fun handleObserver() {
        viewModel.cardSuccessLiveData.observe(
            viewLifecycleOwner, Observer(
                ::handleSuccess
            )
        )
        viewModel.nameErrorMessageLiveData.observe(viewLifecycleOwner, {
            binding.nameTil.error = it
        })

        viewModel.companyErrorMessageLiveData.observe(viewLifecycleOwner, {
            binding.companyTil.error = it
        })

        viewModel.phoneErrorMessageLiveData.observe(viewLifecycleOwner, {
            binding.phoneTil.error = it
        })

        viewModel.emailErrorMessageLiveData.observe(viewLifecycleOwner, {
            binding.emailTil.error = it
        })
    }

    private fun handleSuccess(isSuccess: Boolean) {
        if (isSuccess) {
            findNavController().popBackStack()
        }
    }

    private fun handleError(errorMessage: String) {

    }
}

