package com.heads.thinking.funnytests.di.mvvm

import androidx.lifecycle.ViewModel
import com.heads.thinking.funnytests.di.qualifier.ViewModelKey
import com.heads.thinking.funnytests.mvvm.main.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ActivityViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

}