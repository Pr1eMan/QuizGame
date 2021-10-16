package com.ifk8edvmat1gabkojginkir.ktuprojektas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.chromium.base.Log

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class QuizGameMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_game_main)
        val questionsList = Constants.getQuestions()
        Log.i("Questions Size", "${questionsList.size}")
        val currentPosition=1
        val question: Question? = questionsList[currentPosition -1]
        val questionas = findViewById<View>(R.id.questionas) as TextView
        questionas.text = "My Awesome Text"


    }
}