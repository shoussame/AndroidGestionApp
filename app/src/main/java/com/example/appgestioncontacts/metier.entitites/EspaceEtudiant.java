package com.example.appgestioncontacts.metier.entitites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appgestioncontacts.R;

public class EspaceEtudiant extends AppCompatActivity {

    Button btn1,btn2,btn3;
    ImageButton retourBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_etudiant);

        retourBtn= (ImageButton) findViewById(R.id.btn_retour);

        btn1= (Button) findViewById(R.id.btn_ajouter_etud);
        btn2= (Button) findViewById(R.id.btn_Consulter_etud);
        btn3= (Button) findViewById(R.id.btn_Consultertout_etud);

        /******************** Lancer Ajouter Etudiant*************/
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1=new Intent(getApplicationContext(),AjouterEtudiantActivity.class);
                startActivity(i1);
            }
        });
        /******************** Lancer Consulter Etudiant*************/
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getApplicationContext(),ConsulterUnEtudiant.class);
                startActivity(i2);

            }
        });
        /******************** Lancer Consulter tous Etudiant*************/
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(getApplicationContext(),ConsulterToutEtudiants.class);
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
