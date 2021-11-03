package com.example.businesscard.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.businesscard.adapter.ColorPickerAdapter
import com.example.businesscard.common.extensions.setWindowFeatures
import com.example.businesscard.common.extensions.showColorPickerDialog
import com.example.businesscard.databinding.FragmentColorPickerDialogBinding
import com.example.businesscard.common.utils.ColorsEnum

class ColorPickerDialogFragment(private val params: Params) : DialogFragment() {

    private val binding by lazy { FragmentColorPickerDialogBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setWindowFeatures()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleColorSelected()
    }

    private fun handleColorSelected() {
        val pickerAdapter = ColorPickerAdapter(ColorsEnum.DUMBLIST)
        binding.colorPickerRecycler.adapter = pickerAdapter
        pickerAdapter.onItemClick = {
            params.selectedColorAction.invoke(it.color)
            dismiss()
        }
    }

    data class Params(
        var selectedColorAction: (Int) -> Unit = {}
    )
}