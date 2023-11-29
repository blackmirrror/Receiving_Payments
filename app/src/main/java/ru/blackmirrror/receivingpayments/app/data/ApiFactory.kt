package ru.blackmirrror.receivingpayments.app.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.blackmirrror.receivingpayments.authorization.data.AuthService

object ApiFactory {

    private const val BASE_URL = "https://easypay.world/api-test/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(makeLoggingInterceptor())
        .build()

    private fun makeLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun createAuthService(): AuthService {
        return retrofit.create(AuthService::class.java)
    }
}