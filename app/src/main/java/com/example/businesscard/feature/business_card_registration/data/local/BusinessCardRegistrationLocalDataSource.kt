package com.example.businesscard.feature.business_card_registration.data.local

import com.example.businesscard.common.data.local.BusinessCardDao
import com.example.businesscard.common.data.model.BusinessCardModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BusinessCardRegistrationLocalDataSource(private val businessCardDao: BusinessCardDao) {

    fun insertBusinessCard(businessCardModel: BusinessCardModel): Flow<Unit> = flow {
        emit(
            businessCardDao.insertBusinessCard(businessCardModel)
        )
    }

    fun updateBusinessCard(businessCardModel: BusinessCardModel): Flow<Unit> = flow {
        emit(
            businessCardDao.updateBusinessCard(businessCardModel)
        )
    }
}