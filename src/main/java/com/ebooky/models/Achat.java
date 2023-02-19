package com.ebooky.models;

public class Achat {
	private int id;
	private int id_utilisateur;
	private int id_livre;
	private int id_type_paiement;
	private int id_commande;
	
	
	
	public Achat(int id, int id_utilisateur, int id_livre, int id_type_paiement, int id_commande) {
		super();
		this.id = id;
		this.id_utilisateur = id_utilisateur;
		this.id_livre = id_livre;
		this.id_type_paiement = id_type_paiement;
		this.id_commande = id_commande;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public int getId_livre() {
		return id_livre;
	}
	public void setId_livre(int id_livre) {
		this.id_livre = id_livre;
	}
	public int getId_type_paiement() {
		return id_type_paiement;
	}
	public void setId_type_paiement(int id_type_paiement) {
		this.id_type_paiement = id_type_paiement;
	}
	public int getId_commande() {
		return id_commande;
	}
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	
}
