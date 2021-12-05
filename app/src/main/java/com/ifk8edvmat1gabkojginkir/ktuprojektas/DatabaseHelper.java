package com.ifk8edvmat1gabkojginkir.ktuprojektas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ifk8edvmat1gabkojginkir.ktuprojektas.Model.Player;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context){
        super(context,"USERDB",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USERS (USERID INTEGER PRIMARY KEY AUTOINCREMENT,UNAME TEXT,SCORE INT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERDB");
        onCreate(db);
    }
    public ArrayList<Player> getAllData(){
        ArrayList<Player> arrayList=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USERS",null);

        while (cursor.moveToNext()){
            Integer USERID = cursor.getInt(0);
            String UNAME = cursor.getString(1);
            Integer SCORE = cursor.getInt(2);
            Player player = new Player(USERID,UNAME,SCORE);
            arrayList.add(player);

        }
        return arrayList;
    }
    public Cursor viewData(){
        SQLiteDatabase db= this.getReadableDatabase();
        String query= "SELECT * FROM USERS";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
}
