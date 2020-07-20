package com.heads.thinking.funnytests.adapter

import android.view.View
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.databinding.ItemTestBinding
import com.heads.thinking.funnytests.model.Test
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.xwray.groupie.viewbinding.BindableItem

class TestItem(val test:Test): BindableItem<ItemTestBinding>() {
    override fun getLayout() = R.layout.item_test

    override fun bind(viewBinding: ItemTestBinding, position: Int) {
        viewBinding.test = test
        Picasso.get().load(test.imageUrl).placeholder(R.drawable.bottle).into(viewBinding.testImage, object:
            Callback {
            override fun onSuccess() {
                viewBinding.imageProgress.visibility = View.GONE
                viewBinding.testImage.visibility = View.VISIBLE
            }

            override fun onError(e: Exception?) {
                viewBinding.imageProgress.visibility = View.GONE
                viewBinding.testImage.visibility = View.VISIBLE
            }

        })
    }

    override fun initializeViewBinding(view: View): ItemTestBinding = ItemTestBinding.bind(view)

}