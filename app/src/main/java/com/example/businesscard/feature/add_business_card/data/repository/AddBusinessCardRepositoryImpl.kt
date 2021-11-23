package com.example.businesscard.feature.add_business_card.data.repository

import com.example.businesscard.common.data.model.BusinessCardModel
import com.example.businesscard.feature.add_business_card.data.local.AddBusinessCardLocalDataSource
import com.example.businesscard.feature.add_business_card.domain.AddBusinessCardRepository
import kotlinx.coroutines.flow.Flow

class AddBusinessCardRepositoryImpl(
    private val localDataSource: AddBusinessCardLocalDataSource
) : AddBusinessCardRepository {

    override fun insertBusinessCard(businessCardModel: BusinessCardModel): Flow<Unit> =
        localDataSource.insertBusinessCard(businessCardModel)
}