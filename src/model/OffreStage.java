package model;
import java.util.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.*;

public class OffreStage {
	
	private int idOffre;
	public String libelleOffre;
	public String descriptionOffre ;
	public String domaineOffre;
	public String dateDebutOffre;
	public String dureeOffre;
	private String cheminOffre;
	private int Entreprise_id_Entreprise;
	
	


	public OffreStage(int idOffre, int entreprise_id_Entreprise , String libelleOffre, String descriptionOffre, String domaineOffre,
			String dateDebutOffre, String dureeOffre, String cheminOffre) {
		super();
		this.idOffre = idOffre;
		this.Entreprise_id_Entreprise = entreprise_id_Entreprise;
		this.libelleOffre = libelleOffre;
		this.descriptionOffre = descriptionOffre;
		this.domaineOffre = domaineOffre;
		this.dateDebutOffre = dateDebutOffre;
		this.dureeOffre = dureeOffre;
		this.cheminOffre = cheminOffre;
		
	}


	public int getIdOffre() {
		return idOffre;
	}


	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
	}


	public String getLibelleOffre() {
		return libelleOffre;
	}


	public void setLibelleOffre(String libelleOffre) {
		this.libelleOffre = libelleOffre;
	}


	public String getDescriptionOffre() {
		return descriptionOffre;
	}


	public void setDescriptionOffre(String descriptionOffre) {
		this.descriptionOffre = descriptionOffre;
	}


	public String getDomaineOffre() {
		return domaineOffre;
	}


	public void setDomaineOffre(String domaineOffre) {
		this.domaineOffre = domaineOffre;
	}


	public String getDateDebutOffre() {
		return dateDebutOffre;
	}


	public void setDateDebutOffre(String dateDebutOffre) {
		this.dateDebutOffre = dateDebutOffre;
	}


	public String getDureeOffre() {
		return dureeOffre;
	}


	public void setDureeOffre(String dureeOffre) {
		this.dureeOffre = dureeOffre;
	}


	public String getCheminOffre() {
		return cheminOffre;
	}


	public void setCheminOffre(String cheminOffre) {
		this.cheminOffre = cheminOffre;
	}


	public int getEntreprise_id_Entreprise() {
		return Entreprise_id_Entreprise;
	}


	public void setEntreprise_id_Entreprise(int entreprise_id_Entreprise) {
		Entreprise_id_Entreprise = entreprise_id_Entreprise;
	}


}