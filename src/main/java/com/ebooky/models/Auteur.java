package com.ebooky.models;

import com.ebooky.dao.AuteurDao;
import com.ebooky.dbconn.Connexion;

public class Auteur {
	private int id;
	private String nom;
	
        public Auteur(){
            
        }
        public Auteur(String nom){
            this.nom = nom;
        }
        
        public Auteur(int id){
            this.id = id;
            AuteurDao auteurDao = new AuteurDao(Connexion.getConnexion());
            Auteur current_auteur = auteurDao.selectAuteurById(id);
            System.out.println(current_auteur);
            this.nom = current_auteur.getNom();
        }
        
	public Auteur(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

    @Override
    public String toString() {
        return "Auteur{" + "id=" + id + ", nom=" + nom + '}';
    }
	
}
