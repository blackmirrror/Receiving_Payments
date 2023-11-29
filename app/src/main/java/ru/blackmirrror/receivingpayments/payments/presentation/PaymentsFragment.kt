package ru.blackmirrror.receivingpayments.payments.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.blackmirrror.receivingpayments.R
import ru.blackmirrror.receivingpayments.databinding.FragmentPaymentsBinding

class PaymentsFragment : Fragment() {

    private lateinit var binding: FragmentPaymentsBinding
    private val viewModel by viewModel<PaymentsViewModel>()

    private lateinit var adapter: PaymentsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPaymentsBinding.inflate(inflater, container, false)

        getPayments()
        setUpFields()

        return binding.root
    }

    private fun getPayments() {
        val token = arguments?.getString("token") ?: ""
        viewModel.getPayments(token)
    }

    private fun setUpFields() {
        binding.toolbar.title.text = getString(R.string.title_payments)

        adapter = PaymentsAdapter()
        binding.rvPayments.adapter = adapter

        viewModel.payments.observe(viewLifecycleOwner) { payments ->
            adapter.submitList(payments)
        }
    }
}