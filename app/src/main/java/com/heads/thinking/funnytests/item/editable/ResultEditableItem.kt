package com.heads.thinking.funnytests.item.editable

import android.view.View
import android.widget.ImageView
import androidx.databinding.ObservableField
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.databinding.ItemEditableResultBinding
import com.heads.thinking.funnytests.model.TestResult
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.xwray.groupie.viewbinding.BindableItem
import io.reactivex.subjects.SingleSubject

class ResultEditableItem(val getImage: () -> SingleSubject<String>): BindableItem<ItemEditableResultBinding>() {
    val testResult = ObservableField(TestResult())
    override fun getLayout(): Int = R.layout.item_editable_result

    override fun bind(viewBinding: ItemEditableResultBinding, position: Int) {
        viewBinding.item = this
    }

    override fun initializeViewBinding(view: View): ItemEditableResultBinding = ItemEditableResultBinding.bind(view)


    fun onImageClickListener(view: View) {
        val imageUrl = getImage().subscribe { url ->
            testResult.get()?.imageUrl = url
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