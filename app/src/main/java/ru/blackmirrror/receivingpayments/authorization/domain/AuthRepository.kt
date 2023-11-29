package ru.blackmirrror.receivingpayments.authorization.domain

interface AuthRepository {
    suspend fun login(login: String, password: String): String?
}