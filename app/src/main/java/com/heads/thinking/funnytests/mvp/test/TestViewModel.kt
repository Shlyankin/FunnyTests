package com.heads.thinking.funnytests.mvp.test

import android.view.View
import androidx.lifecycle.ViewModel
import com.heads.thinking.funnytests.Api
import com.heads.thinking.funnytests.model.Test
import com.heads.thinking.funnytests.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class TestViewModel @Inject constructor(val api: Api, val router: Router): ViewModel() {
    var isInitialized = false
    lateinit var test: Test

    fun initViewModel(test: Test) {
        this.test = test
        isInitialized = true
    }

    fun startTest() {
        router.navigateTo(Screens.TestPlayerScreen)
    }

    fun startTest(view: View) {
        router.navigateTo(Screens.TestPlayerScreen)
    }
}