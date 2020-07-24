package com.heads.thinking.funnytests.mvvm.test

import android.view.View
import androidx.lifecycle.ViewModel
import com.heads.thinking.funnytests.api.Api
import com.heads.thinking.funnytests.item.ResultItem
import com.heads.thinking.funnytests.model.ResultSection
import com.heads.thinking.funnytests.model.Test
import com.heads.thinking.funnytests.model.TestResult
import com.heads.thinking.funnytests.navigation.Screens
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class TestResultViewModel@Inject constructor(val api: Api, val router: Router): ViewModel() {

    public val adapter = GroupAdapter<GroupieViewHolder>()

    var isInitialized = false
    lateinit var testResult: Map<ResultSection, TestResult>
    lateinit var test: Test

    fun initViewModel(test: Test, resultsMap: Map<ResultSection, TestResult>) {
        this.test = test
        this.testResult = resultsMap
        isInitialized = true
        testResult.forEach {
            adapter.add(ResultItem(it.toPair()))
        }
    }

    fun finishTest() {
        router.newRootScreen(Screens.SimpleTestListScreen)
    }

    fun finishTest(view: View) {
        finishTest()
    }


}
