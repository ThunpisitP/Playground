package com.thunpisit.playground.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mindorks.retrofit.coroutines.data.model.User

class UserViewModel : ViewModel() {

    val users: LiveData<List<User>>
        get() = _users

    private val _users = MutableLiveData<List<User>>()

    fun getUserList() {
        _users.postValue(
            listOf(
                User(
                    avatar = "https://dummyimage.com/100x100.png/5fa2dd/ffffff",
                    id = "1",
                    name = "T",
                    email = "R@R.com"
                ),
                User(
                    avatar = "https://dummyimage.com/100x100.png/5fa2dd/ffffff",
                    id = "1",
                    name = "T",
                    email = "R@R.com"
                ),
                User(
                    avatar = "https://dummyimage.com/100x100.png/5fa2dd/ffffff",
                    id = "1",
                    name = "T",
                    email = "R@R.com"
                )
            )
        )
    }

}