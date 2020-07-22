package com.heads.thinking.funnytests.api

import com.heads.thinking.funnytests.model.Test
import io.reactivex.Single

interface Api {
    fun getTests() : Single<List<Test>>
}