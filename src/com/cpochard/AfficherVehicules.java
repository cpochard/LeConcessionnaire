package com.cpochard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AfficherVehicules extends JFrame {
	
	private JPanel panneau;
	JLabel label;
	
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}

	JButton bouton;

	public AfficherVehicules () {
		//Titre de la fenetre
		this.setTitle("Informations du véhicule demandé");
		//Taille de la fenetre
		this.setSize(500, 500);
		//Placer la fenetre au centre de l'écran
		this.setLocationRelativeTo(null);
		//Rendre la fenetre visible
		this.setVisible(true);
		//Faire que la croix rouge ferme juste cette fenetre
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//Création du panneau
		panneau = new JPanel();
		//Panneau dans Layout pour placer librement les éléments
		panneau.setLayout(null);
		//Fixer le panneau à la fenetre
		this.setContentPane(panneau);
		
		//Création du label
		label = new JLabel ();
		//On lui donne une position et une taille (gauche, haut, largeur, hauteur)
		label.setBounds(5, 20, 500, 20);
		//Ajouter le label au panneau
		panneau.add(label);
	
	}
	
	public void afficherInfoVehicule(Vehicule v) {
		label.setText(v.toString());
	}

}
