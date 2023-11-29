package ru.blackmirrror.receivingpayments.app.di

import org.koin.dsl.module
import ru.blackmirrror.receivingpayments.authorization.data.repositories.AuthRepositoryImpl
import ru.blackmirrror.receivingpayments.authorization.domain.usecases.LoginUseCase

var domainModule = module {

    factory {
        LoginUseCase(authRepository = get())
    }
}