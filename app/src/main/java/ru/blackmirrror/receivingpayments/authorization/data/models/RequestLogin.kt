package ru.blackmirrror.receivingpayments.authorization.data.models

data class RequestLogin(
    val login: String,
    val password: String
)
