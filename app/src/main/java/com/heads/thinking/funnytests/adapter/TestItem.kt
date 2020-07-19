package com.heads.thinking.funnytests.adapter

import android.view.View
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.databinding.TestItemBinding
import com.heads.thinking.funnytests.model.Test
import com.xwray.groupie.Item
import com.xwray.groupie.viewbinding.BindableItem
import kotlinx.android.synthetic.main.test_item.view.*

class TestItem(val test:Test): BindableItem<TestItemBinding>() {
    override fun getLayout() = R.layout.test_item

    override fun bind(viewBinding: TestItemBinding, position: Int) {
        viewBinding.test = test
    }

    override fun initializeViewBinding(view: View): TestItemBinding = TestItemBinding.bind(view)

}