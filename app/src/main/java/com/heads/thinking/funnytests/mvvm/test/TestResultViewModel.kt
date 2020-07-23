package com.heads.thinking.funnytests.mvvm.test

import android.view.View
import androidx.lifecycle.ViewModel
import com.heads.thinking.funnytests.api.Api
import com.heads.thinking.funnytests.model.Test
import com.heads.thinking.funnytests.model.TestResult
import com.heads.thinking.funnytests.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class TestResultViewModel@Inject constructor(val api: Api, val router: Router): ViewModel() {

    var isInitialized = false
    lateinit var testResult: TestResult
    lateinit var test: Test

    fun initViewModel(test: Test, result: TestResult) {
        this.test = test
        this.testResult = result
        isInitialized = true
    }

    fun finishTest() {
        router.newRootScreen(Screens.SimpleTestListScreen)
    }

    fun finishTest(view: View) {
        finishTest()
    }


}
