package com.example.businesscard.common.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.businesscard.feature.add_business_card.presentation.color_picker.ColorsEnum

@Entity
data class BusinessCardModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val company: String,
    val phone: String,
    val email: String,
    val cardBackground: ColorsEnum
)