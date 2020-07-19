package com.heads.thinking.funnytests.di.component

import android.content.Context
import com.heads.thinking.funnytests.Api
import com.heads.thinking.funnytests.RealApi
import com.heads.thinking.funnytests.di.module.ActivityModule
import com.heads.thinking.funnytests.di.module.ApiModule
import com.heads.thinking.funnytests.di.module.NavigationModule
import com.heads.thinking.funnytests.di.qualifier.AppContext
import com.heads.thinking.funnytests.di.scope.ActivityScope
import com.heads.thinking.funnytests.ui.main.MainActivity
import dagger.Component
import dagger.Provides
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun router(): Router
    fun navigationHolder(): NavigatorHolder
    fun realApi(): Api
    fun context(): Context?

    fun inject(activity: MainActivity)
}