package com.heads.thinking.funnytests

import android.graphics.Color
import kotlin.random.Random


object Util {
    fun randomLightColor(): Int {
        val r = Random.nextInt() / 2 + 127
        val g = Random.nextInt() / 2 + 127
        val b = Random.nextInt() / 2 + 127

       return Color.argb(127, r, g, b)
    }
}