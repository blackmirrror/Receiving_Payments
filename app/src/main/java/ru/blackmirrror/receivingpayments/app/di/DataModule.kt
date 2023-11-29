package ru.blackmirrror.receivingpayments.app.di

import org.koin.dsl.module
import ru.blackmirrror.receivingpayments.app.data.ApiFactory
import ru.blackmirrror.receivingpayments.authorization.data.repositories.AuthRepositoryImpl
import ru.blackmirrror.receivingpayments.authorization.domain.AuthRepository

var dataModule = module {

    single<AuthRepository> {
        AuthRepositoryImpl(service = get())
    }

    single {
        ApiFactory.createAuthService()
    }
}