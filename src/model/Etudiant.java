package model;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;

public class Etudiant extends Utilisateur{
	
	private int idEtudiant;
	public SimpleStringProperty nom;
	public SimpleStringProperty prenom;
	private SimpleDateFormat dateDeNaissance; 
	private SimpleStringProperty niveauEtude;
	private SimpleStringProperty adresseMail;
	
	/* Constructeur */
	public Etudiant(int idUtilisateur, String login, String motdepasse, String adresseRue, String adresseVille,
			int adresseCodePostal) 
	{
		super(idUtilisateur, login, motdepasse, adresseRue, adresseVille, adresseCodePostal);
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.niveauEtude = niveauEtude;
		this.adresseMail = adresseMail;
	}

}
