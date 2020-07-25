package com.heads.thinking.funnytests.api

import com.heads.thinking.funnytests.model.Test
import io.reactivex.Maybe

interface Api {
    fun getTests() : Maybe<List<Test>>
}