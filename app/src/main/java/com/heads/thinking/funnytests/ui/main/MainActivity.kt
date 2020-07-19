package com.heads.thinking.funnytests.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.di.ComponentManager
import com.heads.thinking.funnytests.mvp.main.MainActivityViewModel
import com.heads.thinking.funnytests.navigation.Screens
import durdinapps.rxfirebase2.RxFirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.*
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : FragmentActivity() {

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme) // change splash theme
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ComponentManager.instance.getActivityComponent(this).inject(this) // inject all objects

        // TODO: check sign in ...

        navigatorHolder.setNavigator(SupportAppNavigator(this, supportFragmentManager, mainFragment.id))

        mainActivityViewModel.showMainScreen()
    }
}
