package com.example.businesscard.feature.business_card_list.presentation.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.businesscard.common.extensions.setWindowFeatures
import com.example.businesscard.databinding.FragmentDeleteBusinessCardDialogBinding

class DeleteBusinessCardDialogFragment(private val params: Params) : DialogFragment() {

    private val binding by lazy { FragmentDeleteBusinessCardDialogBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setWindowFeatures()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleButtonClick()
    }

    private fun handleButtonClick() {
        with(binding) {

            positveButton.setOnClickListener {
                params.positiveAction.invoke()
                dismiss()
            }

            negativeButton.setOnClickListener {
                params.negativeAction?.invoke()
                dismiss()
            }
        }
    }

    data class Params(
        var positiveAction: (() -> Unit),
        var negativeAction: (() -> Unit)?
    )
}