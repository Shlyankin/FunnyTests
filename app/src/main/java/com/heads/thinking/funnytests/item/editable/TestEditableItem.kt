package com.heads.thinking.funnytests.item.editable

import android.view.View
import android.widget.ImageView
import androidx.databinding.ObservableField
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.databinding.ItemEditableTestBinding
import com.heads.thinking.funnytests.model.Test
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.xwray.groupie.viewbinding.BindableItem
import io.reactivex.subjects.SingleSubject

class TestEditableItem(val getImage: () -> SingleSubject<String>): BindableItem<ItemEditableTestBinding>() {
    val test = ObservableField(Test())

    val listOfResultSectionsItem = ArrayList<ResultSectionEditableItem>()

    override fun getLayout() = R.layout.item_editable_test

    override fun bind(viewBinding: ItemEditableTestBinding, position: Int) {
        viewBinding.item = this
    }

    override fun initializeViewBinding(view: View): ItemEditableTestBinding = ItemEditableTestBinding.bind(view)

    fun onImageClickListener(view: View) {
        val imageUrl = getImage().subscribe { url ->
            test.get()?.imageUrl = url
            if (view is ImageView) {
                Picasso.get().load(url).placeholder(R.drawable.bottle).into(view, object:
                    Callback {
                    override fun onSuccess() {
                    }

                    override fun onError(e: Exception?) {
                    }
                })
            }
        }
    }
}