package com.example.businesscard.feature.add_business_card.data.local

import com.example.businesscard.common.data.local.BusinessCardDao
import com.example.businesscard.common.data.model.BusinessCardModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AddBusinessCardLocalDataSource(private val businessCardDao: BusinessCardDao) {

    fun insertBusinessCard(businessCardModel: BusinessCardModel): Flow<Unit> = flow {
        emit(
            businessCardDao.insertBusinessCard(businessCardModel)
        )
    }
}