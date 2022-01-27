package com.example.businesscard.feature.business_card_list.domain

import com.example.businesscard.common.data.model.BusinessCardModel
import kotlinx.coroutines.flow.Flow

class DeleteBusinessCardUseCase(private val repository: BusinessCardListRepository) {

    operator fun invoke(businessCard: BusinessCardModel): Flow<Unit> =
        repository.deleteBusinessCard(businessCard)
}