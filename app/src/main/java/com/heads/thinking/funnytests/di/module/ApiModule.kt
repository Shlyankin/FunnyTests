package com.heads.thinking.funnytests.di.module

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.heads.thinking.funnytests.api.Api
import com.heads.thinking.funnytests.api.FirebaseApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideApi(): Api = FirebaseApi()

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideUser(firebaseAuth: FirebaseAuth): FirebaseUser? = firebaseAuth.currentUser
}