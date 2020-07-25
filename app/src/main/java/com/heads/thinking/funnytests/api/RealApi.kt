package com.heads.thinking.funnytests.api

import com.heads.thinking.funnytests.model.CheckData
import com.heads.thinking.funnytests.model.Test
import io.reactivex.Maybe

class RealApi: Api {
    override fun getTests(): Maybe<List<Test>> = Maybe.just(CheckData.tests)
}