package com.example.businesscard.feature.business_card_list.domain

import com.example.businesscard.common.data.model.BusinessCardModel
import kotlinx.coroutines.flow.Flow

class GetBusinessCardListUseCase(private val repository: BusinessCardListRepository) {

    operator fun invoke(): Flow<List<BusinessCardModel>> =
        repository.getBusinessCardList()
}