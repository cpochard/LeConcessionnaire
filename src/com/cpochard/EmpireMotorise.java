package com.cpochard;

import java.util.ArrayList;
import java.util.List;

public class EmpireMotorise {
	
	@Override
	public String toString() {
		return "EmpireMotorise [nom=" + nom + ", listeConcession=" + listeConcession + ", tresorerie=" + tresorerie
				+ "]";
	}

	protected String nom;
	protected List<Concession> listeConcession = new ArrayList<Concession>();
	protected int tresorerie;
	
	public int getTresorerie() {
		return tresorerie;
	}
	public void setTresorerie(int tresorerie) {
		this.tresorerie = tresorerie;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public List<Concession> getListeConcession() {
		return listeConcession;
	}
	public void setListeConcession(List<Concession> listeConcession) {
		this.listeConcession = listeConcession;
	}

	public EmpireMotorise(String tmpNom) {
		nom = tmpNom;
	}
	
	public void ajouterConcession(Concession newConcession) {
		listeConcession.add(newConcession);
	}
	
	public String vendre(int i) {
		String s;
		if (i <= listeConcession.size()) {
			tresorerie = tresorerie + listeConcession.get(i).getTresorerie();
			listeConcession.remove(i);
			s = "Vous avez vendu la concession numéro " + i + "+1. La trésorerie est maintenant de " + tresorerie + ".";
		} else {
			s = "La concession que vous souhaitez vendre n'existe pas dans la liste.";
		}
		return s;
	}
	
	public void inventaireConcession() {
		for (Concession c : listeConcession)
			System.out.println(c.toString());
	}
	
	public String valeurEmpire() {
		String s="";
		int cumulValeurVehicules =0;
		int cumulTresorerieConcession =0;
		for (Concession c : listeConcession) {
			cumulValeurVehicules = cumulValeurVehicules + c.getValeurStock();
			cumulTresorerieConcession = cumulTresorerieConcession + c.getTresorerie();
		}
		s+="La valeur cumulée des véhicules dans toutes les concessions est de : " +cumulValeurVehicules;
		s+="\nLa valeur cumulée des trésorerie des concessions est de : " + cumulTresorerieConcession ;
		s+="\nLa trésorerie de mon Empire est de : " + tresorerie;
		return s;
	}
	
	public void deplacerStock(int iV, int iR) {
			List<Vehicule> aVider =listeConcession.get(iV).getList();
			//Concession aRemplir = listeConcession.get(iR);
			//Pour chaque vehicule de ma liste aVider..
			for (Vehicule v : aVider) {
				//Je l'ajoute a ma liste de concession a remplir
				listeConcession.get(iR).getList().add(v);
			}
			//Et ensuite je vide ma liste à Vider, mais en dehors du for, car uniquement une fois que le transfert a été fait
			listeConcession.get(iV).getList().clear();	
			System.out.println("Le stock de la concession "+ iV + " a été vidé dans la concession " + iR);
			}
			
		
	}


