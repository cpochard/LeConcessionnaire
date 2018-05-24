package com.cpochard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AfficherEmpire extends JFrame implements ActionListener{
	//Attributs de la classe éléments graphiques
	private JPanel panneau;
	JLabel label;
	EmpireMotorise e;
	Concession c;
	JButton boutonConcession;

	public AfficherEmpire  (EmpireMotorise e) {
		this.e=e;
		//Titre de la fenetre
		this.setTitle("Bienvenue dans l'empire : " + e.getNom());
		//Taille de la fenetre
		this.setSize(800, 800);
		//Placer la fenetre au centre de l'écran
		this.setLocationRelativeTo(null);
		//Rendre la fenetre visible
		this.setVisible(true);
		//Faire que la croix rouge ferme le programme
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		afficherConcessions(e);
	}

	public void afficherConcessions (EmpireMotorise e) {
		//Création du panneau
		panneau = new JPanel();
		//Panneau dans Layout pour placer librement les éléments
		panneau.setLayout(null);
		//Fixer le panneau à la fenetre
		this.setContentPane(panneau);

		//Création du label
		label = new JLabel ();
		//On lui donne une position et une taille (gauche, haut, largeur, hauteur)
		label.setBounds(5, 20, 800, 50);
		//Ajouter le label au panneau
		panneau.add(label);
		reaffichageEmpire();

		JButton boutonSauvegarde = new JButton();
		boutonSauvegarde.setText("Sauvegarder");
		boutonSauvegarde.setActionCommand("boutonSauvegarde");
		boutonSauvegarde.setBounds(5, 500, 240, 50);
		boutonSauvegarde.addActionListener(this);
		panneau.add(boutonSauvegarde);
		panneau.repaint();
		
		JButton boutonChargement = new JButton();
		boutonChargement.setText("Chargement");
		boutonChargement.setActionCommand("boutonChargement");
		boutonChargement.setBounds(250, 500, 240, 50);
		boutonChargement.addActionListener(this);
		panneau.add(boutonChargement);
		panneau.repaint();

		int hauteur = 50;
		for (Concession c : e.getListeConcession()) {
			//Création d'un bouton
			boutonConcession = new JButton();
			boutonConcession.setText("<html>Nom de la concession : " + c.getNom() + "<br>Trésorerie : " + c.getTresorerie());
			boutonConcession.setActionCommand("AFF"+(hauteur-50)/50);
			boutonConcession.setBounds(5, hauteur, 240, 50);
			hauteur+=50;
			boutonConcession.addActionListener(this);	
			panneau.add(boutonConcession);
			panneau.repaint();
		}
		reductionConcession(e);
		vendreConcession(e);
	}

	public void reductionConcession (EmpireMotorise e) {
		int hauteur = 50;
		for (Concession c : e.getListeConcession()) {
			JButton bouton = new JButton();
			bouton.setText("Faire une réduction de 10%");
			bouton.setActionCommand("RED" + (hauteur-50)/50);
			bouton.setBounds(245, hauteur, 240, 50);
			hauteur+=50;
			bouton.addActionListener(this);
			panneau.add(bouton);
			panneau.repaint();
		}
	}

	public void vendreConcession (EmpireMotorise e) {
		int hauteur = 50;
		for (Concession c : e.getListeConcession()) {
			JButton bouton = new JButton();
			bouton.setText("Vendre cette concession");
			bouton.setActionCommand("VEN"+(hauteur-50)/50);
			bouton.setBounds(485, hauteur, 240, 50);
			hauteur+=50;
			bouton.addActionListener(this);
			panneau.add(bouton);
			panneau.repaint();
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("boutonSauvegarde")) {
			sauvegarder();
		}
		else if (event.getActionCommand().equals("boutonChargement")) {
			charger();
		}
		else if (event.getActionCommand().substring(0, 3).equals("AFF")) {
			Concession tempc = e.getListeConcession().get(Integer.parseInt(event.getActionCommand().substring(3)));
			AfficherConcession fenetreConcession = new AfficherConcession(tempc);
			fenetreConcession.afficherContenuConcession(tempc);
		}
		else if (event.getActionCommand().substring(0, 3).equals("RED")) {
			Concession tempc = e.getListeConcession().get(Integer.parseInt(event.getActionCommand().substring(3)));
			tempc.reduction(10);
		}
		else if (event.getActionCommand().substring(0, 3).equals("VEN")){
			e.vendre(Integer.parseInt(event.getActionCommand().substring(3)));
		}
		afficherConcessions(e);
		panneau.repaint();
	}


	public void reaffichageEmpire () {
		label.setText("Nom de l'empire : " + e.getNom() + ". Trésorerie : " + e.getTresorerie());
	}

	public void sauvegarder () {
		File fichier = new File ("sauvegarde.txt");
		FileWriter flux;
		BufferedWriter fluxTampon;
		try {
			fluxTampon = new BufferedWriter (new FileWriter (fichier));
			fluxTampon.write(e.toString());
			fluxTampon.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void charger() {
		File fichier = new File ("sauvegarde.txt");
		FileReader flux;
		BufferedReader fluxTampon;
		try {
			fluxTampon = new BufferedReader (new FileReader (fichier));
			String ligne, contenuFichier = "";
			while ((ligne = fluxTampon.readLine()) != null)
				contenuFichier += ligne;
			//System.out.println(contenuFichier);
			fluxTampon.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}



