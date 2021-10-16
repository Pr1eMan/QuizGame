package com.ifk8edvmat1gabkojginkir.ktuprojektas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN
        val btn_start= findViewById<View>(R.id.btnEnter)
        val et_name= findViewById<View>(R.id.etName)
        btn_start.setOnClickListener {

            if(et_name.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show() //nivalit
            } else {
                val intent = Intent(this, QuizMainActivty::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}