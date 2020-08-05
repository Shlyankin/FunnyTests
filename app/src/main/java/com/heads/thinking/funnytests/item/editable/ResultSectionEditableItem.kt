package com.heads.thinking.funnytests.item.editable

import android.view.View
import androidx.databinding.ObservableField
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.databinding.ItemEditableResultSectionBinding
import com.heads.thinking.funnytests.model.ResultSection
import com.xwray.groupie.viewbinding.BindableItem

class ResultSectionEditableItem(): BindableItem<ItemEditableResultSectionBinding>() {

    val resultSection = ObservableField(ResultSection())

    val listOfResultsItem = ArrayList<ResultEditableItem>()

    override fun getLayout(): Int = R.layout.item_editable_result_section

    override fun bind(viewBinding: ItemEditableResultSectionBinding, position: Int) {
        viewBinding.item = this
    }

    override fun initializeViewBinding(view: View): ItemEditableResultSectionBinding = ItemEditableResultSectionBinding.bind(view)
}