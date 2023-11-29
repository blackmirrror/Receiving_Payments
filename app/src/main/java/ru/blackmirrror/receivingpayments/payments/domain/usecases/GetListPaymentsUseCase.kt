package ru.blackmirrror.receivingpayments.payments.domain.usecases

import ru.blackmirrror.receivingpayments.payments.domain.models.Payment
import ru.blackmirrror.receivingpayments.payments.domain.repositories.PaymentsRepository

class GetListPaymentsUseCase(private val repository: PaymentsRepository) {
    suspend fun execute(token: String): List<Payment> {
        return repository.getPayments(token)
    }
}