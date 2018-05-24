package com.cpochard;

public abstract class Vehicule {
	
	protected String marque;
	protected String couleur;
	protected String modele;
	protected int prix;
	
	public Vehicule (String tmpMarque, String tmpCouleur, String tmpModele, int tmpPrix) {
		marque = tmpMarque;
		couleur = tmpCouleur;
		modele = tmpModele;
		prix = tmpPrix;
	}

	@Override
	public String toString() {
		return "Vehicule [marque=" + marque + ", couleur=" + couleur + ", modele=" + modele + ", prix=" + prix + "]";
	}
	
	public String getMarque() {
		return marque;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String newCouleur) {
	couleur = newCouleur;
	}
	public String getModele() {
		return modele;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int newPrix) {
		prix = newPrix;
	}
}
