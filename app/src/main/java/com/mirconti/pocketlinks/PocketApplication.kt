package com.mirconti.pocketlinks

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PocketApplication: Application() {

    companion object {
        lateinit var instance: PocketApplication
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
    }

}

