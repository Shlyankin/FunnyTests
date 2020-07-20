package com.heads.thinking.funnytests.navigation

import com.heads.thinking.funnytests.model.Test
import com.heads.thinking.funnytests.ui.main.SimpleTestsListFragment
import com.heads.thinking.funnytests.ui.settings.SettingsFragment
import com.heads.thinking.funnytests.ui.test.TestFragment
import com.heads.thinking.funnytests.ui.test.TestPlayerFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    object SimpleTestListScreen: SupportAppScreen() {
        override fun getFragment() = SimpleTestsListFragment.newInstance()
    }

    data class TestScreen(val test: Test): SupportAppScreen() {
        override fun getFragment() = TestFragment.newInstance(test)
    }

    object TestPlayerScreen: SupportAppScreen() {
        override fun getFragment() = TestPlayerFragment.newInstance()
    }

    object SettingsScreen: SupportAppScreen() {
        override fun getFragment() = SettingsFragment.newInstance()
    }
}