package ru.blackmirrror.receivingpayments.payments.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.blackmirrror.receivingpayments.R
import ru.blackmirrror.receivingpayments.databinding.FragmentPaymentsBinding

class PaymentsFragment : Fragment() {

    private lateinit var binding: FragmentPaymentsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPaymentsBinding.inflate(inflater, container, false)

        setUpFields()

        return binding.root
    }

    private fun setUpFields() {
        binding.toolbar.title.text = getString(R.string.title_payments)
    }
}