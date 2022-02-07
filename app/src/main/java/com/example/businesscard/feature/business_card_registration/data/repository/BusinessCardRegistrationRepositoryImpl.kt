package com.example.businesscard.feature.business_card_registration.data.repository

import com.example.businesscard.common.data.model.BusinessCardModel
import com.example.businesscard.feature.business_card_registration.data.local.BusinessCardRegistrationLocalDataSource
import com.example.businesscard.feature.business_card_registration.domain.BusinessCardRegistrationCardRepository
import kotlinx.coroutines.flow.Flow

class BusinessCardRegistrationRepositoryImpl(
    private val localDataSource: BusinessCardRegistrationLocalDataSource
) : BusinessCardRegistrationCardRepository {

    override fun insertBusinessCard(businessCardModel: BusinessCardModel): Flow<Unit> =
        localDataSource.insertBusinessCard(businessCardModel)

    override fun updateBusinessCard(businessCardModel: BusinessCardModel): Flow<Unit> =
        localDataSource.updateBusinessCard(businessCardModel)

}