package com.heads.thinking.funnytests.di.mvvm

import androidx.lifecycle.ViewModel
import com.heads.thinking.funnytests.di.qualifier.ViewModelKey
import com.heads.thinking.funnytests.mvp.test.SimpleTestViewModel
import com.heads.thinking.funnytests.mvp.test.TestViewModel
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
}