package com.example.businesscard.feature.business_card_list.domain

import com.example.businesscard.common.data.model.BusinessCardModel
import kotlinx.coroutines.flow.Flow

class BusinessCardListUseCase(private val businessCardListRepository: BusinessCardListRepository) {

    operator fun invoke(): Flow<List<BusinessCardModel>> =
        businessCardListRepository.getBusinessCardList()
}