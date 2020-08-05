package com.heads.thinking.funnytests.item

import android.view.View
import androidx.databinding.ObservableField
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.Util
import com.heads.thinking.funnytests.databinding.ItemAnswerBinding
import com.heads.thinking.funnytests.model.Answer
import com.xwray.groupie.viewbinding.BindableItem

class AnswerItem(val answer: Answer): BindableItem<ItemAnswerBinding>() {
    var checked = ObservableField<Boolean>(false)
    val color = Util.randomLightColor()

    override fun getLayout(): Int = R.layout.item_answer

    override fun bind(viewBinding: ItemAnswerBinding, position: Int) {
        viewBinding.item = this
    }

    override fun initializeViewBinding(view: View): ItemAnswerBinding = ItemAnswerBinding.bind(view)
}