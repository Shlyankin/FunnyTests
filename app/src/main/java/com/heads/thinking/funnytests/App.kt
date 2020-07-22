package com.heads.thinking.funnytests

import android.app.Application
import com.heads.thinking.funnytests.di.ComponentManager

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        ComponentManager.instance.init(this)
    }

}