package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

<<<<<<< HEAD
public class Etudiant {
	
	private SimpleIntegerProperty idEtudiant;
=======
<<<<<<< HEAD
public class Etudiant {

	//	private int idEtudiant=0;
=======
public class Etudiant extends Utilisateur{
<<<<<<< HEAD

	//	private int idEtudiant=0;
=======
	
//	private int idEtudiant=0;
>>>>>>> sarunyaa/master
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e
>>>>>>> 73f42eab7b21fa84485c73524bd3bc780e9eaf07
	public SimpleStringProperty nom;
	public SimpleStringProperty prenom;
	private Date dateDeNaissance; 
	private SimpleStringProperty niveauEtude;
	private SimpleStringProperty adresseMail;

	/* Constructeur */
	public Etudiant(String nom,
			String prenom, Date ddn, String niveauEtude,
			String adresseMail) 
	{
<<<<<<< HEAD

=======
<<<<<<< HEAD

		super(login, motdepasse);
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e


		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		//	this.dateDeNaissance = new Date();
<<<<<<< HEAD
=======
=======
		
		
	//	this.idEtudiant = new SimpleIntegerProperty(id);
		
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
	//	this.dateDeNaissance = new Date();
>>>>>>> sarunyaa/master
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e
		this.dateDeNaissance = ddn;
		this.niveauEtude = new SimpleStringProperty(niveauEtude);
		this.adresseMail = new SimpleStringProperty(adresseMail);
		//idEtudiant = idEtudiant +1;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e

	}

	//	public int getIdEtudiant() {
	//		return idEtudiant;
	//	}

	//	public void setIdEtudiant(int idEtudiant) {
	//		this.idEtudiant = idEtudiant;
	//	}

	public String getNom() {
		return nom.get();
<<<<<<< HEAD
	}

	public void setNom(String value) {
		nom.set(value);
	}

=======
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

=======
		
	}

//	public int getIdEtudiant() {
//		return idEtudiant;
//	}

//	public void setIdEtudiant(int idEtudiant) {
//		this.idEtudiant = idEtudiant;
//	}

	public String getNom() {
		return nom.get();
	}

	public void setNom(String value) {
		nom.set(value);
	}

>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e
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

<<<<<<< HEAD
=======
>>>>>>> sarunyaa/master
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e
	public String getNiveauEtude() {
		return niveauEtude.get();
	}

	public void setNiveauEtude(String value) {
		niveauEtude.set(value);
	}

	public String getAdresseMail() {
		return adresseMail.get();
	}

	public void setAdresseMail(String value) {
		adresseMail.set(value);
	}
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e






}

<<<<<<< HEAD
=======
=======
	
	
	
	
	
	
	}
	
>>>>>>> sarunyaa/master
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e
