package com.ifk8edvmat1gabkojginkir.ktuprojektas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ifk8edvmat1gabkojginkir.ktuprojektas.Adapters.MyAdapter;
import com.ifk8edvmat1gabkojginkir.ktuprojektas.Model.Player;

import java.util.ArrayList;
import java.util.List;

public class RankingActivityy extends AppCompatActivity {

    ListView l1;
    DatabaseHelper databaseHelper;
    ArrayList<Player> arrayList;
    MyAdapter myAdapter;
    DatabaseHelper db;
    ArrayList<String> listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_rankings);
        db= new DatabaseHelper(this);
        listItem=new ArrayList<>();
        db= new DatabaseHelper(this);
        listItem = new ArrayList<>();
        l1=(ListView)findViewById(R.id.listview);
        databaseHelper = new DatabaseHelper(this);
        arrayList = new ArrayList<>();
        loaddataInListView();
    }
    private void loaddataInListView() {
        arrayList=databaseHelper.getAllData();
        myAdapter=new MyAdapter(this,arrayList);
        myAdapter.notifyDataSetChanged();
        l1.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
}