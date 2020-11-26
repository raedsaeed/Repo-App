package com.example.unioncoop

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Raed Saeed on 30/09/2020.
 */
@HiltAndroidApp
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}