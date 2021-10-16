package com.ifk8edvmat1gabkojginkir.ktuprojektas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val user_name = intent.getStringExtra(Constants.USER_NAME)
        val username = findViewById<View>(R.id.username) as TextView
        username.text = user_name

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val score = findViewById<View>(R.id.score) as TextView
        val btnFinish = findViewById<View>(R.id.btnDone) as Button
        score.text = "Your score is $correctAnswers out of $totalQuestions"
        btnFinish.setOnClickListener {
 
            if(btnFinish.isPressed)
            {

                val intent = Intent(this, QuizMainActivty::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

            }
 
            startActivity(Intent(this,QuizMainActivty::class.java))
            finish()
 
        }
    }
}