package com.heads.thinking.funnytests.item

import android.view.View
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.databinding.ItemResultBinding
import com.heads.thinking.funnytests.model.ResultSection
import com.heads.thinking.funnytests.model.TestResult
import com.xwray.groupie.viewbinding.BindableItem

class ResultItem(val testResult: Pair<ResultSection, TestResult>): BindableItem<ItemResultBinding>() {
    override fun getLayout(): Int = R.layout.item_result

    override fun bind(viewBinding: ItemResultBinding, position: Int) {
        viewBinding.item = this
    }

    override fun initializeViewBinding(view: View): ItemResultBinding = ItemResultBinding.bind(view)

}