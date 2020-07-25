package com.heads.thinking.funnytests.model

class ResultSection(var id: Int, var name: String, var description: String, var testResults: List<TestResult>) {
    constructor(): this(0, "", "", emptyList())
    override fun equals(other: Any?): Boolean = if (other is ResultSection) other.id == this.id else false

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + testResults.hashCode()
        return result
    }

}