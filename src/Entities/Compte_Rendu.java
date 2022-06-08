package Entities;

import java.util.Date;

public class Compte_Rendu {
    private int NumCR;
    private int NumVisite;
    private String Contenu;
    private Date Date;
    private String Lieu;
    private int IDVisiteur;


    public int getNumCR() {
        return NumCR;
    }

    public Compte_Rendu setNumCR(int numCR) {
        NumCR = numCR;
        return this;
    }

    public int getNumVisite() {
        return NumVisite;
    }

    public Compte_Rendu setNumVisite(int numVisite) {
        NumVisite = numVisite;
        return this;
    }

    public String getContenu() {
        return Contenu;
    }

    public Compte_Rendu setContenu(String contenu) {
        Contenu = contenu;
        return this;
    }

    public Date getDate() {
        return Date;
    }

    public Compte_Rendu setDate(java.util.Date date) {
        Date = date;
        return this;
    }

    public String getLieu() {
        return Lieu;
    }

    public Compte_Rendu setLieu( String lieu) {
        Lieu = lieu;
        return this;
    }

    public int getIDVisiteur() {
        return IDVisiteur;
    }

    public Compte_Rendu setIDVisiteur(int IDVisiteur) {
        IDVisiteur = IDVisiteur;
        return this;
    }
}
