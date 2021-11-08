package com.ifk8edvmat1gabkojginkir.ktuprojektas

import android.content.ContentValues
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

        //val user_name = intent.getStringExtra(Constants.USER_NAME)
        val username = findViewById<View>(R.id.username) as TextView
        //username.text = user_name
        var helper = MyDBHelper(applicationContext)
        var db= helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERS", null)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val mUserName = intent.getStringExtra(Constants.USER_NAME)
        val score = findViewById<View>(R.id.score) as TextView
        val congrats = findViewById<View>(R.id.congrats) as TextView
        val btnFinish = findViewById<View>(R.id.btnDone) as Button
        congrats.text ="Congrats, $mUserName"
        score.text = "Your score is $correctAnswers out of $totalQuestions"
        btnFinish.setOnClickListener {
            var  cv = ContentValues()
            cv.put("UNAME","$mUserName")
            cv.put("SCORE","$correctAnswers")
            db.insert("USERS",null,cv)
            startActivity(Intent(this,QuizMainActivty::class.java))
            finish()
        }
    }



}