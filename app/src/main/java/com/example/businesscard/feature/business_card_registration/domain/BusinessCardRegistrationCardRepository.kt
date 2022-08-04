package com.example.businesscard.feature.business_card_registration.domain

import com.example.businesscard.common.data.model.BusinessCardModel
import kotlinx.coroutines.flow.Flow

interface BusinessCardRegistrationCardRepository {

    fun insertBusinessCard(businessCardModel: BusinessCardModel): Flow<Unit>

    fun updateBusinessCard(businessCardModel: BusinessCardModel): Flow<Unit>

}