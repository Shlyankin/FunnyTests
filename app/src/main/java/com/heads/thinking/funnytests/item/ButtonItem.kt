package com.heads.thinking.funnytests.item

import android.graphics.drawable.Drawable
import android.view.View
import androidx.databinding.ObservableField
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.databinding.ItemButtonBinding
import com.xwray.groupie.viewbinding.BindableItem

class ButtonItem(val text: String, val onClickListener: View.OnClickListener, val colorId: Int? = null): BindableItem<ItemButtonBinding>() {

    val imageResource = ObservableField<Drawable>()

    override fun getLayout(): Int = R.layout.item_button

    override fun bind(viewBinding: ItemButtonBinding, position: Int) {
        viewBinding.item = this
    }

    override fun initializeViewBinding(view: View): ItemButtonBinding = ItemButtonBinding.bind(view)
}