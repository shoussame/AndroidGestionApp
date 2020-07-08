package com.example.appgestioncontacts.metier.entitites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appgestioncontacts.R;

public class EspaceAdmin extends AppCompatActivity {
    Button btn1,btn2,btn3;
    ImageButton retourBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_admin);

        retourBtn= (ImageButton) findViewById(R.id.btn_retour);

        btn1= (Button) findViewById(R.id.btn_ajouter_ad);
        btn2= (Button) findViewById(R.id.btn_Consulter_ad);
        btn3= (Button) findViewById(R.id.btn_Consultertout_ad);

        /******************** Lancer Ajouter Ensgnt*************/
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1=new Intent(getApplicationContext(),AjouterEngntActivity.class);
                startActivity(i1);
            }
        });
        /******************** Lancer Consulter Ensgnt*************/
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getApplicationContext(),ConsulterUnEnseignant.class);
                startActivity(i2);

            }
        });
        /******************** Lancer Consulter tous Ensgnt*************/
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(getApplicationContext(),ConsulterToutEnseignant.class);
                startActivity(i3);

            }
        });

        /******************** Retour*************/
        retourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(getApplicationContext(),EspaceActivity.class);
                startActivity(i4);

            }
        });
    }
}
