package ru.blackmirrror.receivingpayments.authorization.domain.models


data class Shell (
    var success  : String?   = null,
    var responseToken : Token? = Token()
)

data class Token (
    var token : String? = null
)