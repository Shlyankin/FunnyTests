package com.heads.thinking.funnytests.di.module

import android.app.Activity
import android.content.Context
import com.heads.thinking.funnytests.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {
    @Provides
    @ActivityScope
    fun provideContext(): Context {
        return activity
    }

}