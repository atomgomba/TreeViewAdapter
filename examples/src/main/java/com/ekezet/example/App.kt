package com.ekezet.example

import android.app.Application
import timber.log.Timber
import timber.log.Timber.plant

/**
 * @author kiri
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        plant(Timber.DebugTree())
    }
}
