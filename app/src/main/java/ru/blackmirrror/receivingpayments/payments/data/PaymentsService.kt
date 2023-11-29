package ru.blackmirrror.receivingpayments.payments.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import ru.blackmirrror.receivingpayments.payments.data.models.ResponseListPayments

interface PaymentsService {

    @GET("payments")
    suspend fun getPayments(
        @Header("app-key") appKey: String,
        @Header("v") v: String,
        @Header("token") token: String
    ): Response<ResponseListPayments>
}