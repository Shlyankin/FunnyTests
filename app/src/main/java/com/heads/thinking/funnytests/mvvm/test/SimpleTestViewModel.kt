package com.heads.thinking.funnytests.mvvm.test

import android.util.Log
import androidx.lifecycle.ViewModel
import com.heads.thinking.funnytests.api.Api
import com.heads.thinking.funnytests.item.TestItem
import com.heads.thinking.funnytests.model.Test
import com.heads.thinking.funnytests.navigation.Screens
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import io.reactivex.disposables.CompositeDisposable
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SimpleTestViewModel @Inject constructor(val api: Api, val router: Router): ViewModel() {

    public val adapter = GroupAdapter<GroupieViewHolder>()
    private var mDisposable = CompositeDisposable()

    init {
        adapter.setOnItemClickListener { item, view ->
            if (item is TestItem) {
                router.navigateTo(Screens.TestScreen(item.test))
            }
        }
    }

    fun loadTests() {
        mDisposable.addAll(
            api.getTests().subscribe ({ tests: List<Test> ->
                adapter.clear()
                tests.forEach {
                    adapter.add(TestItem(it))
                }
            }, {
                Log.e("Custom", "Firebase Error: ${it.localizedMessage}")
            })
        )
    }

    override fun onCleared() {
        super.onCleared()
        mDisposable.dispose()
    }
}