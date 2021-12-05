package com.ifk8edvmat1gabkojginkir.ktuprojektas

import com.ifk8edvmat1gabkojginkir.ktuprojektas.DTO.quizDTO

object Constants {


    const val const_name: String = "name" //is main activity paduotas vardas cia

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

/*

    fun getQuestions2(): ArrayList<quizDTO>{
        val questionlist2 = ArrayList<quizDTO>()

    }
*/
}