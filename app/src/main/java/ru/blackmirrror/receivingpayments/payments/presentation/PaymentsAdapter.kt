package ru.blackmirrror.receivingpayments.payments.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.blackmirrror.receivingpayments.R
import ru.blackmirrror.receivingpayments.payments.domain.models.Payment
import ru.blackmirrror.receivingpayments.payments.presentation.utils.TextFormatter

class PaymentsAdapter :
    ListAdapter<Payment, PaymentsAdapter.PaymentsViewHolder>(PaymentItemDiffCallback()) {

    class PaymentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_payment_title)
        val amount: TextView = itemView.findViewById(R.id.tv_payment_amount)
        val date: TextView = itemView.findViewById(R.id.tv_payment_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_payment, parent, false)
        return PaymentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaymentsViewHolder, position: Int) {
        val payment = getItem(position)
        holder.title.text = payment.title ?: "Без названия"
        holder.amount.text = payment.amount?.let { "$it ₽" } ?: "Сумма не указана"
        holder.date.text =
            payment.created?.let { TextFormatter.longDateToString(it) } ?: "Дата не указана"
    }
}