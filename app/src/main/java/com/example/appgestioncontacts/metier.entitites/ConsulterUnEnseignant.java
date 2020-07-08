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

public class ConsulterUnEnseignant extends AppCompatActivity {
    ImageButton btnRetour;
    TextView txtNom,txtPrenom,txtAdress,txtTel;
    EditText code;
    Button btnOK,btnD,btnM;

    Dao met= new Dao(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulter_un_enseignant);


        txtNom= (TextView) findViewById(R.id.nonValeur);
        txtPrenom= (TextView) findViewById(R.id.prenomValeur);
        txtAdress= (TextView) findViewById(R.id.adresseValeur);
        txtTel= (TextView) findViewById(R.id.TelValeur);

        code= (EditText) findViewById(R.id.txtCodeEtudiant);

        btnOK= (Button) findViewById(R.id.btnChercher);
        btnRetour = (ImageButton) findViewById(R.id.btn_retour);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNom.setText("");
                txtPrenom.setText("");
                txtAdress.setText("");
                txtTel.setText("");
                String s= code.getText().toString();
                Enseignant e=met.ConsulterEnseignantById(Integer.parseInt(s));

                txtNom.setText(e.getNom());
                txtPrenom.setText(e.getPrenom());
                txtAdress.setText(e.getAdresseMail());
                txtTel.setText(e.getTel());
            }
        });
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),EspaceEnseignant.class);
                startActivity(i1);
            }
        });
        btnM = (Button) findViewById(R.id.btnModifier);
        btnD = (Button) findViewById(R.id.btnSupprimer);
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                met.UpdateEnseignant(code.getText().toString(),txtNom.getText().toString()
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
                met.DeleteEnseignant(code.getText().toString());
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
