package com.heads.thinking.funnytests.model

data class Question(var id: Int, var resultSectionId: Int, var description: String, var answers: List<Answer>, var imageUrl: String) {
    constructor(): this(0, 0, "", emptyList(), "")
}