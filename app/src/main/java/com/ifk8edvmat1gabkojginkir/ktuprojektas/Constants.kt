package com.ifk8edvmat1gabkojginkir.ktuprojektas

object Constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total questions"
    const val CORRECT_ANSWERS: String = "correct answers"
    fun getQuestions(): ArrayList<Question>{
        val questionsList= ArrayList<Question>()
        val que1 = Question(1,"Ar gausim penketa?",
            "Taip","Ne", 1
        )
        questionsList.add(que1)

        val que2 = Question(2,"Ar gausim seseta?",
            "Taip","Ne", 2
        )
        questionsList.add(que2)

        return questionsList
    }
}