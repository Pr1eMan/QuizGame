package com.ifk8edvmat1gabkojginkir.ktuprojektas.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ifk8edvmat1gabkojginkir.ktuprojektas.Model.Player;
import com.ifk8edvmat1gabkojginkir.ktuprojektas.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Player> arrayList;

    public MyAdapter(Context context, ArrayList<Player> arrayList){
        this.context=context;
        this.arrayList=arrayList;

    }


    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item,null);
        TextView t1_id=(TextView)convertView.findViewById(R.id.UNAME);
        TextView t2_id=(TextView)convertView.findViewById(R.id.SCORE);
        Player player= arrayList.get(position);

        t1_id.setText(player.getUNAME());
        t2_id.setText(String.valueOf(player.getSCORE()));

        return convertView;
    }
}
