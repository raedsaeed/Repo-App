package com.example.unioncoop

import android.app.Application
import com.example.unioncoop.di.ApplicationComponent
import com.example.unioncoop.di.DaggerApplicationComponent

/**
 * Created by Raed Saeed on 30/09/2020.
 */
class BaseApplication : Application() {
    lateinit var appComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent
            .builder()
            .application(this)
            .create()
    }
}