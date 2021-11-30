package com.example.businesscard.feature.add_business_card.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.businesscard.feature.add_business_card.domain.AddBusinessCardUseCase
import com.example.businesscard.feature.add_business_card.presentation.color_picker.ColorsEnum
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class AddBusinessCardViewModel(private val addBusinessCardUseCase: AddBusinessCardUseCase) :
    ViewModel() {

    fun saveBusinessCard(
        name: String?,
        company: String?,
        phone: String?,
        email: String?,
        cardBackground: ColorsEnum

    ) {
        viewModelScope.launch {
            addBusinessCardUseCase(
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
                    handleSuccess()
                }

        }
    }

    private fun handleSuccess() {

    }

    private fun handleError(error: Throwable) {

    }

}