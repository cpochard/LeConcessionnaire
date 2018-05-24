package com.cpochard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AfficherConcession extends JFrame implements ActionListener{

	JPanel panneau;
	JLabel label;
	Concession c;
	Vehicule v;
	JButton boutonVehicule;

	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}

	public AfficherConcession (Concession c) {
		this.c = c;
		//Titre de la fenetre
		this.setTitle("Véhicules contenus dans la concession demandée : " + c.getNom());
		//Taille de la fenetre
		this.setSize(500, 500);
		//Placer la fenetre au centre de l'écran
		this.setLocationRelativeTo(null);
		//Rendre la fenetre visible
		this.setVisible(true);
		//Faire que la croix rouge ferme juste cette fenetre
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		afficherContenuConcession(c);

	}

	public void afficherContenuConcession(Concession c) {
		//Création du panneau
		panneau = new JPanel();
		//Panneau dans Layout pour placer librement les éléments
		panneau.setLayout(null);
		//Fixer le panneau à la fenetre
		this.setContentPane(panneau);

		//Création du label
		label = new JLabel ();
		//On lui donne une position et une taille (gauche, haut, largeur, hauteur)
		label.setBounds(5, 20, 300, 40);
		//Ajouter le label au panneau
		panneau.add(label);
		reaffichageConcession();
		int hauteur = 50;
		for (Vehicule v : c.getList()) {
			boutonVehicule = new JButton();
			boutonVehicule.setText(""+v.getClass().getSimpleName());
			boutonVehicule.setActionCommand("AFF"+ (hauteur-50)/50);
			boutonVehicule.setBounds(5, hauteur, 240, 20);
			hauteur+=50;
			boutonVehicule.addActionListener(this);
			panneau.add(boutonVehicule);
			panneau.repaint();
		}
		vendreVehicule(c);
	}

	public void vendreVehicule(Concession c) {
		int hauteur = 50 ;
		for (Vehicule v : c.getList()) {
			JButton bouton = new JButton();
			bouton.setText("Vendre ce véhicule");
			bouton.setActionCommand("VEN" + (hauteur-50)/50);
			bouton.setBounds(245, hauteur, 240, 20);
			hauteur+=50;
			bouton.addActionListener(this);
			panneau.add(bouton);
			panneau.repaint();
		}
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().substring(0, 3).equals("AFF")) {
			Vehicule tempv = c.getList().get(Integer.parseInt(event.getActionCommand().substring(3)));
			AfficherVehicules fenetreVehicule = new AfficherVehicules();
			fenetreVehicule.afficherInfoVehicule(tempv);
		}
		else if (event.getActionCommand().substring(0, 3).equals("VEN")){
			c.vendre(Integer.parseInt(event.getActionCommand().substring(3)));
		}
		afficherContenuConcession(c);
		panneau.repaint();
	}

	public void reaffichageConcession() {
		label.setText("Nom de la concession : " + c.getNom() + ". Trésorerie : " + c.getTresorerie());
	}
}