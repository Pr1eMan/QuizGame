package com.ifk8edvmat1gabkojginkir.ktuprojektas

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
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
    private var progressStatus = 0
    private val handler: Handler = Handler()
    private var mCurrentPosition:Int =0
    private val mQuestionsList:ArrayList<Question> =arrayListOf()
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAnswers: Int =0
    private var mUserName: String? =null
    private var mTopic: String? = ""
    private var isSelected=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_game_main)

        //val RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
        //final Button btn = (Button) findViewById(R.id.btn);


       // mQuestionsList = Constants.getQuestions()
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mTopic = intent.getStringExtra(Constants.TOPIC)
        val questionas = findViewById<View>(R.id.questionas) as TextView
        val optionOne = findViewById<View>(R.id.optionOne) as TextView
        val optionTwo = findViewById<View>(R.id.optionTwo) as TextView
        val optionThree = findViewById<View>(R.id.optionThree) as TextView
        val btnSubmit = findViewById<View>(R.id.btnSubmit) as Button
        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)
        val pb_drawable = findViewById<View>(R.id.pb_drawable) as ProgressBar
        pb_drawable.setVisibility(View.GONE);
        questionas.text="Quiz is loading up"
        optionOne.setVisibility(View.GONE);
        optionTwo.setVisibility(View.GONE);
        optionThree.setVisibility(View.GONE);
        btnSubmit.setVisibility(View.GONE);



        //cia json retrofit galima perkelt i kita klase nzn kur reikia
        val request = RetrofitClientInstance.buildService(GetQuizApiEndpointInterface::class.java)
        val call = request?.getAllQuiz(mTopic.toString(), "json")


        call?.enqueue(object : Callback<quizList> {
            override fun onResponse(call: Call<quizList>, response: Response<quizList>) {
                val body = response?.body()
                val allquiz = body?.quiz // cia yra visas quiz ArrayList (reikia ispausdint kad pasiziuret body: "quizlist(quiz=[quizDTO(question=....,correct_answer=.....,answers=......)...
                val size = allquiz?.size
                android.util.Log.v("json list size", size.toString())
                if (size == 0)
                {
                    Toast.makeText(applicationContext, "Could not create questions on specified topic, try something else.", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext,QuizMainActivty::class.java)

                    intent.putExtra(Constants.const_name, mUserName.toString())
                    startActivity(intent)
                    finish()
                }
                if(allquiz != null){

                    for(i in 0 until allquiz.count()){
                        val rnds = (1..3).random()

                        if(rnds == 1) {
                            val que1 = Question(
                                i + 1,
                                allquiz[i].question,
                                allquiz[i].answers[0].toString(),
                                allquiz[i].answers[1].toString(),
                                allquiz[i].answers[2].toString(),
                                1
                            )
                            mQuestionsList.add(que1)
                        }
                        if(rnds == 2) {
                            val que1 = Question(
                                i + 1,
                                allquiz[i].question,
                                allquiz[i].answers[1].toString(),
                                allquiz[i].answers[0].toString(),
                                allquiz[i].answers[2].toString(),
                                2
                            )
                            mQuestionsList.add(que1)
                        }
                        if(rnds == 3) {
                            val que1 = Question(
                                i + 1,
                                allquiz[i].question,
                                allquiz[i].answers[1].toString(),
                                allquiz[i].answers[2].toString(),
                                allquiz[i].answers[0].toString(),
                                3
                            )
                            mQuestionsList.add(que1)
                        }

                        setQuestion()
                        pb_drawable.setVisibility(View.VISIBLE);
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
        isSelected=false
        val optionOne = findViewById<View>(R.id.optionOne) as TextView
        val optionTwo = findViewById<View>(R.id.optionTwo) as TextView
        val optionThree = findViewById<View>(R.id.optionThree) as TextView
        val btnSubmit = findViewById<View>(R.id.btnSubmit) as Button
       // mCurrentPosition+=1
        //Thread.sleep(1_000)
        android.util.Log.v("question list size", mQuestionsList!!.size.toString())

        val question: Question? = mQuestionsList!!.get(mCurrentPosition)

        defaultOptionsView()
        if(mCurrentPosition == mQuestionsList!!.size) {
            btnSubmit.text = "FINISH"
        }else{
            btnSubmit.text="SUBMIT"
        }
        val questionas = findViewById<View>(R.id.questionas) as TextView
        questionas.setVisibility(View.VISIBLE);
        optionOne.setVisibility(View.VISIBLE);
        optionTwo.setVisibility(View.VISIBLE);
        optionThree.setVisibility(View.VISIBLE);
        btnSubmit.setVisibility(View.VISIBLE);
        questionas.text = question!!.question

       // val optionOne = findViewById<View>(R.id.optionOne) as TextView

        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionThree.text = question.optionThree
       // val optionTwo = findViewById<View>(R.id.optionTwo) as TextView
    }


    private fun defaultOptionsView() {
        val optionOne = findViewById<View>(R.id.optionOne) as TextView
        val optionTwo = findViewById<View>(R.id.optionTwo) as TextView
        val optionThree = findViewById<View>(R.id.optionThree) as TextView

        val btnSubmit = findViewById<View>(R.id.btnSubmit) as Button
        val options=ArrayList<TextView>()
        options.add(0,optionOne)
        options.add(1,optionTwo)
        options.add(2,optionThree)
        for (option in options) {
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

    override fun onClick(v: View?) {

        val optionOne = findViewById<View>(R.id.optionOne) as TextView
        val optionTwo = findViewById<View>(R.id.optionTwo) as TextView
        val optionThree = findViewById<View>(R.id.optionThree) as TextView
        val btnSubmit = findViewById<View>(R.id.btnSubmit) as Button
        val tv = findViewById<View>(R.id.tv) as TextView
        val pb_default = findViewById<View>(R.id.pb_default) as ProgressBar
        val pb_drawable = findViewById<View>(R.id.pb_drawable) as ProgressBar


        when(v?.id) {
            R.id.optionOne -> {
                if(!isSelected)
                selectedOptionView(optionOne,1)

            }
            R.id.optionTwo -> {
                if(!isSelected)
                selectedOptionView(optionTwo,2)
            }
            R.id.optionThree -> {
                if(!isSelected)
                selectedOptionView(optionThree,3)
            }
            R.id.btnSubmit -> {
                isSelected=true

                if(mSelectedOptionPosition ==0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionsList!!.size-1-> {
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
                    val question = mQuestionsList?.get(mCurrentPosition)
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

                        progressStatus +=100/mQuestionsList!!.size;

                        pb_drawable.setProgress(progressStatus);

                    }
                    mSelectedOptionPosition =0

                }
            }
        }
    }
    private fun answerView(answer:Int, drawableView:Int) {
        val optionOne = findViewById<View>(R.id.optionOne) as TextView
        val optionTwo = findViewById<View>(R.id.optionTwo) as TextView
        val optionThree = findViewById<View>(R.id.optionThree) as TextView
        val btnSubmit = findViewById<View>(R.id.btnSubmit) as Button
        when(answer) {
            1-> {
                optionOne.background = ContextCompat.getDrawable(this,drawableView)
            }
            2-> {
                optionTwo.background = ContextCompat.getDrawable(this,drawableView)
            }
            3-> {
                optionThree.background = ContextCompat.getDrawable(this,drawableView)
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