package com.heads.thinking.funnytests.item.editable

import android.view.View
import androidx.databinding.ObservableField
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.databinding.ItemEditableAnswerBinding
import com.heads.thinking.funnytests.model.Answer
import com.xwray.groupie.viewbinding.BindableItem

class AnswerEditableItem(): BindableItem<ItemEditableAnswerBinding>() {
    var checked = ObservableField<Boolean>(false)
    val answer = ObservableField<Answer>(Answer())

    override fun getLayout(): Int = R.layout.item_editable_answer

    override fun initializeViewBinding(view: View): ItemEditableAnswerBinding = ItemEditableAnswerBinding.bind(view)

    override fun bind(viewBinding: ItemEditableAnswerBinding, position: Int) {
        viewBinding.item = this
    }
}