package com.example.businesscard.common.extensions

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.example.businesscard.common.utils.ColorsEnum
import com.example.businesscard.feature.ColorPickerDialogFragment

private const val COLOR = "Color"

fun Activity.showColorPickerDialog(
    selectedColorAction: (Int) -> Unit = {}
) {
    val supportFragmentManager = (this as AppCompatActivity).supportFragmentManager
    val colorPicker = ColorPickerDialogFragment(
        ColorPickerDialogFragment.Params(selectedColorAction)
    )
    colorPicker.show(supportFragmentManager, COLOR)
}