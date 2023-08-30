package com.thunpisit.playground.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thunpisit.playground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnCameraX.setOnClickListener {
            startActivity(Intent(this, CameraXActivity::class.java))
        }
        binding.btnPhotoPicker.setOnClickListener {
            startActivity(Intent(this, PhotoPickerActivity::class.java))
        }
        binding.btnDateTime.setOnClickListener {
            startActivity(Intent(this, DateTimeActivity::class.java))
        }
        binding.btnUser.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))
        }
    }

}
