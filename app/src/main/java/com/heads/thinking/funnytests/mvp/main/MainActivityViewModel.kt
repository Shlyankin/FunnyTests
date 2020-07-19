package com.heads.thinking.funnytests.mvp.main

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.heads.thinking.funnytests.Api
import com.heads.thinking.funnytests.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val api: Api, val router: Router): ViewModel() {

    fun showMainScreen() {
        router.newRootScreen(Screens.SimpleTestListScreen)
    }

    fun showUserRegistrationScreen() {
        // TODO: registration fragment show
    }

    fun isUserSignIn(user: FirebaseUser?) {
        if (user == null) {
            // TODO: activity create SignInFragment
            showUserRegistrationScreen()
        } else {
            // TODO: user is already Sign in
            // TODO: get user token
            // TODO: then create TestsFragment with data
            showMainScreen()
        }
    }
}