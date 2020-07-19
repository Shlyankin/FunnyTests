package com.heads.thinking.funnytests.model

import androidx.databinding.BindingAdapter
import com.heads.thinking.funnytests.exception.TestException

// need to add statistics
data class Test(val id: String, val title: String, val description: String, val imageUrl: String,
                val questions: List<Question>, val results: List<TestResult>) {

    fun checkResult(userAnswers: List<Answer>): TestResult {
        var finalResultValue = 0
        for (answer in userAnswers) {
            finalResultValue += answer.resultValue
        }
        for (result in results) {
            if (finalResultValue in result.resultValue) return result
        }
        throw TestException("Cant check result. May be test have incorrect range of variable @resultValue")
    }

    override fun equals(other: Any?): Boolean {
        return if (other is Test) {
            other.id == this.id
        } else false
    }
}