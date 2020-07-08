package com.example.appgestioncontacts.metier.entitites;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dao extends SQLiteOpenHelper {
    private static  final  String NAME_DB="CONTACTDB";
    private static final  int VERSION_DB=2;

    private  static  final  String ID_ETUDIANT="idEtudiant";
    private  static  final  String NOM_ETUDIANT="nomEtudiant";
    private  static  final  String PRENOM_ETUDIANT="prenomEtudiant";
    private  static  final  String ADRESSE_ETUDIANT="adresseMailEtudiant";
    private  static  final  String TEL_ETUDIANT="telEtudiant";
    private  static  final  String NAME_TABLE1="ETUDIANT";

    private  static  final  String ID_ENSEIGNANT="id";
    private  static  final  String NOM_ENSEIGNANT="nom";
    private  static  final  String PRENOM_ENSEIGNANT="prenom";
    private  static  final  String ADRESSE_ENSEIGNANT="adresseMail";
    private  static  final  String TEL_ENSEIGNANT="tel";
    private  static  final  String NAME_TABLE2="ENSEIGNANT";

    private  static  final  String ID_ADMIN="id";
    private  static  final  String NOM_ADMIN="nom";
    private  static  final  String PRENOM_ADMIN="prenom";
    private  static  final  String ADRESSE_ADMIN="adresseMail";
    private  static  final  String TEL_ADMIN="tel";
    private  static  final  String NAME_TABLE3="ADMIN";

    public  Dao(Context c){
        super(c,NAME_DB,null,VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " +NAME_TABLE1 +" ("
                        + ID_ETUDIANT + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                NOM_ETUDIANT +" TEXT,"+ PRENOM_ETUDIANT +" TEXT,"+ADRESSE_ETUDIANT +" TEXT,"+ TEL_ETUDIANT+" TEXT);");
        db.execSQL("CREATE TABLE " +NAME_TABLE2 +" ("
                + ID_ADMIN + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                NOM_ADMIN +" TEXT,"+ PRENOM_ADMIN +" TEXT,"+ADRESSE_ADMIN +" TEXT,"+ TEL_ADMIN+" TEXT);");
        db.execSQL("CREATE TABLE " +NAME_TABLE3 +" ("
                + ID_ADMIN + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                NOM_ADMIN +" TEXT,"+ PRENOM_ADMIN +" TEXT,"+ADRESSE_ADMIN +" TEXT,"+ TEL_ADMIN+" TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS NAME_TABLE1");
        db.execSQL("DROP TABLE IF EXISTS NAME_TABLE2");
        db.execSQL("DROP TABLE IF EXISTS NAME_TABLE3");
        this.onCreate(db);
    }


    public void AjouterEtudiant(Etudiant e){

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put(NOM_ETUDIANT,e.getNomEtudiant());
        values.put(PRENOM_ETUDIANT,e.getPrenomEtudiant());
        values.put(ADRESSE_ETUDIANT,e.getAdresseMailEtudiant());
        values.put(TEL_ETUDIANT,e.getTelEtudiant());

        db.insert(NAME_TABLE1,null,values);
        db.close();

    }


    public Etudiant ConsulterEtudiantById(int id){

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor c=db.query(NAME_TABLE1, new String[] {ID_ETUDIANT,NOM_ETUDIANT,PRENOM_ETUDIANT,ADRESSE_ETUDIANT,TEL_ETUDIANT}, ID_ETUDIANT + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);

        if(c!=null) c.moveToFirst();

        Etudiant et=new Etudiant();

        et.setIdEtudiant(Integer.parseInt(c.getString(0)));
        et.setNomEtudiant(c.getString(1));
        et.setPrenomEtudiant(c.getString(2));
        et.setAdresseMailEtudiant(c.getString(3));
        et.setTelEtudiant(c.getString(4));

        return et;
    }

    public void AjouterEnseignant(Enseignant e){

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put(NOM_ENSEIGNANT,e.getNom());
        values.put(PRENOM_ENSEIGNANT,e.getPrenom());
        values.put(ADRESSE_ENSEIGNANT,e.getAdresseMail());
        values.put(TEL_ENSEIGNANT,e.getTel());

        db.insert(NAME_TABLE2,null,values);
        db.close();

    }


    public Enseignant ConsulterEnseignantById(int id){

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor c=db.query(NAME_TABLE2, new String[] {ID_ENSEIGNANT,NOM_ENSEIGNANT,PRENOM_ENSEIGNANT,ADRESSE_ENSEIGNANT,TEL_ENSEIGNANT}, ID_ENSEIGNANT + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);

        if(c!=null) c.moveToFirst();

        Enseignant et=new Enseignant();

        et.setId(Integer.parseInt(c.getString(0)));
        et.setNom(c.getString(1));
        et.setPrenom(c.getString(2));
        et.setAdresseMail(c.getString(3));
        et.setTel(c.getString(4));

        return et;
    }

    public void AjouterAdmin(Administrateur e){

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put(NOM_ADMIN,e.getNom());
        values.put(PRENOM_ADMIN,e.getPrenom());
        values.put(ADRESSE_ADMIN,e.getAdresseMail());
        values.put(TEL_ADMIN,e.getTel());

        db.insert(NAME_TABLE3,null,values);
        db.close();

    }


    public Administrateur ConsulterAdminById(int id){

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor c=db.query(NAME_TABLE3, new String[] {ID_ADMIN,NOM_ADMIN,PRENOM_ADMIN,ADRESSE_ADMIN,TEL_ADMIN}, ID_ADMIN + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);

        if(c!=null) c.moveToFirst();

        Administrateur et=new Administrateur();

        et.setId(Integer.parseInt(c.getString(
                0)));
        et.setNom(c.getString(1));
        et.setPrenom(c.getString(2));
        et.setAdresseMail(c.getString(3));
        et.setTel(c.getString(4));

        return et;
    }

    public Cursor getListContentsEt(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + NAME_TABLE1, null);
        return data;
    }
    public Cursor getListContentsEn(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + NAME_TABLE2, null);
        return data;
    }
    public Cursor getListContentsAd(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + NAME_TABLE3, null);
        return data;
    }

    public void DeleteEtudiant(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(NAME_TABLE1,"idEtudiant = ?",new String[] {id});
    }
    public void DeleteEnseignant(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(NAME_TABLE2,"id = ?",new String[] {id});
    }
    public void DeleteAdmin(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(NAME_TABLE3,"id = ?",new String[] {id});
    }
    public boolean UpdateEnseignant(String id,String nom,String prenom,String tel,String adresse){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(NOM_ENSEIGNANT,nom);
        values.put(PRENOM_ENSEIGNANT,prenom);
        values.put(TEL_ENSEIGNANT,tel);
        values.put(ADRESSE_ENSEIGNANT,adresse);
        db.update(NAME_TABLE2,values,"id=?",new String[] {id});
        return true;
    }
    public boolean UpdateEtudiant(String id,String nom,String prenom,String tel,String adresse){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(NOM_ETUDIANT,nom);
        values.put(PRENOM_ETUDIANT,prenom);
        values.put(TEL_ETUDIANT,tel);
        values.put(ADRESSE_ETUDIANT,adresse);
        db.update(NAME_TABLE1,values,"idEtudiant=?",new String[] {id});
        return true;
    }
    public boolean UpdateAdmin(String id,String nom,String prenom,String tel,String adresse){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(NOM_ADMIN,nom);
        values.put(PRENOM_ADMIN,prenom);
        values.put(TEL_ADMIN,tel);
        values.put(ADRESSE_ADMIN,adresse);
        db.update(NAME_TABLE3,values,"id=?",new String[] {id});
        return true;
    }
}
