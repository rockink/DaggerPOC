package com.rockink.daggerpoc.application

import kotlin.random.Random

class RandomStringer{
    val random = Random(10);

    fun getRandomString(): String {
        return "Random String ${random.nextInt()}"
    }
}