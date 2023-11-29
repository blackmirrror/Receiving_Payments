package ru.blackmirrror.receivingpayments.payments.presentation

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import ru.blackmirrror.receivingpayments.payments.domain.models.Payment

class PaymentItemDiffCallback: ItemCallback<Payment>() {
    override fun areItemsTheSame(oldItem: Payment, newItem: Payment): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Payment, newItem: Payment): Boolean {
        return oldItem == newItem
    }
}