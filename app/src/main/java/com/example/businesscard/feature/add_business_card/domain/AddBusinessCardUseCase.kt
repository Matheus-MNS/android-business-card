package com.example.businesscard.feature.add_business_card.domain

import com.example.businesscard.common.data.model.BusinessCardModel
import com.example.businesscard.common.domain.EmptyCompanyException
import com.example.businesscard.common.domain.EmptyEmailException
import com.example.businesscard.common.domain.EmptyNameException
import com.example.businesscard.common.domain.EmptyPhoneException
import com.example.businesscard.feature.add_business_card.presentation.color_picker.ColorsEnum
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AddBusinessCardUseCase(private val repository: AddBusinessCardRepository) {

    operator fun invoke(
        name: String?,
        company: String?,
        phone: String?,
        email: String?,
        cardBackground: ColorsEnum
    ): Flow<Unit> =
        if (name.isNullOrBlank() ||
            company.isNullOrBlank() ||
            phone.isNullOrBlank() ||
            email.isNullOrBlank()
        ) {
            handleException(name, company, phone, email)

        } else {
            repository.insertBusinessCard(
                BusinessCardModel(
                    name = name,
                    company = company,
                    phone = phone,
                    email = email,
                    cardBackground = cardBackground
                )
            )
        }

    private fun handleException(name: String?, company: String?, phone: String?, email: String?) =
        flow {
            emit(
                when {
                    name.isNullOrBlank() -> throw EmptyNameException()
                    company.isNullOrBlank() -> throw EmptyCompanyException()
                    phone.isNullOrBlank() -> throw EmptyPhoneException()
                    email.isNullOrBlank() -> throw EmptyEmailException()
                    else -> Unit
                }
            )
        }
}