package com.heads.thinking.funnytests.di.module

import com.heads.thinking.funnytests.api.Api
import com.heads.thinking.funnytests.api.RealApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideApi(): Api = RealApi()

}