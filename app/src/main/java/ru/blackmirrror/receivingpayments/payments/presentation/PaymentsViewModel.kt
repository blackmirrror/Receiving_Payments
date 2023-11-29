package ru.blackmirrror.receivingpayments.payments.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.blackmirrror.receivingpayments.payments.domain.models.Payment
import ru.blackmirrror.receivingpayments.payments.domain.usecases.GetListPaymentsUseCase

class PaymentsViewModel(private val getListPaymentsUseCase: GetListPaymentsUseCase) : ViewModel() {
    private val _payments = MutableLiveData<List<Payment>>()
    val payments: LiveData<List<Payment>> = _payments

    fun getPayments(token: String) {
        viewModelScope.launch {
            val response = getListPaymentsUseCase.execute(token)
            _payments.postValue(response)
        }
    }
}