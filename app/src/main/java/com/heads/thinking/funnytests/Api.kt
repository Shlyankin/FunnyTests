package com.heads.thinking.funnytests

import com.heads.thinking.funnytests.model.Test
import io.reactivex.Single

interface Api {
    fun getTests() : Single<List<Test>>
}