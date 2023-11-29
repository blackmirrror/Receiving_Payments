package ru.blackmirrror.receivingpayments.authorization.domain.usecases

import ru.blackmirrror.receivingpayments.authorization.domain.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend fun execute(login: String, password: String): String? {
        return repository.login(login, password)
    }
}