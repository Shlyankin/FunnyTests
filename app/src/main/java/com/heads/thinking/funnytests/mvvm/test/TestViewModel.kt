package com.heads.thinking.funnytests.mvvm.test

import android.view.View
import androidx.lifecycle.ViewModel
import com.heads.thinking.funnytests.api.Api
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
        router.navigateTo(Screens.TestPlayerScreen(test))
    }

    fun startTest(view: View) {
        startTest()
    }
}