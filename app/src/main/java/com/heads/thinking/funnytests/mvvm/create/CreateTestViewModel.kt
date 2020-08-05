package com.heads.thinking.funnytests.mvvm.create

import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.Utils.IMAGE_REQUEST_CODE
import com.heads.thinking.funnytests.api.Api
import com.heads.thinking.funnytests.item.ButtonItem
import com.heads.thinking.funnytests.item.editable.*
import com.heads.thinking.funnytests.model.Test
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import com.xwray.groupie.groupiex.plusAssign
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.SingleSubject
import ru.terrakok.cicerone.Router
import java.io.File
import javax.inject.Inject


class CreateTestViewModel @Inject constructor(val api: Api, val context: Context, val router: Router): ViewModel() {

    val pickImage = MutableLiveData(false)
    lateinit var imgUri : SingleSubject<String>

    fun onActivityResult(requestCode: Int, file: File?) {
        when (requestCode) {
            IMAGE_REQUEST_CODE -> {
                if (file!=null) {
                    imgUri.onSuccess(file.absolutePath)
                } else {
                    imgUri.onError(Error(context.getString(R.string.cant_find_image)))
                }
            }
        }
    }

    private val openImage = {
        imgUri = SingleSubject.create()
        pickImage.value = true
        imgUri
    }

    val test = Test()
    private val mDisposable = CompositeDisposable()

    val adapter = GroupAdapter<GroupieViewHolder>()
    val testEditableItem = TestEditableItem(openImage)
    val arrayResultSection = ArrayList<ResultSectionEditableItem>()
    val arrayQuestionSection = ArrayList<QuestionEditableItem>()


    private val testCreationSection = Section().apply {
        this.setFooter(ButtonItem(context.getString(R.string.create_result_section), View.OnClickListener {
            val resultSection = createResultSection()
            val resultSectionEditableItem = resultSection.getItem(0) as ResultSectionEditableItem
            resultSectionEditableItem.resultSection.get()?.id = arrayResultSection.size
            arrayResultSection.add(resultSectionEditableItem)
            this.add(resultSection)
        }))
    }

    private fun createResultSection() = Section().apply {
        val resultSectionEditableItem = ResultSectionEditableItem()
        this.setHeader(resultSectionEditableItem)
        this.add(createResult(resultSectionEditableItem))
        this.add(createQuestionsMainSection(resultSectionEditableItem))
    }

    private fun createResult(resultSectionEditableItem: ResultSectionEditableItem) = Section().apply {
        this.setFooter(ButtonItem(context.getString(R.string.create_result), View.OnClickListener {
            val resultEditableItem = ResultEditableItem(openImage)
            resultEditableItem.testResult.get()?.id = resultSectionEditableItem.listOfResultsItem.size
            resultSectionEditableItem.listOfResultsItem.add(resultEditableItem)
            this.add(resultEditableItem)
        }))
    }

    private fun createQuestionsMainSection(resultSectionEditableItem: ResultSectionEditableItem) = Section().apply {
        this.setFooter(
            ButtonItem(
                context.getString(R.string.create_question),
                View.OnClickListener {
                    val questionSection = createQuestion()
                    val questionEditableItem = questionSection.getItem(0) as QuestionEditableItem
                    questionEditableItem.question.get()?.id = arrayQuestionSection.size
                    questionEditableItem.question.get()?.resultSectionId = resultSectionEditableItem.resultSection.get()?.id!!
                    arrayQuestionSection.add(questionEditableItem)
                    this.add(questionSection)
                })
        )
    }

    private fun createQuestion() = Section().apply {
        val questionEditableItem = QuestionEditableItem(openImage)
        this.setHeader(questionEditableItem)
        this.setFooter(
            ButtonItem(
                context.getString(R.string.create_answer),
                View.OnClickListener {
                    val answerEditableItem = AnswerEditableItem()
                    answerEditableItem.answer.get()?.id = questionEditableItem.listOfAnswersItem.size
                    answerEditableItem.answer.get()?.questionId = questionEditableItem.question.get()?.id!!
                    questionEditableItem.listOfAnswersItem.add(answerEditableItem)
                    this.add(answerEditableItem)
                })
        )
    }

    init {
        adapter.add(testEditableItem)
        adapter += testCreationSection
    }


    fun createTest(view: View) {
        val tmpTest = testEditableItem.test.get()!!

        for (item in arrayResultSection) {
            item.resultSection.get()?.let {
                for (item2 in item.listOfResultsItem)
                    it.testResults.add(item2.testResult.get()!!)
                tmpTest.resultsSections.add(it)
            }
        }

        for (item in arrayQuestionSection) {
            item.question.get()?.let {
                for (item2 in item.listOfAnswersItem)
                    it.answers.add(item2.answer.get()!!)
                tmpTest.questions.add(it)
            }
        }
        // TODO: upload all images and change uri
        // TODO: if (test is valid) upload test to firebase
    }

    fun createQuestion(view: View) {
        // TODO: open Dialog
    }

    override fun onCleared() {
        super.onCleared()
        mDisposable.dispose()
    }




}