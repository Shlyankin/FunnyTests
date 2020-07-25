package com.heads.thinking.funnytests.api

import com.google.firebase.database.FirebaseDatabase
import com.heads.thinking.funnytests.model.Test
import durdinapps.rxfirebase2.DataSnapshotMapper
import durdinapps.rxfirebase2.RxFirebaseDatabase
import io.reactivex.Maybe

class FirebaseApi(): Api {
    companion object  {
        private val firebaseDatabase = FirebaseDatabase.getInstance()
        private val databaseReference = firebaseDatabase.reference
    }
    override fun getTests(): Maybe<List<Test>> = RxFirebaseDatabase
        .observeSingleValueEvent(databaseReference.child("tests"), DataSnapshotMapper.listOf(Test::class.java))
}