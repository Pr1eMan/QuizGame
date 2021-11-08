package com.ifk8edvmat1gabkojginkir.ktuprojektas

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import java.security.AccessControlContext

class MyDBHelper(context:Context) : SQLiteOpenHelper(context, "USERDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT, UNAME TEXT, SCORE INT)")
        db?.execSQL("INSERT INTO USERS(UNAME,SCORE) VALUES('kojelis','5')")
        db?.execSQL("INSERT INTO USERS(UNAME,SCORE) VALUES('kojelis2','5')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}