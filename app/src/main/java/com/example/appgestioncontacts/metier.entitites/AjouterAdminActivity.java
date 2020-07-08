package com.example.appgestioncontacts.metier.entitites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appgestioncontacts.R;

public class AjouterAdminActivity extends AppCompatActivity {
    EditText txt1,txt2,txt3,txt4;

    Button btnAnnuler, btnAjouter;
    ImageButton btnRetour;

    Administrateur e=null;
    Dao met= new Dao(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_admin);


        txt1= (EditText) findViewById(R.id.txt_Nom);
        txt2= (EditText) findViewById(R.id.txt_Prenom);
        txt3= (EditText) findViewById(R.id.txt_Adresse);
        txt4= (EditText) findViewById(R.id.txt_Tel);

        btnAjouter= (Button) findViewById(R.id.btn_Ajouter);
        btnAnnuler= (Button) findViewById(R.id.btn_Annuler);

        btnRetour= (ImageButton) findViewById(R.id.btn_retour);


        /********************Annuler**********************/
        btnAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
                txt4.setText("");
            }
        });

        /********************Ajouter**********************/
        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e=new Administrateur();

                e.setNom(txt1.getText().toString());
                e.setPrenom(txt2.getText().toString());
                e.setAdresseMail(txt3.getText().toString());
                e.setTel(txt4.getText().toString());

                met.AjouterAdmin(e);
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
                txt4.setText("");
            }
        });

        /********************Retour**********************/
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(getApplicationContext(),EspaceAdmin.class);
                startActivity(i4);

            }
        });



    }
}
