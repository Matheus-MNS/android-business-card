package com.example.businesscard.feature.add_business_card_fragment.presentation.color_picker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscard.databinding.ItemColorBinding
import com.example.businesscard.feature.add_business_card_fragment.presentation.color_picker.ColorsEnum

class ColorPickerAdapter(private val list: List<ColorsEnum>) :
    RecyclerView.Adapter<ColorPickerAdapter.ViewHolder>() {

    var onItemClick: ((ColorsEnum) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemColorBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: ColorPickerAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    //var colorClickListener: AdapterItemWithParameterClickListener<Int>

    inner class ViewHolder(private val binding: ItemColorBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(enum: ColorsEnum) {
            with(binding) {
                pickerColor.setBackgroundResource(enum.color)
                itemView.setOnClickListener {
                    onItemClick?.invoke(enum)
                }
            }
        }
    }
}