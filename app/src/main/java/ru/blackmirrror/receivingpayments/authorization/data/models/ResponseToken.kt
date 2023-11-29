package ru.blackmirrror.receivingpayments.authorization.data.models

import com.google.gson.annotations.SerializedName
import ru.blackmirrror.receivingpayments.authorization.domain.models.Shell
import ru.blackmirrror.receivingpayments.authorization.domain.models.Token

data class ResponseShell (
    @SerializedName("success"  ) var success  : String?   = null,
    @SerializedName("response" ) var responseToken : ResponseToken? = ResponseToken()
)

data class ResponseToken (
    @SerializedName("token" ) var token : String? = null
) {
    companion object {
        fun dataToDomain(responseToken: ResponseToken): Token {
            return Token(token = responseToken.token)
        }
    }
}