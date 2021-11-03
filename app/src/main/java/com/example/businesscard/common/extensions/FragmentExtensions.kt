package com.example.businesscard.common.extensions

import androidx.fragment.app.Fragment
import com.example.businesscard.common.utils.ColorsEnum


fun Fragment.showColorPickerDialog(
    selectedColorAction: (Int) -> Unit = {}
) {
    activity?.showColorPickerDialog(selectedColorAction)
}

