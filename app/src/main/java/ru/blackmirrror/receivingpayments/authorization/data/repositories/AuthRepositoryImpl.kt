package ru.blackmirrror.receivingpayments.authorization.data.repositories

import ru.blackmirrror.receivingpayments.authorization.data.AuthService
import ru.blackmirrror.receivingpayments.authorization.data.models.RequestLogin
import ru.blackmirrror.receivingpayments.authorization.data.models.ResponseToken.Companion.dataToDomain
import ru.blackmirrror.receivingpayments.authorization.domain.AuthRepository

class AuthRepositoryImpl(private val service: AuthService): AuthRepository {
    override suspend fun login(login: String, password: String): String? {
        val requestLogin = RequestLogin(login, password)
        val token = service.login(APPKEY, V, requestLogin).body()?.responseToken
        return token?.let { dataToDomain(it).token }
    }

    companion object {
        private const val APPKEY = "12345"
        private const val V = "1"
    }
}