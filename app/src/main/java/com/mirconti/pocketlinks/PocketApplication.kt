package com.mirconti.pocketlinks

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PocketApplication: Application() {

    companion object {
        lateinit var instance: PocketApplication

        fun getString(id: Int): String {
            return instance.getString(id)
        }
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
    }



}

