package com.ebooky.models;

public class Livre {
    private int id;
    private String titre;
    private String description;
    private double prix;
    private String date_de_publication;
    private int id_langue;
    private String page_couverture;

    public Livre(int id, String titre, String description, double prix, String date_de_publication, int id_langue) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.date_de_publication = date_de_publication;
        this.id_langue = id_langue;
        this.page_couverture = "";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDate_de_publication() {
        return date_de_publication;
    }

    public void setDate_de_publication(String date_de_publication) {
        this.date_de_publication = date_de_publication;
    }

    public int getId_langue() {
        return id_langue;
    }

    public void setId_langue(int id_langue) {
        this.id_langue = id_langue;
    }

	public String getPage_couverture() {
		return page_couverture;
	}

	public void setPage_couverture(String page_couverture) {
		this.page_couverture = page_couverture;
	}
}
