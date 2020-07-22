package com.heads.thinking.funnytests.di.mvvm

import androidx.lifecycle.ViewModel
import com.heads.thinking.funnytests.di.qualifier.ViewModelKey
import com.heads.thinking.funnytests.mvvm.test.SimpleTestViewModel
import com.heads.thinking.funnytests.mvvm.test.TestPlayerViewModel
import com.heads.thinking.funnytests.mvvm.test.TestResultViewModel
import com.heads.thinking.funnytests.mvvm.test.TestViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SimpleTestViewModel::class)
    abstract fun bindSimpleTestViewModel(simpleTestViewModel: SimpleTestViewModel) : ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(TestViewModel::class)
    abstract fun bindTestViewModel(testViewModel: TestViewModel) : ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(TestPlayerViewModel::class)
    abstract fun bindTestPlayerViewModel(testPlayerViewModel: TestPlayerViewModel) : ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(TestResultViewModel::class)
    abstract fun bindTestResultViewModel(testResultViewModel: TestResultViewModel) : ViewModel
}