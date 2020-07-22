package com.heads.thinking.funnytests.di.component

import android.content.Context
import com.heads.thinking.funnytests.di.module.FragmentModule
import com.heads.thinking.funnytests.di.mvvm.ViewModelModule
import com.heads.thinking.funnytests.di.scope.FragmentScope
import com.heads.thinking.funnytests.ui.settings.SettingsFragment
import com.heads.thinking.funnytests.ui.test.SimpleTestsListFragment
import com.heads.thinking.funnytests.ui.test.TestFragment
import com.heads.thinking.funnytests.ui.test.TestPlayerFragment
import com.heads.thinking.funnytests.ui.test.TestResultFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [ActivityComponent::class], modules = [FragmentModule::class, ViewModelModule::class])
interface FragmentComponent {

    fun context(): Context

    fun inject(fragment: SimpleTestsListFragment)

    fun inject(fragment: SettingsFragment)

    fun inject(fragment: TestFragment)

    fun inject(fragment: TestPlayerFragment)

    fun inject(fragment: TestResultFragment)
}