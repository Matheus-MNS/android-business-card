package com.example.businesscard.feature.business_card_list.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.businesscard.R
import com.example.businesscard.common.data.model.BusinessCardModel
import com.example.businesscard.common.extensions.showDeleteDialog
import com.example.businesscard.databinding.FragmentBusinessCardBinding
import com.example.businesscard.feature.business_card_list.presentation.adapter.BusinessCardAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class BusinessCardFragment : Fragment() {

    private val binding by lazy { FragmentBusinessCardBinding.inflate(layoutInflater) }
    private val viewModel: BusinessCardListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleObserver()
        binding.addFab.setOnClickListener {
            navigateToBusinessCardRegistration()
        }
    }

    private fun navigateToBusinessCardRegistration(businessCardModel: BusinessCardModel? = null) {
        findNavController().navigate(
            BusinessCardFragmentDirections.navigationToBusinessCardRegistration(businessCardModel)
        )
    }

    private fun handleObserver() {
        viewModel.businessCardList.observe(
            viewLifecycleOwner, Observer(
                ::handleRecyclerView
            )
        )
    }

    private fun handleRecyclerView(list: List<BusinessCardModel>) {
        val adapter = BusinessCardAdapter()
        binding.businessCardRecyclerView.adapter = adapter
        adapter.submitList(list)
        with(adapter) {
            onItemClick = {

                navigateToBusinessCardRegistration(it)
            }
            onItemLongClick = {
                showDeleteDialog(
                    positiveAction = {
                        viewModel.deleteBusinessCard(it)
                        Toast.makeText(context, R.string.confirm_delete_card, Toast.LENGTH_LONG)
                            .show()
                    },
                    negativeAction = {
                        Toast.makeText(context, R.string.negative_delete_card, Toast.LENGTH_LONG)
                            .show()
                    }
                )
            }
        }
    }
}