package com.heads.thinking.funnytests.model

object CheckData {
    val tests = arrayListOf(
        Test("0", "Cat or Dog", "*meow* or *woof*", "https://cdn.imgbin.com/20/12/21/imgbin-cats-and-dogs-AF7S2RAR2J6fQhWe5XeQGiKWE.jpg",
            arrayListOf(
                Question(0, "What do you like?",
                    arrayListOf(Answer(0, "play", -1), Answer(1, "sleep", 1))),

                Question(1, "What do you like to eat?",
                    arrayListOf(Answer(0, "cats", -1), Answer(1, "mice", 1)))
            ),
            arrayListOf<TestResult>(
                TestResult(0, "Cat", "You are cat", Int.MIN_VALUE until 0),
                TestResult(0, "What?!", "Who are you, Mother of God?!", 0 until 1),
                TestResult(0, "Dog", "You are dog", 1 until Int.MAX_VALUE)
            )
        ),
        Test("1", "Pizza or Burger", "Fight of the Age", "https://webstockreview.net/images/burger-clipart-pizza-burger-2.jpg",
            arrayListOf(
                Question(0, "What do you like?",
                    arrayListOf(Answer(0, "Pizza", -1), Answer(1, "Burger", 1)))
            ),
            arrayListOf<TestResult>(
                TestResult(0, "Pizza", "Do you like Italy?", Int.MIN_VALUE until 0),
                TestResult(0, "Burger", "Do you like USA?", 1 until Int.MAX_VALUE)
            )
        )
    )
}