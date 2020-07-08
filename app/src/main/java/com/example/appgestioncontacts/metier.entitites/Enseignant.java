package com.example.appgestioncontacts.metier.entitites;

public class Enseignant {
    private int id;
    private  String nom, prenom,adresseMail,tel;

    public Enseignant() {
    }

    public Enseignant(String nom, String prenom, String adresseMail, String tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
