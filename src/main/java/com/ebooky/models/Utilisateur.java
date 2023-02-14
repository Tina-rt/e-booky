package com.ebooky.models;

public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String mot_de_passe;
    private int id_role;

    public Utilisateur(int id, String nom, String prenom, String email, String mot_de_passe, int id_role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
        this.id_role = id_role;
    }
    
    public Utilisateur(){
        
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.id) + "-"+this.nom+"-"+String.valueOf(this.id_role);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_role(){
        return this.id_role;
    }
    public void setId_role(int id_role){
        this.id_role = id_role;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
}
