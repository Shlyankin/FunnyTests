package com.heads.thinking.funnytests.model

object CheckData {
    val tests = arrayListOf(
        Test("0", "Cat or Dog", "*meow* or *woof*", "https://www.pngkey.com/png/full/55-558954_cats-and-dogs-png-dog-and-cat-png.png",
            arrayListOf(
                Question(0, "What do you like?",
                    arrayListOf(
                        Answer(0, 0, 0,"play"),
                        Answer(1, 0,1,"sleep")
                    ), "https://www.pngkey.com/png/full/55-558954_cats-and-dogs-png-dog-and-cat-png.png")
                ,
                Question(1, "What do you like to eat?",
                    arrayListOf(
                        Answer(0, 1, 1, "cats"),
                        Answer(1, 1, 0, "mice")),
                    "https://www.pngkey.com/png/full/55-558954_cats-and-dogs-png-dog-and-cat-png.png")
                ,
                Question(2, "Where are you living?",
                    arrayListOf(
                        Answer(0, 2, 1, "at kennel"),
                        Answer(1, 2, 0, "at house")),
                    "https://www.pngkey.com/png/full/55-558954_cats-and-dogs-png-dog-and-cat-png.png")
            ),
            arrayListOf<ResultSection>(
                ResultSection(0, "Animal", "Section is defining \"who are you\"", arrayListOf(
                    TestResult(0, "Cat", "You are cat", "https://webstockreview.net/images/burger-clipart-pizza-burger-2.jpg"),
                    TestResult(0, "Dog", "You are dog", "https://webstockreview.net/images/burger-clipart-pizza-burger-2.jpg")
                    )
                )
            )
        ),
        Test("1", "Pizza or Burger", "Fight of the Age", "https://webstockreview.net/images/burger-clipart-pizza-burger-2.jpg",
            arrayListOf(
                Question(0, "What do you like?",
                    arrayListOf(
                        Answer(0, 0,0,"Pizza"),
                        Answer(1, 0,1,"Burger")
                    ), "https://webstockreview.net/images/burger-clipart-pizza-burger-2.jpg")
            ),
            arrayListOf<ResultSection>(
                ResultSection(0, "Food", "Section is defining \"favourite food\"", arrayListOf(
                TestResult(0, "Pizza", "Do you like Italy?", "https://webstockreview.net/images/burger-clipart-pizza-burger-2.jpg"),
                TestResult(0, "Burger", "Do you like USA?", "https://webstockreview.net/images/burger-clipart-pizza-burger-2.jpg")
                    )
                )
            )
        )
    )
}