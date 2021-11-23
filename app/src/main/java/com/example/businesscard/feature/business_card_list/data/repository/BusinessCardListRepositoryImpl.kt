package com.example.businesscard.feature.business_card_list.data.repository

import com.example.businesscard.common.data.model.BusinessCardModel
import com.example.businesscard.feature.business_card_list.data.local.BusinessCardListLocalDataSource
import com.example.businesscard.feature.business_card_list.domain.BusinessCardListRepository
import kotlinx.coroutines.flow.Flow

class BusinessCardListRepositoryImpl(
    private val businessCardLocalDataSource: BusinessCardListLocalDataSource
) : BusinessCardListRepository {

    override fun getBusinessCardList(): Flow<List<BusinessCardModel>> =
        businessCardLocalDataSource.getBusinessCardList()
}