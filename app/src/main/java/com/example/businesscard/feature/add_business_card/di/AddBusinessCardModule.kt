package com.example.businesscard.feature.add_business_card.di

import com.example.businesscard.feature.add_business_card.data.local.AddBusinessCardLocalDataSource
import com.example.businesscard.feature.add_business_card.data.repository.AddBusinessCardRepositoryImpl
import com.example.businesscard.feature.add_business_card.domain.AddBusinessCardRepository
import org.koin.dsl.module

val addBusinessCardModule = module {
    factory {
        AddBusinessCardLocalDataSource(
            businessCardDao = get()
        )
    }

    factory<AddBusinessCardRepository> {
        AddBusinessCardRepositoryImpl(
            localDataSource = get()
        )
    }
}