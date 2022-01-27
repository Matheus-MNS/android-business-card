package com.example.businesscard.common.extensions

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.example.businesscard.feature.add_business_card.presentation.color_picker.ColorPickerDialogFragment
import com.example.businesscard.feature.add_business_card.presentation.color_picker.ColorsEnum
import com.example.businesscard.feature.business_card_list.presentation.dialog.DeleteBusinessCardDialogFragment

private const val COLOR = "Color"
private const val DELETE = "Delete"

fun Activity.showColorPickerDialog(
    selectedColorAction: (ColorsEnum) -> Unit = {}
) {
    val supportFragmentManager = (this as AppCompatActivity).supportFragmentManager
    val colorPicker = ColorPickerDialogFragment(
        ColorPickerDialogFragment.Params(selectedColorAction)
    )
    colorPicker.show(supportFragmentManager, COLOR)
}

fun Activity.showDeleteDialog(
    positiveAction: (() -> Unit),
    negativeAction: (() -> Unit)? = null
) {
    val supportFragmentManager = (this as AppCompatActivity).supportFragmentManager
    val deleteDialog = DeleteBusinessCardDialogFragment(
        DeleteBusinessCardDialogFragment.Params(
            positiveAction,
            negativeAction
        )
    )

    deleteDialog.show(supportFragmentManager, DELETE)
}