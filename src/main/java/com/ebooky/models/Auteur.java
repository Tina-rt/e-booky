package com.ebooky.models;

public class Auteur {
	private int id;
	private String nom;
	
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
	
}
