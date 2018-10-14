package com.alexandre.skiresort.application

import android.app.Application

class SkiResortApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        InitializeDebug().init(this)
    }
}