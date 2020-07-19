package com.heads.thinking.funnytests.di.module

import android.app.Application
import android.content.Context
import com.heads.thinking.funnytests.di.qualifier.AppContext
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application) {
    @Provides
    @AppContext
    fun providesContext(): Context {
        return application.applicationContext
    }

}