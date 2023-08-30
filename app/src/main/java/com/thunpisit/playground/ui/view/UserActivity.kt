package com.thunpisit.playground.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thunpisit.playground.databinding.ActivityDateTimeBinding
import com.thunpisit.playground.databinding.ActivityUserBinding
import com.thunpisit.playground.ui.adapter.UserAdapter
import com.thunpisit.playground.ui.viewmodel.UserViewModel
import com.thunpisit.playground.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserActivity : AppCompatActivity() {

    private val binding: ActivityUserBinding by lazy {
        ActivityUserBinding.inflate(layoutInflater)
    }
    @Inject private val viewModel = UserViewModel()

    private val adapter: UserAdapter by lazy {
        UserAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observeViewModel()
        initView()
        viewModel.getUserList()
    }

    private fun initView() {
        binding.rvUser.adapter = adapter
    }

    private fun observeViewModel() {
        observe(viewModel.users) {
            adapter.submitList(it)
        }
    }

}