package com.ebooky.models;

public class Stock {
	private int id;
	private int id_livre;
	private int quantite;
	private String date;
	
	
	
	public Stock(int id, int id_livre, int quantite, String date) {
		super();
		this.id = id;
		this.id_livre = id_livre;
		this.quantite = quantite;
		this.date = date;
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
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}