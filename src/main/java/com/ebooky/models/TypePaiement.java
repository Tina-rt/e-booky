package com.ebooky.models;

public class TypePaiement {
	private int id;
	private String label;
	
	
	
	public TypePaiement(int id, String label) {
		
		this.id = id;
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
