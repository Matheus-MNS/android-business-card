package com.example.businesscard.feature.business_card_registration.domain

import com.example.businesscard.common.data.model.BusinessCardModel
import com.example.businesscard.common.domain.EmptyCompanyException
import com.example.businesscard.common.domain.EmptyEmailException
import com.example.businesscard.common.domain.EmptyNameException
import com.example.businesscard.common.domain.EmptyPhoneException
import com.example.businesscard.feature.business_card_registration.presentation.color_picker.ColorsEnum
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BusinessCardRegistrationCardUseCase(private val repository: BusinessCardRegistrationCardRepository) {

    operator fun invoke(
        id: Int?,
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
            updateVerification(id, name, company, phone, email, cardBackground)
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

    private fun updateVerification(
        id: Int?,
        name: String,
        company: String,
        phone: String,
        email: String,
        cardBackground: ColorsEnum
    ) = if (id != null) {
        repository.updateBusinessCard(
            BusinessCardModel(
                id = id,
                name = name,
                company = company,
                phone = phone,
                email = email,
                cardBackground = cardBackground
            )
        )
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
}