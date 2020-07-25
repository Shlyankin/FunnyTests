package com.heads.thinking.funnytests.mvvm.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.heads.thinking.funnytests.api.Api
import com.heads.thinking.funnytests.navigation.Screens
import durdinapps.rxfirebase2.RxFirebaseAuth
import io.reactivex.disposables.CompositeDisposable
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val api: Api, val router: Router,
                                                val firebaseAuth: FirebaseAuth, var user: FirebaseUser?): ViewModel() {
    private val mDisposable = CompositeDisposable()
    init {
        showMainScreen()
        if (user == null) {
            mDisposable.add(
                RxFirebaseAuth.signInAnonymously(firebaseAuth).subscribe({
                    user = it.user
                }, {
                    Log.e("Custom", "signInAnonError: ${it.localizedMessage}")
                })
            )
        }
    }

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

    override fun onCleared() {
        super.onCleared()
        mDisposable.dispose()
    }
}