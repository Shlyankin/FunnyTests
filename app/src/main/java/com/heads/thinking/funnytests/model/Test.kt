package com.heads.thinking.funnytests.model

import com.heads.thinking.funnytests.exception.TestException

// need to add statistics
data class Test constructor(var id: Int, var title: String, var description: String, var imageUrl: String,
                            var questions: List<Question>, var resultsSections: List<ResultSection>) {
    constructor(): this(0, "", "", "", emptyList(), emptyList())

    fun clearResults() {
        for (section in resultsSections) {
            section.resultValue = 0
        }
    }

    fun getSectionById(id: Int): ResultSection? {
        for (section in resultsSections) {
            if (id == section.id) return section
        }
        return null
    }

    fun getResultById(sectionId: Int, id: Int): TestResult? {
        for (section in resultsSections) {
            if (section.id == sectionId)
                for (result in section.testResults)
                    if (id == result.id) return result
        }
        return null
    }

    fun checkResult(): Map<ResultSection, TestResult> {
        val results = mutableMapOf<ResultSection, TestResult>()
        for (section in resultsSections) {
            var sectionResult: TestResult? = null
            for (result in section.testResults) {
                if (section.resultValue >= result.resultThreshold && (sectionResult == null || sectionResult.resultThreshold < result.resultThreshold))
                    sectionResult = result
            }
            if (sectionResult == null) throw TestException("Test error. Change test in database.")
            results[section] = sectionResult
        }
        return results
    }

    override fun equals(other: Any?): Boolean {
        return if (other is Test) {
            other.id == this.id
        } else false
    }
}