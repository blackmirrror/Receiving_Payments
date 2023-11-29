package ru.blackmirrror.receivingpayments.authorization.data

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import ru.blackmirrror.receivingpayments.authorization.data.models.RequestLogin
import ru.blackmirrror.receivingpayments.authorization.data.models.ResponseShell

interface AuthService {

    @POST("login")
    suspend fun login(
        @Header("app-key") appKey: String,
        @Header("v") v: String,
        @Body request: RequestLogin
    ): ResponseShell
}