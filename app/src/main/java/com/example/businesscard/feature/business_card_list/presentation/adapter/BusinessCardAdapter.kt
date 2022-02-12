package com.example.businesscard.feature.business_card_list.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscard.common.data.model.BusinessCardModel
import com.example.businesscard.common.extensions.setBackgroundTint
import com.example.businesscard.common.utils.DefaultDiffCallback
import com.example.businesscard.databinding.ItemBusinessCardBinding

class BusinessCardAdapter :
    ListAdapter<BusinessCardModel, BusinessCardAdapter.ViewHolder>(DefaultDiffCallback<BusinessCardModel>()) {

    var onItemClick: ((BusinessCardModel) -> Unit)? = null
    var onItemLongClick: ((BusinessCardModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BusinessCardModel) {
            with(binding) {
                name.text = item.name
                company.text = item.company
                phone.text = item.phone
                email.text = item.email
                businessCard.setBackgroundTint(item.cardBackground.color)

                itemView.setOnClickListener {
                    onItemClick?.invoke(item)
                }

                itemView.setOnClickListener {
                    onItemLongClick?.invoke(item)
                    return@setOnClickListener
                }
            }
        }
    }
}