package com.heads.thinking.funnytests.mvvm.test

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.heads.thinking.funnytests.R
import com.heads.thinking.funnytests.api.Api
import com.heads.thinking.funnytests.item.AnswerItem
import com.heads.thinking.funnytests.item.ButtonItem
import com.heads.thinking.funnytests.model.Answer
import com.heads.thinking.funnytests.model.Question
import com.heads.thinking.funnytests.model.Test
import com.heads.thinking.funnytests.navigation.Screens
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class TestPlayerViewModel @Inject constructor(private val appContext: Context, private val api: Api, private val router: Router): ViewModel() {


    public val adapter = GroupAdapter<GroupieViewHolder>()

    // This LiveData linked with Fragment Toast Method
    // set "true" value for showing Toast with toastMessage
    // TODO: may be use App context for toast ??
    val showToast: MutableLiveData<Boolean> = MutableLiveData(false)
    var toastMessage = ""
    private fun showToast(message: String) {
        toastMessage = message
        showToast.value = true
    }

    fun showToast2(message: String) {
        Toast.makeText(appContext, R.string.select_answer, Toast.LENGTH_SHORT).show()
    }

    val currentQuestionObs = PublishSubject.create<Int>()
    var currentQuestionPos = 0
    val currentQuestion = ObservableField<Question>()
    private var mDisposable = CompositeDisposable()
    var isInitialized = false
    lateinit var test: Test

    fun initViewModel(test: Test) {
        test.clearResults()
        this.test = test
        mDisposable.addAll(
            currentQuestionObs.subscribe { currentQuestionPos ->
                currentQuestion.set(test.questions[currentQuestionPos])
                adapter.clear()
                currentQuestion.get()?.let {currentQuestion ->
                    for(answer in currentQuestion.answers)
                        adapter.add(AnswerItem(answer))
                    adapter.add(ButtonItem(appContext.getString(R.string.next)))
                    adapter.setOnItemClickListener { item, view ->
                        when (item) {
                            is AnswerItem -> {
                                uncheckAnswers()
                                item.checked.set(true)
                            }
                            is ButtonItem -> {
                                nextQuestion()
                            }
                        }
                    }
                }

            }
        )
        currentQuestionObs.onNext(0)
        isInitialized = true
    }

    private fun clearTestResult() {

    }

    private fun uncheckAnswers() {
        for (i in  0 until adapter.itemCount) {
            val item = adapter.getItem(i)
            if (item is AnswerItem && item.checked.get()!!)
                item.checked.set(false)
        }
    }

    private fun getAnswer(): Answer? {
        for (i in  0 until adapter.itemCount) {
            val item = adapter.getItem(i)
            if (item is AnswerItem && item.checked.get()!!)
                return item.answer
        }
        return null
    }

    private fun nextQuestion() {
        val answer = getAnswer()
        if (answer == null) {
            // TODO: user must select answer!
            showToast("Pls, select answer")
            return
        }
        if (currentQuestionPos + 1 < test.questions.size) {
            test.getSectionById(currentQuestion.get()?.resultSectionId!!)?.let { it.resultValue += answer.answerValue }
            currentQuestionObs.onNext(++currentQuestionPos)
        } else {
            test.getSectionById(currentQuestion.get()?.resultSectionId!!)?.let { it.resultValue += answer.answerValue }
            finishTest()
        }
    }

    fun nextQuestion(view: View) {
        nextQuestion()
    }

    fun finishTest() {
        router.replaceScreen(Screens.TestResultScreen(test, test.checkResult()))
    }

    override fun onCleared() {
        super.onCleared()
        mDisposable.dispose()
    }
}