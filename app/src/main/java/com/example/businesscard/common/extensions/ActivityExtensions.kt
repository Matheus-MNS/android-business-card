package com.example.businesscard.common.extensions

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.example.businesscard.feature.add_business_card.presentation.color_picker.ColorPickerDialogFragment
import com.example.businesscard.feature.add_business_card.presentation.color_picker.ColorsEnum

private const val COLOR = "Color"

fun Activity.showColorPickerDialog(
    selectedColorAction: (ColorsEnum) -> Unit = {}
) {
    val supportFragmentManager = (this as AppCompatActivity).supportFragmentManager
    val colorPicker = ColorPickerDialogFragment(
        ColorPickerDialogFragment.Params(selectedColorAction)
    )
    colorPicker.show(supportFragmentManager, COLOR)
}