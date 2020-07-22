package com.heads.thinking.funnytests.api

import com.heads.thinking.funnytests.model.CheckData
import com.heads.thinking.funnytests.model.Test
import io.reactivex.Single
import javax.inject.Inject

class RealApi: Api {

    @Inject constructor() // it is fucking magic

    override fun getTests(): Single<List<Test>> = Single.just(CheckData.tests)
}