package com.byjus.news

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.DebugTree

@HiltAndroidApp
class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // Plant timber
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}