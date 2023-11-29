package ru.blackmirrror.receivingpayments.app.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.blackmirrror.receivingpayments.authorization.presentation.AuthViewModel

var appModule = module {

    viewModel {
        AuthViewModel(loginUseCase = get())
    }
}