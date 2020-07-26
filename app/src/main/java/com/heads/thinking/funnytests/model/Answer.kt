package com.heads.thinking.funnytests.model

data class Answer(var id: Int, var questionId: Int, var answerValue: Int, var description: String) {
    constructor(): this(0, 0, 0, "")
}