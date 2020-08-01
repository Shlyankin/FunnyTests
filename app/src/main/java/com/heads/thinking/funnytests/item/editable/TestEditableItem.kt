package com.heads.thinking.funnytests.item.editable

import android.view.View
import androidx.databinding.ObservableField
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.databinding.ItemEditableTestBinding
import com.heads.thinking.funnytests.model.Answer
import com.xwray.groupie.viewbinding.BindableItem

class TestEditableItem(val onImageSetListener: View.OnClickListener): BindableItem<ItemEditableTestBinding>() {
    val test = ObservableField(Answer())

    override fun getLayout() = R.layout.item_editable_test

    override fun bind(viewBinding: ItemEditableTestBinding, position: Int) {
        viewBinding.test = this
    }

    override fun initializeViewBinding(view: View): ItemEditableTestBinding = ItemEditableTestBinding.bind(view)

}