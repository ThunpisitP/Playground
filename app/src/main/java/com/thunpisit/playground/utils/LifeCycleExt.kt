package com.thunpisit.playground.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this) { action(it) }
}

fun <T> LifecycleOwner.observe(vararg liveDatas: LiveData<T> = arrayOf(), action: (t: T) -> Unit) {
    liveDatas.forEach {  liveData ->
        liveData.observe(this) { action(it) }
    }
}