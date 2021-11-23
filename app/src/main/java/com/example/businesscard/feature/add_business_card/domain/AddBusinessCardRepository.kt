package com.example.businesscard.feature.add_business_card.domain

import com.example.businesscard.common.data.model.BusinessCardModel
import kotlinx.coroutines.flow.Flow

interface AddBusinessCardRepository {

    fun insertBusinessCard(businessCardModel: BusinessCardModel): Flow<Unit>

}