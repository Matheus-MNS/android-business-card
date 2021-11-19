package com.example.businesscard.common.extensions

import androidx.fragment.app.Fragment
import com.example.businesscard.feature.add_business_card_fragment.presentation.color_picker.ColorsEnum


fun Fragment.showColorPickerDialog(
    selectedColorAction: (ColorsEnum) -> Unit = {}
) {
    activity?.showColorPickerDialog(selectedColorAction)
}

