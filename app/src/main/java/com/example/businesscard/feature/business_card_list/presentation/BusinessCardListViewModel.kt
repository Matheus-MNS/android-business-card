package com.example.businesscard.feature.business_card_list.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.businesscard.common.data.model.BusinessCardModel
import com.example.businesscard.feature.business_card_list.domain.GetBusinessCardListUseCase
import com.example.businesscard.feature.business_card_list.domain.DeleteBusinessCardUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class BusinessCardListViewModel(
    private val getBusinessCardListUseCase: GetBusinessCardListUseCase,
    private val deleteBusinessCardUseCase: DeleteBusinessCardUseCase
) : ViewModel() {

    val businessCardList: MutableLiveData<List<BusinessCardModel>> by lazy {
        MutableLiveData<List<BusinessCardModel>>()
    }

    init {
        getBusinessCard()
    }

    private fun getBusinessCard() {
        viewModelScope.launch {
            getBusinessCardListUseCase()
                .flowOn(Dispatchers.IO)
                .catch {
                }
                .collect {
                    businessCardList.value = it
                }
        }
    }

    fun deleteBusinessCard(businessCard: BusinessCardModel) {
        viewModelScope.launch {
            deleteBusinessCardUseCase(businessCard)
                .flowOn(Dispatchers.IO)
                .catch {

                }
                .collect {

                }
        }

    }
}