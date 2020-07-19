package com.heads.thinking.funnytests.di.mvvm

import androidx.lifecycle.ViewModel
import com.heads.thinking.funnytests.di.qualifier.ViewModelKey
import com.heads.thinking.funnytests.mvp.main.MainActivityViewModel
import com.heads.thinking.funnytests.mvp.test.SimpleTestViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel) : ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindSimpleTestViewModel(simpleTestViewModel: SimpleTestViewModel) : ViewModel
}