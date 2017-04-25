package model;

import com.mysql.jdbc.Blob;

import javafx.beans.property.SimpleIntegerProperty;


public class Candidature {


	private int idCandidature;
	
	private int idEtudiant;

	private int idEntreprise;

	private int idOffre;
	
	private Blob cv;
	
	private Blob lm;
	
	public Candidature(int idCandidature, int idEtudiant, int idEntreprise, int idOffre) {
		super();
		this.idCandidature = idCandidature;
		this.idEtudiant = idEtudiant;
		this.idEntreprise = idEntreprise;
		this.idOffre = idOffre;
	}
	
	public Candidature(int idCandidature, int idEtudiant, int idEntreprise, int idOffre, Blob cv, Blob lm) {
		super();
		this.idCandidature = idCandidature;
		this.idEtudiant = idEtudiant;
		this.idEntreprise = idEntreprise;
		this.idOffre = idOffre;
		this.cv = cv;
		this.lm = lm;
	}

	public int getIdCandidature() {
		return idCandidature;
	}

	public void setIdCandidature(int idCandidature) {
		this.idCandidature = idCandidature;
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public int getIdEntreprise() {
		return idEntreprise;
	}

	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public int getIdOffre() {
		return idOffre;
	}

	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
	}

	public Blob getCv() {
		return cv;
	}

	public void setCv(Blob cv) {
		this.cv = cv;
	}

	public Blob getLm() {
		return lm;
	}

	public void setLm(Blob lm) {
		this.lm = lm;
	}
	
	
	
}
	