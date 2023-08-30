package com.thunpisit.playground.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.thunpisit.playground.databinding.ActivityPhotoPickerBinding

class PhotoPickerActivity : AppCompatActivity() {

    private val binding: ActivityPhotoPickerBinding by lazy {
        ActivityPhotoPickerBinding.inflate(layoutInflater)
    }
    private val launcher = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        binding.tvTitle.text = "Uri : ${uri.toString()}"
        Glide.with(this).load(uri).into(binding.ivIcon)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnChooseImage.setOnClickListener {
            chooseImageFile()
        }
    }

    private fun chooseImageFile() {
        val request = PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
        launcher.launch(request)
    }
}