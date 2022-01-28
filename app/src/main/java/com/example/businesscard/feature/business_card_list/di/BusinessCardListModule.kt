package com.example.businesscard.feature.business_card_list.di

import com.example.businesscard.feature.business_card_list.data.local.BusinessCardListLocalDataSource
import com.example.businesscard.feature.business_card_list.data.repository.BusinessCardListRepositoryImpl
import com.example.businesscard.feature.business_card_list.domain.BusinessCardListRepository
import com.example.businesscard.feature.business_card_list.domain.DeleteBusinessCardUseCase
import com.example.businesscard.feature.business_card_list.domain.GetBusinessCardListUseCase
import com.example.businesscard.feature.business_card_list.presentation.BusinessCardListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val businessCardListModule = module {


    factory<BusinessCardListRepository> {
        BusinessCardListRepositoryImpl(
            businessCardLocalDataSource = BusinessCardListLocalDataSource(
                businessCardDao = get()
            )
        )
    }

    viewModel {
        BusinessCardListViewModel(
            getBusinessCardListUseCase = GetBusinessCardListUseCase(
                repository = get()
            ),
            deleteBusinessCardUseCase = DeleteBusinessCardUseCase(
                repository = get()
            )
        )
    }
}