package com.example.businesscard.feature.add_business_card.domain

import com.example.businesscard.common.data.model.BusinessCardModel
import com.example.businesscard.feature.add_business_card.presentation.color_picker.ColorsEnum
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AddBusinessCardUseCase(private val addBusinessCardRepository: AddBusinessCardRepository) {

    operator fun invoke(businessCardModel: BusinessCardModel) = flow {
        var name: String
        var company: String
        var phone: String
        var emial: String
        var cardBackground: ColorsEnum

        emit(
            addBusinessCardRepository.insertBusinessCard(
                (businessCardModel)
            )
        )

    }.flowOn(Dispatchers.IO)

}