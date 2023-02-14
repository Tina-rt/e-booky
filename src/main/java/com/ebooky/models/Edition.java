package com.ebooky.models;

public class Edition {
	private int id;
	private String nom;
	
	public Edition(){
            this.id = 0;
            this.nom = "";
        }
	
	public Edition(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
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

    @Override
    public String toString() {
        return "Edition{" + "id=" + id + ", nom=" + nom + '}';
    }
        
        
	
}
