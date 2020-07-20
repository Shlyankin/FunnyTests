package com.heads.thinking.funnytests.di.component

import android.content.Context
import com.heads.thinking.funnytests.Api
import com.heads.thinking.funnytests.di.module.ActivityModule
import com.heads.thinking.funnytests.di.mvvm.ActivityViewModelModule
import com.heads.thinking.funnytests.di.scope.ActivityScope
import com.heads.thinking.funnytests.ui.main.MainActivity
import dagger.Component
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class, ActivityViewModelModule::class])
interface ActivityComponent {

    fun router(): Router
    fun navigationHolder(): NavigatorHolder
    fun realApi(): Api
    fun context(): Context?

    fun inject(activity: MainActivity)
}