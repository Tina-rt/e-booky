package com.ebooky.models;

public class Commande {
	private int id;
	private float total;
	private boolean validee;
	
	public Commande(int id, float total, boolean validee) {
		this.id = id;
		this.total = total;
		this.validee = validee;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public boolean isValidee() {
		return validee;
	}
	public void setValidee(boolean validee) {
		this.validee = validee;
	}
	
}
