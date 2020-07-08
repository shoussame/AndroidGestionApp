package com.example.appgestioncontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.appgestioncontacts.metier.entitites.EspaceAdmin;
import com.example.appgestioncontacts.metier.entitites.EspaceEnseignant;
import com.example.appgestioncontacts.metier.entitites.EspaceEtudiant;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3;
    ImageButton ibtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace);

        btn1= (Button) findViewById(R.id.btn_space_etud);
        btn2= (Button) findViewById(R.id.btn_space_ensg);
        btn3= (Button) findViewById(R.id.btn_space_admn);
        ibtn1= (ImageButton) findViewById(R.id.btn_home);


        /************************Lancer Espace Etudiant****************/

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),EspaceEtudiant.class);
                startActivity(i1);
            }
        });

        /************************Lancer Espace Enseignant****************/

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),EspaceEnseignant.class);
                startActivity(i1);
            }
        });

        /************************Lancer Espace Admin****************/

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),EspaceAdmin.class);
                startActivity(i1);
            }
        });


        /******************Quitter l application **********/
        ibtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
