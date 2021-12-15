package com.example.businesscard.feature.add_business_card.presentation.color_picker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.businesscard.feature.add_business_card.presentation.color_picker.adapter.ColorPickerAdapter
import com.example.businesscard.common.extensions.setWindowFeatures
import com.example.businesscard.databinding.FragmentColorPickerDialogBinding

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
        val pickerAdapter = ColorPickerAdapter()
        pickerAdapter.submitList(ColorsEnum.DUMBLIST)
        binding.colorPickerRecycler.adapter = pickerAdapter
        pickerAdapter.colorClickListener = {
            params.selectedColorAction.invoke(it)
            dismiss()
        }
    }

    data class Params(
        var selectedColorAction: (ColorsEnum) -> Unit = {}
    )
}