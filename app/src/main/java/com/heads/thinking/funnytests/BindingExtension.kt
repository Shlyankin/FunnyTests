package com.heads.thinking.funnytests

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso


@BindingAdapter("bind:imageUrl")
public fun loadImage(imageView: ImageView, imageUrl: String) {
    Picasso.get().load(imageUrl).placeholder(R.drawable.bottle).into(imageView)
}
