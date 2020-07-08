package com.example.appgestioncontacts.metier.entitites;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appgestioncontacts.R;

public class ConsulterUnEtudiant extends AppCompatActivity {

    ImageButton btnRetour;
    EditText txtNom,txtPrenom,txtAdress,txtTel;
    EditText code;
    Button btnOK,btnM,btnD;

    Dao met= new Dao(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulter_un_etudiant);


        txtNom= (EditText) findViewById(R.id.nonValeur);
        txtPrenom= (EditText) findViewById(R.id.prenomValeur);
        txtAdress= (EditText) findViewById(R.id.adresseValeur);
        txtTel= (EditText) findViewById(R.id.TelValeur);

        code= (EditText) findViewById(R.id.txtCodeEtudiant);
        btnRetour = (ImageButton) findViewById(R.id.btn_retour);
        btnOK= (Button) findViewById(R.id.btnChercher);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s= code.getText().toString();
                Etudiant e=met.ConsulterEtudiantById(Integer.parseInt(s));

                txtNom.setText(e.getNomEtudiant());
                txtPrenom.setText(e.getPrenomEtudiant());
                txtAdress.setText(e.getAdresseMailEtudiant());
                txtTel.setText(e.getTelEtudiant());
            }
        });

        btnM = (Button) findViewById(R.id.btnModifier);
        btnD = (Button) findViewById(R.id.btnSupprimer);
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                met.UpdateEtudiant(code.getText().toString(),txtNom.getText().toString()
                        ,txtPrenom.getText().toString(),txtTel.getText().toString(),txtAdress.getText().toString());
                txtNom.setText("");
                txtPrenom.setText("");
                txtAdress.setText("");
                txtTel.setText("");
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                met.DeleteEtudiant(code.getText().toString());
                txtNom.setText("");
                txtPrenom.setText("");
                txtAdress.setText("");
                txtTel.setText("");
            }
        });
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),EspaceEtudiant.class);
                startActivity(i1);
            }
        });

    }
}
