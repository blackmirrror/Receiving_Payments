package ru.blackmirrror.receivingpayments.app.di

import org.koin.dsl.module
import ru.blackmirrror.receivingpayments.authorization.data.repositories.AuthRepositoryImpl
import ru.blackmirrror.receivingpayments.authorization.domain.usecases.LoginUseCase
import ru.blackmirrror.receivingpayments.payments.domain.usecases.GetListPaymentsUseCase

var domainModule = module {

    factory {
        LoginUseCase(repository = get())
    }

    factory {
        GetListPaymentsUseCase(repository = get())
    }
}