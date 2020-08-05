package com.heads.thinking.funnytests

import android.graphics.drawable.ColorDrawable
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupieViewHolder

@BindingAdapter("linkAdapter")
public fun setAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<GroupieViewHolder>) {
    recyclerView.adapter = adapter
}

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

@BindingAdapter("buttonColor")
public fun setBackground(view: View, color: Int?) {
    val typedValue = TypedValue()
    val context = view.context
    if (color == null) {
        context.theme.resolveAttribute(R.attr.buttonNormalColor, typedValue, true)
        view.setBackgroundResource(typedValue.resourceId)
    } else {
        context.resources.getValue(R.attr.buttonNormalColor, typedValue, true)
        val drawable = if (typedValue.type >= TypedValue.TYPE_FIRST_COLOR_INT && typedValue.type <= TypedValue.TYPE_LAST_COLOR_INT) ColorDrawable(typedValue.data)
        else ContextCompat.getDrawable(context, color)
        view.background = drawable
    }
}