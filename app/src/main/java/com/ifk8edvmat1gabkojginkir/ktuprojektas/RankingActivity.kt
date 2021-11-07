package com.ifk8edvmat1gabkojginkir.ktuprojektas

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RankingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_rankings)

        var helper = MyDBHelper(applicationContext)
        var db= helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERS", null)

        if(rs.moveToNext())
            Toast.makeText(applicationContext,rs.getString(1), Toast.LENGTH_LONG).show()

    }
}