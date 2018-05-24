package com.cpochard;

import java.util.ArrayList;
import java.util.List;

public class Concession {

	protected String nom;
	protected List<Vehicule> list = new ArrayList<Vehicule>();
	
	public List<Vehicule> getList() {
		return list;
	}
	public void setList(List<Vehicule> list) {
		this.list = list;
	}

	private int tresorerie =0;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTresorerie() {
		return tresorerie;
	}
	public void setTresorerie(int tresorerie) {
		this.tresorerie = tresorerie;
	}

	protected int prix;
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}

	public Concession(String tmpNom) {
		nom = tmpNom;
	}

	public void ajouterVehicule(Vehicule newVehicule) {
		list.add(newVehicule);
	}

	public void getNombreVehicules() {
		System.out.println(list.size());
	}

	public void inventaire() {
		for (Vehicule v : list)
			System.out.println(v.toString());
	}

	public int getValeurStock() {
		int cumul = 0;
		for (Vehicule v : list) {
			cumul = cumul + v.getPrix();
		}
		return cumul;
	}

	public String vendre(int i) {
		String s;
		if (i < list.size()) {
			int prix;
			prix = list.get(i).getPrix();
			list.remove(i);
			tresorerie = tresorerie + prix;
			s = "Vous avez vendu le véhicule numéro " + i + "+1. La trésorerie est maintenant de " + tresorerie + ".";
		} else {
			s = "Le véhicule que vous souhaitez vendre n'existe pas dans la liste.";
		}
		return s;
	}

	public int nombreTypeVehicules(String type) {
		int nbTypeVehicule = 0;
		for (Vehicule v : list)
			if (v.getClass().getSimpleName().equals(type)) {
				nbTypeVehicule++;
			}
		return nbTypeVehicule;
	}

	public int reduction(int pourcentage) {
		int prix = 0;
		int newprix = 0;
		for (Vehicule v : list) {
			prix = v.getPrix();
			newprix = prix - ((prix * pourcentage) / 100);
			v.setPrix(newprix);
		}
		return newprix;
	}
	//Surcharge pour reduction en fonction du type de Vehicule
	public int reduction(int pourcentage, String type) {
		int prix = 0;
		int newprix = 0;
		for (Vehicule v : list) {
			if (v.getClass().getSimpleName().equals(type)) {
			prix = v.getPrix();
			newprix = prix - ((prix * pourcentage) / 100);
			v.setPrix(newprix);
		}
		}
		return newprix;
	}

	public int augmentation(int pourcentage) {
		int prix = 0;
		int newprix = 0;
		for (Vehicule v : list) {
			prix = v.getPrix();
			newprix = prix + ((prix * pourcentage) / 100);
			v.setPrix(newprix);
		}
		return newprix;
	}
	//Surcharge pour augmentation en fonction du type de Vehicule
	public int augmentation(int pourcentage, String type) {
		int prix = 0;
		int newprix = 0;
		for (Vehicule v : list) {
			if (v.getClass().getSimpleName().equals(type)) {
			prix = v.getPrix();
			newprix = prix + ((prix * pourcentage) / 100);
			v.setPrix(newprix);
		}
		}
		return newprix;
	}
	
	public String liquidationMarque(String marque) {
		String s = "";
		//On parcourt la liste en partant de la fin
		for (int i=list.size()-1 ; i>=0 ; i--) {
			Vehicule v = list.get(i);
			if (v.getMarque().equals(marque)) {
				vendre(i);
			}
		}
		return s += "Liquidation des vehicules de la marque " + marque;
	}

	@Override
	public String toString() {
		return "Concession [nom=" + nom + ", list=" + list + ", tresorerie=" + tresorerie + ", prix=" + prix + "]";
	}
	
	
}

