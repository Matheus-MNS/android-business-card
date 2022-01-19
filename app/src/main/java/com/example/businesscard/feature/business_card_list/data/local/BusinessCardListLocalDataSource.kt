package com.example.businesscard.feature.business_card_list.data.local

import com.example.businesscard.common.data.local.BusinessCardDao
import com.example.businesscard.common.data.model.BusinessCardModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BusinessCardListLocalDataSource(private val businessCardDao: BusinessCardDao) {

    fun getBusinessCardList(): Flow<List<BusinessCardModel>> =
        businessCardDao.getBusinessCardList()

}