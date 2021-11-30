package com.example.businesscard.feature.business_card_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.businesscard.feature.business_card_list.domain.BusinessCardListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class BusinessCardListViewModel(private val businessCardListUseCase: BusinessCardListUseCase) :
    ViewModel() {

    fun getBusinessCard() {
        viewModelScope.launch {
            businessCardListUseCase()
                .flowOn(Dispatchers.IO)
                .catch {

                }
                .collect {

                }

        }
    }
}