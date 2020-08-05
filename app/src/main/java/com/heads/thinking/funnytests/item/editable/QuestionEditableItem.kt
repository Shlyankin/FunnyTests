package com.heads.thinking.funnytests.item.editable

import android.view.View
import android.widget.ImageView
import androidx.databinding.ObservableField
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.databinding.ItemEditableQuestionBinding
import com.heads.thinking.funnytests.model.Question
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.xwray.groupie.viewbinding.BindableItem
import io.reactivex.subjects.SingleSubject

class QuestionEditableItem(val getImage: () -> SingleSubject<String>): BindableItem<ItemEditableQuestionBinding>() {

    val question = ObservableField(Question())
    val listOfAnswersItem = ArrayList<AnswerEditableItem>()

    override fun getLayout(): Int = R.layout.item_editable_question

    override fun bind(viewBinding: ItemEditableQuestionBinding, position: Int) {
        viewBinding.item = this
    }

    override fun initializeViewBinding(view: View): ItemEditableQuestionBinding = ItemEditableQuestionBinding.bind(view)

    fun onImageClickListener(view: View) {
        val imageUrl = getImage().subscribe { url ->
            question.get()?.imageUrl = url
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