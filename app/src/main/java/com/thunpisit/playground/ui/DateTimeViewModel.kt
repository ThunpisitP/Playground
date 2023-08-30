package com.thunpisit.playground.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.AndroidEntryPoint
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

@AndroidEntryPoint
class DateTimeViewModel(): ViewModel() {

    val convertedDate: LiveData<String>
        get() = _convertedDate

    private val _convertedDate = MutableLiveData<String>()

    fun convertInputTextToDate(inputText: String) {
        _convertedDate.postValue(convertLongToTime(inputText))
    }

    private fun convertLongToTime(format: String = "yyyy.MM.dd HH:mm"): String {
        return try {
            val timeStamp = Instant.ofEpochMilli(Date().time).atZone(ZoneId.systemDefault()).toLocalDateTime()
            val formatter = DateTimeFormatter.ofPattern(format, Locale.US)
            timeStamp.format(formatter)
        } catch (e: Exception) {
            "Incorrect format"
        }
    }

}