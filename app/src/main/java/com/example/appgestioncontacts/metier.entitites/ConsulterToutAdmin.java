package com.example.appgestioncontacts.metier.entitites;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appgestioncontacts.R;

import java.util.ArrayList;

public class ConsulterToutAdmin extends AppCompatActivity {
    Dao dao;
    ImageButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulter_tout_admin);

        btn = (ImageButton) findViewById(R.id.btn_home);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),EspaceEtudiant.class);
                startActivity(i1);
            }
        });
        ListView listView = (ListView) findViewById(R.id.listview_ad);
        dao = new Dao(this);

        //populate an ArrayList<String> from the database and then view it
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = dao.getListContentsAd();

        while(data.moveToNext()){
            theList.add(data.getString(1));
            ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
            listView.setAdapter(listAdapter);
        }

    }
}
