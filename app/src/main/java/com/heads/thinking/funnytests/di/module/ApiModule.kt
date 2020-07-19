package com.heads.thinking.funnytests.di.module

import com.heads.thinking.funnytests.Api
import com.heads.thinking.funnytests.RealApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideApi(): Api = RealApi()

}