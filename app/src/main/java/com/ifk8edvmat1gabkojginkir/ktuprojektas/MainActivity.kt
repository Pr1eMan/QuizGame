package com.ifk8edvmat1gabkojginkir.ktuprojektas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.ifk8edvmat1gabkojginkir.ktuprojektas.DTO.quizList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN
        val btn_start : Button = findViewById(R.id.btnEnter)
        val et_name : EditText = findViewById(R.id.etName)

        //val msg2 = et_name.toString().trim()
       // val msg: String = et_name.toString()



        btn_start.setOnClickListener {



            val user_error: String = et_name.text.toString()
            if(user_error.trim().isEmpty()){
                et_name.error = "Required"
               Toast.makeText(applicationContext, "Please enter your desired name", Toast.LENGTH_SHORT).show() //veikia sutvarkiau

            }
            else{
                Toast.makeText(applicationContext, "successful", Toast.LENGTH_SHORT).show() //veikia sutvarkiau
                val intent = Intent(this, QuizMainActivty::class.java)

                intent.putExtra(Constants.const_name,et_name.text.toString()) // i constants patalpinam varda kuri paduodam

             // val intent = Intent(this, QuizGameMain::class.java)

                startActivity(intent)
                finish()
            }
        }

    }
}



