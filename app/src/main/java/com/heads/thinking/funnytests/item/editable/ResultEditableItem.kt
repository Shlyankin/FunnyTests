package com.heads.thinking.funnytests.item.editable

import android.view.View
import androidx.databinding.ObservableField
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.databinding.ItemEditableResultBinding
import com.heads.thinking.funnytests.model.TestResult
import com.xwray.groupie.viewbinding.BindableItem

class ResultEditableItem(): BindableItem<ItemEditableResultBinding>() {
    val testResult = ObservableField(TestResult())
    override fun getLayout(): Int = R.layout.item_editable_result

    override fun bind(viewBinding: ItemEditableResultBinding, position: Int) {
        viewBinding.item = this
    }

    override fun initializeViewBinding(view: View): ItemEditableResultBinding = ItemEditableResultBinding.bind(view)

}