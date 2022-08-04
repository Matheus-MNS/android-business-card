package com.example.businesscard.common.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.businesscard.feature.business_card_registration.presentation.color_picker.ColorsEnum
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class BusinessCardModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val company: String,
    val phone: String,
    val email: String,
    val cardBackground: ColorsEnum
) : Parcelable