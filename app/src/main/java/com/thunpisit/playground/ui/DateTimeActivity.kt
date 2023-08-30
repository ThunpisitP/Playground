package com.thunpisit.playground.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thunpisit.playground.databinding.ActivityDateTimeBinding
import com.thunpisit.playground.utils.observe
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

class DateTimeActivity : AppCompatActivity() {

    @Inject private var viewModel = DateTimeViewModel()

    private val binding: ActivityDateTimeBinding by lazy {
        ActivityDateTimeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel()
        setContentView(binding.root)
        setConvertAction()
    }

    private fun observeViewModel() {
        observe(viewModel.convertedDate) {
            binding.tvConvertedDate.text = it
        }
    }

    private fun setConvertAction() {
        binding.btnConvert.setOnClickListener {
            val inputText = binding.edtConvertDate.text.toString()
            viewModel.convertInputTextToDate(inputText)
        }
    }

}