package ru.blackmirrror.receivingpayments.payments.data.models

import com.google.gson.annotations.SerializedName
import ru.blackmirrror.receivingpayments.payments.domain.models.Payment

data class ResponseListPayments (
    @SerializedName("success"  ) var success  : String?                    = null,
    @SerializedName("response" ) var response : List<ResponsePayment> = arrayListOf()
)

data class ResponsePayment (
    @SerializedName("id"      ) var id      : Int?    = null,
    @SerializedName("title"   ) var title   : String? = null,
    @SerializedName("amount"  ) var amount  : Double?    = null,
    @SerializedName("created" ) var created : Long?    = null
) {
    companion object {
        fun dataToDomain(responsePayment: ResponsePayment): Payment {
            return Payment(
                id = responsePayment.id,
                title = responsePayment.title,
                amount = responsePayment.amount,
                created = responsePayment.created
            )
        }
    }
}