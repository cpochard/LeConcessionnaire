package com.cpochard;

public class Moto extends Vehicule {
	
	protected int cylindree;

	public Moto(String tmpMarque, String tmpCouleur, String tmpModele, int tmpPrix, int tmpcylindree) {
		super(tmpMarque, tmpCouleur, tmpModele, tmpPrix);
		cylindree = tmpcylindree;
	}

	@Override
	public String toString() {
		String s= super.toString();
		s+="[cylindree " + cylindree + "]";
		return s;
	}
	
	

}
