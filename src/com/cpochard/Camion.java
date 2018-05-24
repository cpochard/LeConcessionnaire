package com.cpochard;

public class Camion extends Vehicule {
	
	protected int PTAC;

	public Camion(String tmpMarque, String tmpCouleur, String tmpModele, int tmpPrix, int tmpPTAC) {
		super(tmpMarque, tmpCouleur, tmpModele, tmpPrix);
		PTAC = tmpPTAC;
	}

	@Override
	public String toString() {
		String s=super.toString();
		s+="[PTAC " + PTAC + "]";
		return s;
	}

}
