package com.ifk8edvmat1gabkojginkir.ktuprojektas

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import org.chromium.base.Log

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.w3c.dom.Text

class QuizGameMain : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition:Int =1
    private var mQuestionsList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAnswers: Int =0
    private var mUserName: String? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_game_main)
        mQuestionsList = Constants.getQuestions()
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        setQuestion()
        val optionOne = findViewById<View>(R.id.optionOne) as TextView
        val optionTwo = findViewById<View>(R.id.optionTwo) as TextView
        val btnSubmit = findViewById<View>(R.id.btnSubmit) as Button
        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)


    }
    private fun setQuestion() {

        val optionOne = findViewById<View>(R.id.optionOne) as TextView
        val optionTwo = findViewById<View>(R.id.optionTwo) as TextView
        val btnSubmit = findViewById<View>(R.id.btnSubmit) as Button
       // mCurrentPosition=1
        val question: Question? = mQuestionsList!!.get(mCurrentPosition-1)

        defaultOptionsView()
        if(mCurrentPosition == mQuestionsList!!.size) {
            btnSubmit.text = "FINISH"
        }else{
            btnSubmit.text="SUBMIT"
        }
        val questionas = findViewById<View>(R.id.questionas) as TextView
        questionas.text = question!!.question

       // val optionOne = findViewById<View>(R.id.optionOne) as TextView
        optionOne.text = question.optionOne
       // val optionTwo = findViewById<View>(R.id.optionTwo) as TextView
        optionTwo.text = question.optionTwo

    }
    private fun defaultOptionsView() {
        val optionOne = findViewById<View>(R.id.optionOne) as TextView
        val optionTwo = findViewById<View>(R.id.optionTwo) as TextView
        val btnSubmit = findViewById<View>(R.id.btnSubmit) as Button
        val options=ArrayList<TextView>()
        options.add(0,optionOne)
        options.add(1,optionTwo)
        for (option in options) {
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

    override fun onClick(v: View?) {
        val optionOne = findViewById<View>(R.id.optionOne) as TextView
        val optionTwo = findViewById<View>(R.id.optionTwo) as TextView
        val btnSubmit = findViewById<View>(R.id.btnSubmit) as Button
        when(v?.id) {
            R.id.optionOne -> {
                selectedOptionView(optionOne,1)
            }
            R.id.optionTwo -> {
                selectedOptionView(optionTwo,2)
            }
            R.id.btnSubmit -> {
                if(mSelectedOptionPosition ==0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionsList!!.size-> {
                            setQuestion()
                        } else -> {
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size)
                            startActivity(intent)
                          //  Toast.makeText(this,"You have successfully completed the Quiz", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition,R.drawable.red)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.green)
                    if(mCurrentPosition == mQuestionsList!!.size) {
                        btnSubmit.text= "FINISH"
                    } else {
                        btnSubmit.text= "Go to next question"

                    }
                    mSelectedOptionPosition =0

                }
            }
        }
    }
    private fun answerView(answer:Int, drawableView:Int) {
        val optionOne = findViewById<View>(R.id.optionOne) as TextView
        val optionTwo = findViewById<View>(R.id.optionTwo) as TextView
        val btnSubmit = findViewById<View>(R.id.btnSubmit) as Button
        when(answer) {
            1-> {
                optionOne.background = ContextCompat.getDrawable(this,drawableView)
            }
            2-> {
                optionTwo.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
    private fun selectedOptionView(tv: TextView, selectedOptionNum:Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#FFFFFFFF"))
      //  tv.setTypeface = (tv.typeface, Typeface.BOLD)
        tv.setBackgroundColor(Color.parseColor("#FFBB86FC"));

    }
}