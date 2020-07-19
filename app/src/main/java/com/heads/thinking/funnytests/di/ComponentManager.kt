package com.heads.thinking.funnytests.di

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.heads.thinking.funnytests.App
import com.heads.thinking.funnytests.di.component.*
import com.heads.thinking.funnytests.di.module.ActivityModule
import com.heads.thinking.funnytests.di.module.AppModule
import com.heads.thinking.funnytests.di.module.FragmentModule
import java.util.*

class ComponentManager private constructor() {
    private lateinit var appComponent: AppComponent
    private val activityComponentMap: MutableMap<String, ActivityComponent?> =
        HashMap<String, ActivityComponent?>()
    private val fragmentComponentMap: MutableMap<String, FragmentComponent?> =
        HashMap<String, FragmentComponent?>()

    fun init(application: Application) {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .build();

        appComponent.inject(application as App)
    }

    /**
     * For Services, Broadcasts, etc.
     */
    fun getAppComponent(): AppComponent? {
        return appComponent
    }

    /**
     * For Activities
     */
    fun getActivityComponent(activity: Activity): ActivityComponent {
        val key = getKey(activity)
        var activityComponent: ActivityComponent? = activityComponentMap[key]
        if (activityComponent == null) {
            activityComponent = createNewActivityComponent(activity)
            activityComponentMap[key] = activityComponent
       }
        return activityComponent
    }

    fun removeActivityComponent(activity: Activity?) {
        activityComponentMap.remove(getKey(activity))
    }

    fun getFragmentComponent(fragment: Fragment): FragmentComponent {
        val activity: Activity = fragment.activity ?: throw KotlinNullPointerException("DI Error. Fragments activity is null")
        val args = fragment.arguments
        val key_suffix = if (args != null) "" + args.hashCode() else ""
        val key = getKey(activity) + key_suffix
        val activityComponent: ActivityComponent? = getActivityComponent(activity)
        fragmentComponentMap[key]?.let {
            return it
        }
        val fragmentComponent: FragmentComponent = DaggerFragmentComponent.builder()
            .activityComponent(activityComponent)
            .fragmentModule(FragmentModule(fragment))
            .build()
        fragmentComponentMap[key] = fragmentComponent
        return fragmentComponent
    }

    private fun createNewActivityComponent(activity: Activity): ActivityComponent {
        return DaggerActivityComponent.builder()
            .appComponent(appComponent)
            .activityModule(ActivityModule(activity))
            .build()
    }

    private fun getKey(activity: Activity?): String {
        return activity!!.localClassName
    }

    companion object {
        val instance: ComponentManager = ComponentManager()
    }
}