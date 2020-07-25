package com.heads.thinking.funnytests.model

data class TestResult(var id: Int, var name: String, var description: String, var imageUrl: String, var resultValue: Int = 0) {
    constructor(): this(0, "", "", "")
}