//package ru.blackmirrror.receivingpayments.payments.data.repositories
//
//import ru.blackmirrror.receivingpayments.payments.data.PaymentsService
//import ru.blackmirrror.receivingpayments.payments.data.models.ResponsePayment
//import ru.blackmirrror.receivingpayments.payments.domain.models.Payment
//import ru.blackmirrror.receivingpayments.payments.domain.repositories.PaymentsRepository
//
//class PaymentsRepositoryImpl(private val service: PaymentsService): PaymentsRepository {
//    override suspend fun getPayments(token: String): List<Payment> {
//        val list = service.getPayments(APPKEY, V, token).response
//        return list.map { ResponsePayment.dataToDomain(it) }
//    }
//
//    companion object {
//        private const val APPKEY = "12345"
//        private const val V = "1"
//    }
//}

package ru.blackmirrror.receivingpayments.payments.data.repositories

import ru.blackmirrror.receivingpayments.payments.data.PaymentsService
import ru.blackmirrror.receivingpayments.payments.data.models.ResponsePayment
import ru.blackmirrror.receivingpayments.payments.domain.models.Payment
import ru.blackmirrror.receivingpayments.payments.domain.repositories.PaymentsRepository

class PaymentsRepositoryImpl(private val service: PaymentsService) : PaymentsRepository {
    override suspend fun getPayments(token: String): List<Payment> {
        val response = service.getPayments(APPKEY, V, token)
        val list = response.body()?.response.orEmpty()
        return list.map { ResponsePayment.dataToDomain(it) }

    }

    companion object {
        private const val APPKEY = "12345"
        private const val V = "1"
    }
}
