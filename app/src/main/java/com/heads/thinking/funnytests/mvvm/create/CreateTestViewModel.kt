package com.heads.thinking.funnytests.mvvm.create

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.api.Api
import com.heads.thinking.funnytests.item.ButtonItem
import com.heads.thinking.funnytests.item.editable.ResultSectionEditableItem
import com.heads.thinking.funnytests.item.editable.TestEditableItem
import com.heads.thinking.funnytests.model.Test
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import com.xwray.groupie.groupiex.plusAssign
import io.reactivex.disposables.CompositeDisposable
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class CreateTestViewModel @Inject constructor(val api: Api, val context: Context, val router: Router): ViewModel() {
    val test = Test()
    private val mDisposable = CompositeDisposable()
    val adapter = GroupAdapter<GroupieViewHolder>()
    init {
        adapter.add(TestEditableItem(View.OnClickListener {
            // TODO: open images
        }))
        adapter += Section().apply {
            this.setHeader(ResultSectionEditableItem(View.OnClickListener {
                // TODO: open images
            }))
            this.setFooter(ButtonItem(context.getString(R.string.create_section)))
        }
    }

    fun createTest(view: View) {

    }

    fun getImage(): String {
        return "url"
    }

    override fun onCleared() {
        super.onCleared()
        mDisposable.dispose()
    }
}