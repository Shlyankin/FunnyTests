package com.heads.thinking.funnytests.di.component

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.heads.thinking.funnytests.App
import com.heads.thinking.funnytests.api.Api
import com.heads.thinking.funnytests.di.module.ApiModule
import com.heads.thinking.funnytests.di.module.AppModule
import com.heads.thinking.funnytests.di.module.NavigationModule
import com.heads.thinking.funnytests.di.qualifier.AppContext
import com.heads.thinking.funnytests.di.scope.AppScope
import dagger.Component
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton


@AppScope
@Singleton
@Component(modules = [AppModule::class, ApiModule::class, NavigationModule::class])
interface AppComponent {

    fun router(): Router
    fun auth(): FirebaseAuth
    fun user(): FirebaseUser?
    fun navigationHolder(): NavigatorHolder
    fun realApi(): Api

    @AppContext
    fun context(): Context

    fun inject(app: App)

}