package com.example.businesscard.feature.business_card_list.domain

import com.example.businesscard.common.data.model.BusinessCardModel
import kotlinx.coroutines.flow.Flow

interface BusinessCardListRepository {

    fun getBusinessCardList(): Flow<List<BusinessCardModel>>

    fun deleteBusinessCard(businessCardModel: BusinessCardModel): Flow<Unit>
}