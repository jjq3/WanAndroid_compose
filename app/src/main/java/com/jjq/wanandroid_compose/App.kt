package com.jjq.wanandroid_compose

import android.app.Application
import android.content.Context

class App : Application() {

    init {
        instance = requireNotNull(this)
    }

    companion object {
        private lateinit var instance: App

        fun applicationContext(): Context {
            return instance
        }
    }

}