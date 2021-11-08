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
import com.ifk8edvmat1gabkojginkir.ktuprojektas.DTO.quizDTO
import com.ifk8edvmat1gabkojginkir.ktuprojektas.DTO.quizList
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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


        //cia json retrofit galima perkelt i kita klase nzn kur reikia

        val service = RetrofitClientInstance.retrofitInstance?.create(GetQuizService::class.java)
        val call = service?.getallquiz()



        
        call?.enqueue(object : Callback<quizList> {
            override fun onResponse(call: Call<quizList>, response: Response<quizList>) {
                val body = response?.body()
                val allquiz = body?.quiz // cia yra visas quiz ArrayList (reikia ispausdint kad pasiziuret body: "quizlist(quiz=[quizDTO(question=....,correct_answer=.....,answers=......)...
                val size = allquiz?.size
                if(allquiz != null){
                    for(i in 0 until allquiz.count()){
                        val questiondto = allquiz[i].question ?: "N/A"
                        android.util.Log.v("question ", questiondto)

                        val answersdto = allquiz[i].answers ?: 0
                        android.util.Log.v("answers ", answersdto.toString())

                        val correctanswerdto = allquiz[i].correct_answer ?: "N/A"
                        android.util.Log.v("correctanswer ", correctanswerdto)
                    }
                }
            }

            override fun onFailure(call: Call<quizList>, t: Throwable) {
                Toast.makeText(applicationContext,"error reading JSON",Toast.LENGTH_LONG).show()
            }

        })


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
<<<<<<< HEAD
       // optionTwo.text = question.optionTwo
        val optionTwoText : EditText = findViewById(R.id.answer)
        optionTwo.text = optionTwoText.toString()
=======
        optionTwo.text = question.optionTwo
>>>>>>> parent of 666e2b8 (Merge branch 'Edvinas1' into Gintas)

    }
    private fun defaultOptionsView() {
        val optionOne = findViewById<View>(R.id.optionOne) as TextView
        val optionTwo = findViewById<View>(R.id.optionTwo) as TextView
        val btnSubmit = findViewById<View>(R.id.btnSubmit) as Button
        val options=ArrayList<TextView>()
        options.add(0,optionOne)
       // options.add(1,optionTwo)
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