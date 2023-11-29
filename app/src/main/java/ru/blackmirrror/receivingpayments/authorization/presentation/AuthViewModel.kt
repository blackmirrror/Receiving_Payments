package ru.blackmirrror.receivingpayments.authorization.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.blackmirrror.receivingpayments.authorization.domain.usecases.LoginUseCase

class AuthViewModel( private val loginUseCase: LoginUseCase): ViewModel() {

    private val _token = MutableLiveData<String?>()
    val token: LiveData<String?> = _token

    fun getToken(login: String, password: String) {
        viewModelScope.launch {
            val value = loginUseCase.execute(login, password)
            _token.postValue(value)
        }
    }
}