package com.example.businesscard.feature.business_card_list.di

import com.example.businesscard.feature.business_card_list.data.local.BusinessCardListLocalDataSource
import com.example.businesscard.feature.business_card_list.data.repository.BusinessCardListRepositoryImpl
import com.example.businesscard.feature.business_card_list.domain.BusinessCardListRepository
import org.koin.dsl.module

val businessCardListModule = module {

    factory {
        BusinessCardListLocalDataSource(
            businessCardDao = get()
        )
    }

    factory<BusinessCardListRepository> {
        BusinessCardListRepositoryImpl(
            businessCardLocalDataSource = get()
        )
    }

}