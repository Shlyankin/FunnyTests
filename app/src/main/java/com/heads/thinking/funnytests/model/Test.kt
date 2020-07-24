package com.heads.thinking.funnytests.model

// need to add statistics
data class Test(val id: String, val title: String, val description: String, val imageUrl: String,
                val questions: List<Question>, val resultsSections: List<ResultSection>) {

    fun getSectionById(id: Int): ResultSection? {
        for (section in resultsSections) {
            if (id == section.id) return section
        }
        return null
    }

    fun getResultById(id: Int): TestResult? {
        for (section in resultsSections) {
            for (result in section.testResults)
                if (id == result.id) return result
        }
        return null
    }

    fun checkResult(): Map<ResultSection, TestResult> {
        val results = mutableMapOf<ResultSection, TestResult>()
        for (section in resultsSections) {
            var sectionResult = section.testResults[0]
            for (result in section.testResults) {
                if (result.resultValue > sectionResult.resultValue)
                    sectionResult = result
            }
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