package com.example.businesscard.feature.business_card_registration.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.businesscard.common.data.model.BusinessCardModel
import com.example.businesscard.common.extensions.showColorPickerDialog
import com.example.businesscard.databinding.FragmentAddBusinessCardBinding
import com.example.businesscard.feature.business_card_registration.presentation.color_picker.ColorsEnum
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class BusinessCardRegistrationFragment : Fragment() {

    private val binding by lazy { FragmentAddBusinessCardBinding.inflate(layoutInflater) }
    var cardColor = ColorsEnum.DEFAULT
    val args: BusinessCardRegistrationFragmentArgs by navArgs()
    private val viewModel: BusinessCardRegistrationViewModel by viewModel {
        parametersOf(args)
    }


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
                registerBusinessCard()
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

    private fun registerBusinessCard() {
        with(binding) {
            viewModel.registerBusinessCard(
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

        viewModel.businessCardLiveData.observe(viewLifecycleOwner, {
            fillBusinessCardForms(it)
        })
    }

    private fun fillBusinessCardForms(businessCardModel: BusinessCardModel) {

        with(binding) {
            with(businessCardModel) {
                nameEditText.setText(name)
                companyEditText.setText(company)
                emailEditText.setText(email)
                phoneEditText.setText(phone)
                cardBackgroundField.setBackgroundResource(cardBackground.color)
            }
        }
    }

    private fun handleSuccess(isSuccess: Boolean) {
        if (isSuccess) {
            findNavController().popBackStack()
        }
    }

    private fun handleError(errorMessage: String) {

    }

}

