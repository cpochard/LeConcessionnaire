package com.cpochard;

public class Voiture extends Vehicule {
	
	protected String type;

	public Voiture(String tmpMarque, String tmpCouleur, String tmpModele, int tmpPrix, String tmpType) {
		super(tmpMarque, tmpCouleur, tmpModele, tmpPrix);
		type = tmpType;
	}

	@Override
	public String toString() {
		String s = super.toString();
		s+= "[type " + type + "]";
		return s;
	}

}
