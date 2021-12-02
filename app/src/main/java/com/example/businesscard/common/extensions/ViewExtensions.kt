package com.example.businesscard.common.extensions

import android.content.res.ColorStateList
import android.view.View
import androidx.core.content.ContextCompat

fun View.setBackgroundTint(color: Int) {
    this.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, color))
}