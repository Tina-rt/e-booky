package com.ebooky.models;

public class Ebook {
	private int id;
	private int id_livre;
	private float taille;
	private String extension;
	
	
	
	public Ebook(int id, int id_livre, float taille, String extension) {
		super();
		this.id = id;
		this.id_livre = id_livre;
		this.taille = taille;
		this.extension = extension;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_livre() {
		return id_livre;
	}
	public void setId_livre(int id_livre) {
		this.id_livre = id_livre;
	}
	public float getTaille() {
		return taille;
	}
	public void setTaille(float taille) {
		this.taille = taille;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	
}
