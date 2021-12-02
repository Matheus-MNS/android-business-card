package com.example.businesscard.feature.add_business_card.di

import com.example.businesscard.feature.add_business_card.data.local.AddBusinessCardLocalDataSource
import com.example.businesscard.feature.add_business_card.data.repository.AddBusinessCardRepositoryImpl
import com.example.businesscard.feature.add_business_card.domain.AddBusinessCardRepository
import com.example.businesscard.feature.add_business_card.domain.AddBusinessCardUseCase
import com.example.businesscard.feature.add_business_card.presentation.AddBusinessCardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val addBusinessCardModule = module {

    factory<AddBusinessCardRepository> {
        AddBusinessCardRepositoryImpl(
            localDataSource = AddBusinessCardLocalDataSource(
                businessCardDao = get()
            )
        )
    }

    viewModel {
        AddBusinessCardViewModel(
            addBusinessCardUseCase = AddBusinessCardUseCase(
                repository = get()
            )
        )
    }
}