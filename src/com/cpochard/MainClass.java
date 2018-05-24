package com.cpochard;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {

		Moto maMoto = new Moto ("Toyota", "bleue", "T1", 12000, 20);
		Voiture maVoiture = new Voiture ("Renault", "grise", "Clio", 5000, "citadine");
		Camion monCamion = new Camion ("Peugeot", "gris", "46 Tonnes", 50000, 2500);
		Concession maConcession = new Concession ("Chopes ta caisse");
		Concession maConcession2 = new Concession ("Chez Jo");
		Camion monCamion2 = new Camion ("Toyota", "noir", "50 Tonnes", 4000, 2600);
		EmpireMotorise monEmpire = new EmpireMotorise ("EMPIRE");
		Concession maConcession3 = new Concession ("Chez WIWI");
		
		//Afficher maMoto
		System.out.println(maMoto.toString());
		
		//Afficher maVoiture
		System.out.println(maVoiture.toString());
		
		//Afficher monCamion
		System.out.println(monCamion.toString());
		
		//Ajouter des vehicules a ma concession
		maConcession.ajouterVehicule(maMoto);
		maConcession.ajouterVehicule(monCamion2);
		maConcession.ajouterVehicule(maVoiture);
		maConcession.ajouterVehicule(monCamion);
		maConcession.getNombreVehicules();
		
		//Afficher l'ensemble des véhicules dans ma concession
		maConcession.inventaire();
		
		//Afficher le cumul des prix des véhicules présents dans ma concession
		System.out.println(maConcession.getValeurStock());
		
		//Vendre le 3e vehicule (i+1 soit 2+1), donc on vend le camion 
		//Et on affiche la trésorerie qui contient maintenant le prix du camion
		System.out.println(maConcession.vendre(2));
		
		//Afficher le nombre de vehicules de type Moto dans ma concession
		System.out.println(maConcession.nombreTypeVehicules("Moto"));
		
		//Faire une réduction de 10% du prix de tous les vehicules de ma concession
		//Attention affiche uniquement le dernier élément de la liste de véhicule
		//Si on veut voir modif des prix des autres vehicules de la liste, besoin de faire un inventaire
		System.out.println(maConcession.reduction(10));
		//Idem avec une augmentation de 5%
		System.out.println(maConcession.augmentation(5));
		
		maConcession.inventaire();
		
		//Vendre les vehicules de la marque Toyota
		System.out.println(maConcession.liquidationMarque("Toyota"));
		//Verifier qu'on a bien supprimé les vehicules toyota
		maConcession.inventaire();
		
		//Faire une réduction uniquement sur type Camion (grace à surcharge de méthode reduction)
		System.out.println(maConcession.reduction(10, "Camion"));
		//Faire une augmentation uniquement sur type Camion (grace à surcharge de méthode reduction)
		System.out.println(maConcession.augmentation(10, "Camion"));
		
		//J'ajoute deux concessions dans mon Empire (et je n'oublie pas d'ajouter des véhicules dans ma nouvelle concession)
		monEmpire.ajouterConcession(maConcession);
		monEmpire.ajouterConcession(maConcession2);
		maConcession2.ajouterVehicule(monCamion);
		maConcession2.ajouterVehicule(maVoiture);
		maConcession.ajouterVehicule(maMoto);
		maConcession.ajouterVehicule(maVoiture);
		//Je vérifie les véhicules dans ma concession, je vend le premier véhicule de ma concession2 (je vérifie qu'il est bien vendu)
		monEmpire.inventaireConcession();
		System.out.println(maConcession2.vendre(0));
		monEmpire.inventaireConcession();
		//Je vérifie que suite à cette vente j'ai bien augmenté le cumul de trésorerie de mes concessions
		monEmpire.valeurEmpire();
		//Je vend ma première concession et je vérifie que la trésorerie de mon empire a bien été implémentée par sa trésorerie
		System.out.println(monEmpire.vendre(0));
		monEmpire.valeurEmpire();
		
		//J'ajoute une nouvelle concession3 a mon Empire
		monEmpire.ajouterConcession(maConcession3);
		maConcession3.ajouterVehicule(maMoto);
		monEmpire.inventaireConcession();
		monEmpire.deplacerStock(0, 1);
		monEmpire.inventaireConcession();
		
		//Créer une fenetre et ajouter du texte sur le JLabel
		AfficherEmpire fenetre = new AfficherEmpire (monEmpire);
		fenetre.afficherConcessions(monEmpire);
		

	}

}
