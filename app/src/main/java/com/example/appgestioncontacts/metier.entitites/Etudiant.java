package com.example.appgestioncontacts.metier.entitites;

public class Etudiant {
    private int idEtudiant;
    private  String nomEtudiant, prenomEtudiant,adresseMailEtudiant,telEtudiant;

    public Etudiant(String nomEtudiant, String prenomEtudiant, String adresseMailEtudiant, String telEtudiant) {
        this.nomEtudiant = nomEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.adresseMailEtudiant = adresseMailEtudiant;
        this.telEtudiant = telEtudiant;
    }

    public Etudiant() {

    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public String getAdresseMailEtudiant() {
        return adresseMailEtudiant;
    }

    public String getTelEtudiant() {
        return telEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public void setAdresseMailEtudiant(String adresseMailEtudiant) {
        this.adresseMailEtudiant = adresseMailEtudiant;
    }

    public void setTelEtudiant(String telEtudiant) {
        this.telEtudiant = telEtudiant;
    }



}
