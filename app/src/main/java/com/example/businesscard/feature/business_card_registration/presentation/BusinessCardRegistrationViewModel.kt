package com.example.businesscard.feature.business_card_registration.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.businesscard.common.data.model.BusinessCardModel
import com.example.businesscard.common.domain.EmptyCompanyException
import com.example.businesscard.common.domain.EmptyEmailException
import com.example.businesscard.common.domain.EmptyNameException
import com.example.businesscard.common.domain.EmptyPhoneException
import com.example.businesscard.feature.business_card_registration.domain.BusinessCardRegistrationCardUseCase
import com.example.businesscard.feature.business_card_registration.presentation.color_picker.ColorsEnum
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class BusinessCardRegistrationViewModel(
    private val businessCardRegistrationCardUseCase: BusinessCardRegistrationCardUseCase,
    private val args: BusinessCardRegistrationFragmentArgs
) : ViewModel() {

    val nameErrorMessageLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val companyErrorMessageLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val phoneErrorMessageLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val emailErrorMessageLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val cardSuccessLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val businessCardLiveData: MutableLiveData<BusinessCardModel> by lazy {
        MutableLiveData<BusinessCardModel>()
    }

    init {
        if (args.businessCard != null) {
            businessCardLiveData.value = args.businessCard
        }
    }


    fun registerBusinessCard(
        name: String?,
        company: String?,
        phone: String?,
        email: String?,
        cardBackground: ColorsEnum

    ) {
        viewModelScope.launch {
            businessCardRegistrationCardUseCase(
                args.businessCard?.id,
                name,
                company,
                phone,
                email,
                cardBackground
            )
                .flowOn(Dispatchers.IO)
                .catch {
                    handleError(it)
                }
                .collect {
                    cardSuccessLiveData.value = true
                }
        }
    }

    private fun handleError(error: Throwable) {
        when (error) {
            is EmptyNameException ->
                nameErrorMessageLiveData.value = error.message
            is EmptyCompanyException ->
                companyErrorMessageLiveData.value = error.message
            is EmptyPhoneException ->
                phoneErrorMessageLiveData.value = error.message
            is EmptyEmailException ->
                emailErrorMessageLiveData.value = error.message
        }
    }

}