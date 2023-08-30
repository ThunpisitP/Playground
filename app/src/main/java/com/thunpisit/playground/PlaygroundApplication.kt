package com.thunpisit.playground

import android.app.Application
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class PlaygroundApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }

}