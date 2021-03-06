package com.heads.thinking.funnytests.navigation

import com.heads.thinking.funnytests.model.ResultSection
import com.heads.thinking.funnytests.model.Test
import com.heads.thinking.funnytests.model.TestResult
import com.heads.thinking.funnytests.ui.settings.SettingsFragment
import com.heads.thinking.funnytests.ui.test.SimpleTestsListFragment
import com.heads.thinking.funnytests.ui.test.TestPlayerFragment
import com.heads.thinking.funnytests.ui.test.TestResultFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    object SimpleTestListScreen: SupportAppScreen() {
        override fun getFragment() = SimpleTestsListFragment.newInstance()
    }

    data class TestResultScreen(val test: Test, val testResult: Map<ResultSection, TestResult>): SupportAppScreen() {
        override fun getFragment() = TestResultFragment.newInstance(test, testResult)
    }

    data class TestPlayerScreen(val test: Test): SupportAppScreen() {
        override fun getFragment() = TestPlayerFragment.newInstance(test)
    }

    object SettingsScreen: SupportAppScreen() {
        override fun getFragment() = SettingsFragment.newInstance()
    }
}