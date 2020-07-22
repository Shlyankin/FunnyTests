package com.heads.thinking.funnytests

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


@BindingAdapter("imageUrl")
public fun loadImage(imageView: ImageView, imageUrl: String?) {
    if (imageUrl == null) return
    Picasso.get().load(imageUrl).placeholder(R.drawable.bottle).into(imageView, object: Callback {
        override fun onSuccess() {
        }

        override fun onError(e: Exception?) {
        }

    })
}