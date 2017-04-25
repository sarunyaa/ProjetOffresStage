package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Entreprise {

	private SimpleIntegerProperty idEntreprise;
	public SimpleStringProperty raisonSociale;
	public SimpleStringProperty telEntreprise;
	public SimpleStringProperty secteurActivité;
	private SimpleStringProperty adresseRue;
	private SimpleStringProperty adresseVille;
	private SimpleStringProperty adresseCodePostal;
	private SimpleStringProperty mailEntreprise;


	/* Constructeur */
	public Entreprise(String raisonSociale, String adresseRue, String adresseVille,
			String adresseCodePostal,String mailEntreprise, String telEntreprise, String secteurActivité) 
	{
		this.raisonSociale = new SimpleStringProperty(raisonSociale);
		this.adresseRue = new SimpleStringProperty(adresseRue);
		this.adresseVille = new SimpleStringProperty(adresseVille);
		this.adresseCodePostal = new SimpleStringProperty(adresseCodePostal);
		this.telEntreprise = new SimpleStringProperty(telEntreprise);
		this.secteurActivité = new SimpleStringProperty(secteurActivité) ;
		this.mailEntreprise = new SimpleStringProperty(mailEntreprise);
		


	}

//	public Entreprise(String raisonSociale2, String adresseRue2, String adresseVille2, String adresseCodePostal2,
//			String telEntreprise2, String secteurActivité2) {
//		// TODO Auto-generated constructor stub
//		this.raisonSociale = new SimpleStringProperty(raisonSociale2);
//		this.telEntreprise = new SimpleStringProperty(telEntreprise2);
//		this.secteurActivité = new SimpleStringProperty(secteurActivité2) ;
//
//	}

	public String getMailEntreprise() {
		return mailEntreprise.get();
	}

	public void setMailEntreprise(String mE) {
		mailEntreprise.setValue(mE);
	}

//	public int getIdEntreprise() {
//		return idEntreprise.get();
//	}

	public void setIdEntreprise(int idE) {
		idEntreprise.set(idE);
	}

	public String getRaisonSociale() {
		return raisonSociale.get();
	}

	public void setRaisonSociale(String rS) {
		raisonSociale.set(rS);
	}

	public String getTelEntreprise() {
		return telEntreprise.get();
	}

	public void setTelEntreprise(String telE) {
		telEntreprise.set(telE);
	}

	public String getSecteurActivité() {
		return secteurActivité.get();
	}

	public void setSecteurActivité(SimpleStringProperty secteurActivité) {
		this.secteurActivité = secteurActivité;
	}

	public String getAdresseRue() {
		return adresseRue.get();
	}

	public void setAdresseRue(String adresseR) {
		adresseRue.set(adresseR);
	}

	public String getAdresseVille() {
		return adresseVille.get();
	}

	public void setAdresseVille(String adresseV) {
		adresseVille.set(adresseV);
	}

	public String getAdresseCodePostal() {
		return adresseCodePostal.get();
	}

	public void setAdresseCodePostal(String adresseCP) {
		adresseCodePostal.set(adresseCP);
	}



}
