package com.thunpisit.playground.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thunpisit.playground.databinding.ActivityDateTimeBinding
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class DateTimeActivity : AppCompatActivity() {
    private val binding: ActivityDateTimeBinding by lazy {
        ActivityDateTimeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setConvertAction()
    }

    private fun setConvertAction() {
        binding.btnConvert.setOnClickListener {
            binding.tvConvertedDate.text = convertedDate()
        }
    }

    private fun convertedDate(): String {
        return convertLongToTime(binding.edtConvertDate.text.toString())
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