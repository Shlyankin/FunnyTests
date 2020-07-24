package com.heads.thinking.funnytests.model

class ResultSection(val id: Int, val name: String, val description: String, val testResults: List<TestResult>) {

    override fun equals(other: Any?): Boolean = if (other is ResultSection) other.id == this.id else false

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + testResults.hashCode()
        return result
    }

}