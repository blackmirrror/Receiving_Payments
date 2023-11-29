package ru.blackmirrror.receivingpayments.app.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.blackmirrror.receivingpayments.authorization.data.AuthService
import ru.blackmirrror.receivingpayments.payments.data.PaymentsService

object ApiFactory {

    private const val BASE_URL = "https://easypay.world/api-test/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(makeLoggingInterceptor())
        .build()

    private val gson: Gson = GsonBuilder()
        .registerTypeAdapter(object : TypeToken<Double?>() {}.type, DoubleTypeAdapterFactory())
        .create()

    private fun makeLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun createAuthService(): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    fun createPaymentsService(): PaymentsService {
        return retrofit.create(PaymentsService::class.java)
    }
}