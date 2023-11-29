package ru.blackmirrror.receivingpayments.payments.presentation.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class TextFormatter {
    companion object {
        fun longDateToString(timestamp: Long): String {
            val date = Date(timestamp * 1000)
            val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            val str = sdf.format(date)
            return str
        }
    }
}