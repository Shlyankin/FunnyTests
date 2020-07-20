package com.heads.thinking.funnytests.adapter

import android.view.View
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.databinding.ItemAnswerBinding
import com.heads.thinking.funnytests.model.Answer
import com.xwray.groupie.viewbinding.BindableItem

class AnswerItem(val answer: Answer): BindableItem<ItemAnswerBinding>() {
    var checked = false

    override fun getLayout(): Int = R.layout.item_answer

    override fun bind(viewBinding: ItemAnswerBinding, position: Int) {
        viewBinding.answer = this
    }

    override fun initializeViewBinding(view: View): ItemAnswerBinding = ItemAnswerBinding.bind(view)
}