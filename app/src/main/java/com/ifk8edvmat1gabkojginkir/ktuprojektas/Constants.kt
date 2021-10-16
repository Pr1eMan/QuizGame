package com.ifk8edvmat1gabkojginkir.ktuprojektas

object Constants {

    const val const_name: String = "name" //is main activity paduotas vardas cia
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