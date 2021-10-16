package com.ifk8edvmat1gabkojginkir.ktuprojektas

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.ifk8edvmat1gabkojginkir.ktuprojektas.databinding.ActivityQuizMainActivtyBinding
import com.ifk8edvmat1gabkojginkir.ktuprojektas.Constants

class QuizMainActivty : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityQuizMainActivtyBinding
    private var const_user_name: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        const_user_name = intent.getStringExtra(Constants.const_name)
        binding = ActivityQuizMainActivtyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarQuizMainActivty.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_quiz_main_activty)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_rules, R.id.nav_rankings
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }


        //val name: String = Constants.const_name
//        Toast.makeText(applicationContext, const_user_name, Toast.LENGTH_SHORT).show() //ispausdina burbuliuka vardas

        val btnstart2 : Button =findViewById(R.id.btnStart)
        btnstart2.setOnClickListener {
            val intent = Intent(this, QuizGameMain::class.java)
           /// intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            this.startActivity(intent)


        //val name: String = Constants.const_name
        //Toast.makeText(applicationContext, const_user_name, Toast.LENGTH_SHORT).show() //ispausdina burbuliuka vardas

        val btnstart2 : Button =findViewById(R.id.btnStart)
        btnstart2.setOnClickListener {
            if(btnstart2.isPressed)
            {val intent = Intent(this, QuizGameMain::class.java)
                startActivity(intent)
                finish()
            }


        }
        }
        //val btn_start : Button = findViewById(R.id.btnEnter)



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.quiz_main_activty, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_quiz_main_activty)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}