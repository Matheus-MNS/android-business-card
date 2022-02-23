package com.example.businesscard.feature.business_card_registration.presentation.color_picker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscard.common.utils.AdapterItemWithParameterClickListener
import com.example.businesscard.common.utils.DefaultDiffCallback
import com.example.businesscard.databinding.ItemColorBinding
import com.example.businesscard.feature.business_card_registration.presentation.color_picker.ColorsEnum

class ColorPickerAdapter :
    ListAdapter<ColorsEnum, ColorPickerAdapter.ViewHolder>(DefaultDiffCallback<ColorsEnum>()) {

    var colorClickListener: AdapterItemWithParameterClickListener<ColorsEnum> = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemColorBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemColorBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(enum: ColorsEnum) {
            with(binding) {
                pickerColor.setBackgroundResource(enum.color)
                itemView.setOnClickListener {
                    colorClickListener(enum)
                }
            }
        }
    }
}