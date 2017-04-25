package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Etudiant {

	private SimpleIntegerProperty idEtudiant;
	public SimpleStringProperty nom;
	public SimpleStringProperty prenom;
	private Date dateDeNaissance; 
	private SimpleStringProperty niveauEtude;
	private SimpleStringProperty adresseMail;

	/* Constructeur */
	public Etudiant(String nom,String prenom, Date ddn, String niveauEtude,String adresseMail) 
	{


		//	this.idEtudiant = new SimpleIntegerProperty(id);

		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		//	this.dateDeNaissance = new Date();
		this.dateDeNaissance = ddn;
		this.niveauEtude = new SimpleStringProperty(niveauEtude);
		this.adresseMail = new SimpleStringProperty(adresseMail);
		//idEtudiant = idEtudiant +1;

	}

	public Etudiant(String i, String n, String p) {
		i=i;
		n=n;
		p=p;

	}

	public Etudiant(int id,String nom,
			String prenom, Date ddn, String niveauEtude,
			String adresseMail) 
	{


		this.idEtudiant = new SimpleIntegerProperty(id);

		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		//	this.dateDeNaissance = new Date();
		this.dateDeNaissance = ddn;
		this.niveauEtude = new SimpleStringProperty(niveauEtude);
		this.adresseMail = new SimpleStringProperty(adresseMail);

	}
	
	public Etudiant(int i, String n, String p, String a) {
		i=i;
		n=n;
		p=p;
		a=a;

		}


	public Etudiant(String n, String p) {
		n=n;
		p=p;
	}

	public String getNom() {
		return nom.get();
	}

	public void setNom(String value) {
		nom.set(value);
	}

	public String getPrenom() {
		return prenom.get();
	}

	public void setPrenom(String value) {
		prenom.set(value);
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date value) {
		this.dateDeNaissance = value;
	}

	public String getNiveauEtude() {
		return niveauEtude.get();
	}

	public void setNiveauEtude(String value) {
		niveauEtude.set(value);
	}

	public String getAdresseMail() {
		return adresseMail.get();
	}

	public int getIdEtudiant() {
		return idEtudiant.get();
	}

	public void setIdEtudiant(int idE) {
		idEtudiant.set(idE);;
	}

	public void setAdresseMail(String value) {
		adresseMail.set(value);
	}

}

