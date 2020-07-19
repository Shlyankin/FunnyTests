package com.heads.thinking.funnytests.di.module

import androidx.fragment.app.Fragment
import com.heads.thinking.funnytests.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {
    @Provides
    @FragmentScope
    fun provideFragment(): Fragment {
        return fragment
    }

}