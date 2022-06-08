package Entities;

public class Visiteur {
    private int IDVisiteur;
    private String Nom;
    private String Prénom;
    private String Mail;
    private String Telephone;


    public int getIDVisiteur() {
        return IDVisiteur;
    }

    public Visiteur setIDVisiteur(int idVisiteur) {
        IDVisiteur = idVisiteur;
        return this;
    }

    public String getPrénom() {
        return Prénom;
    }

    public Visiteur setPrénom(String prénom) {
        Prénom = prénom;
        return this;
    }

    public String getNom() {
        return Nom;
    }

    public Visiteur setNom(String nom) {
        Nom = nom;
        return this;
    }

    public String getMail() {
        return Mail;
    }

    public Visiteur setMail(String mail) {
        Mail = mail;
        return this;
    }

    public String getTelephone() {
        return Telephone;
    }

    public Visiteur setTelephone(String telephone) {
        Telephone = telephone;
        return this;
    }
}
