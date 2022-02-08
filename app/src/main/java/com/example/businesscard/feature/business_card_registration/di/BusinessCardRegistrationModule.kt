package com.example.businesscard.feature.business_card_registration.di

import com.example.businesscard.feature.business_card_registration.data.local.BusinessCardRegistrationLocalDataSource
import com.example.businesscard.feature.business_card_registration.data.repository.BusinessCardRegistrationRepositoryImpl
import com.example.businesscard.feature.business_card_registration.domain.BusinessCardRegistrationCardRepository
import com.example.businesscard.feature.business_card_registration.domain.BusinessCardRegistrationCardUseCase
import com.example.businesscard.feature.business_card_registration.presentation.BusinessCardRegistrationFragmentArgs
import com.example.businesscard.feature.business_card_registration.presentation.BusinessCardRegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val addBusinessCardModule = module {

    factory<BusinessCardRegistrationCardRepository> {
        BusinessCardRegistrationRepositoryImpl(
            localDataSource = BusinessCardRegistrationLocalDataSource(
                businessCardDao = get()
            )
        )
    }

    viewModel { (args: BusinessCardRegistrationFragmentArgs) ->
        BusinessCardRegistrationViewModel(
            businessCardRegistrationCardUseCase = BusinessCardRegistrationCardUseCase(
                repository = get()
            ),
            args = args
        )
    }
}