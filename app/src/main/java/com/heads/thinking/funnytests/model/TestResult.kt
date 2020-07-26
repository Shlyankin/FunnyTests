package com.heads.thinking.funnytests.model

data class TestResult(var id: Int, var name: String, var description: String, var imageUrl: String, var resultThreshold: Int) {
    constructor(): this(0, "", "", "", 0)
}