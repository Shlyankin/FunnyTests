package com.heads.thinking.funnytests.navigation

import androidx.fragment.app.Fragment
import com.heads.thinking.funnytests.ui.main.SimpleTestsListFragment
import com.heads.thinking.funnytests.ui.settings.SettingsFragment
import com.heads.thinking.funnytests.ui.test.TestFragment
import com.heads.thinking.funnytests.ui.test.TestPlayerFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {
    object SimpleTestListScreen: SupportAppScreen() {
        override fun getFragment() = SimpleTestsListFragment.newInstance()
    }

    object TestScreen: SupportAppScreen() {
        override fun getFragment() = TestFragment.newInstance()
    }

    object TestPlayerScreen: SupportAppScreen() {
        override fun getFragment() = TestPlayerFragment.newInstance()
    }

    object SettingsScreen: SupportAppScreen() {
        override fun getFragment() = SettingsFragment.newInstance()
    }
}