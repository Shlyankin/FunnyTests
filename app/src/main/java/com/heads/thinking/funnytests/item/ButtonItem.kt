package com.heads.thinking.funnytests.item

import android.view.View
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.databinding.ItemButtonBinding
import com.xwray.groupie.viewbinding.BindableItem

class ButtonItem(val text: String, val colorId: Int? = null): BindableItem<ItemButtonBinding>() {

    override fun getLayout(): Int = R.layout.item_button

    override fun bind(viewBinding: ItemButtonBinding, position: Int) {
        viewBinding.item = this
    }

    override fun initializeViewBinding(view: View): ItemButtonBinding = ItemButtonBinding.bind(view)
}