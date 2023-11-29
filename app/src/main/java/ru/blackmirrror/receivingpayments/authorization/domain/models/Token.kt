package ru.blackmirrror.receivingpayments.authorization.domain.models


data class Shell (
    var success  : String?   = null,
    var response : Token? = Token()
)

data class Token (
    var token : String? = null
)