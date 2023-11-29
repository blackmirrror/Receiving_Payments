package ru.blackmirrror.receivingpayments.payments.domain.repositories

import ru.blackmirrror.receivingpayments.payments.domain.models.Payment

interface PaymentsRepository {
    suspend fun getPayments(token: String): List<Payment>
}