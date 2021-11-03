package com.example.businesscard.common.extensions

import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment

fun DialogFragment.setWindowFeatures() {
    dialog?.apply {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.decorView?.setBackgroundResource(android.R.color.white)
        window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}