package ru.blackmirrror.receivingpayments.payments.domain.models

import com.google.gson.annotations.SerializedName

data class Payment (
    @SerializedName("id"      ) var id      : Int?    = null,
    @SerializedName("title"   ) var title   : String? = null,
    @SerializedName("amount"  ) var amount  : Double?    = null,
    @SerializedName("created" ) var created : Long?    = null
)