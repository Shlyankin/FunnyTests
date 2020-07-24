package com.heads.thinking.funnytests.model

data class TestResult(val id: Int, val name: String, val description: String, val imageUrl: String, var resultValue: Int = 0) {
}