package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Entreprise{
	
	private SimpleIntegerProperty idEntreprise;
	public SimpleStringProperty raisonSociale;
	public SimpleIntegerProperty telEntreprise;
	public SimpleStringProperty secteurActivité;
	private SimpleStringProperty adresseRue;
	private SimpleStringProperty adresseVille;
	private SimpleStringProperty adresseCodePostal;
	
	/* Constructeur */

	public Entreprise(String raisonSociale, String adresseRue, String adresseVille, String adresseCodePostal, int telEntreprise,
			String secteurActivité) {

	//	this.idEntreprise = new SimpleIntegerProperty(idEntreprise);
		this.raisonSociale = new SimpleStringProperty(raisonSociale);
		this.telEntreprise = new SimpleIntegerProperty(telEntreprise);
		this.secteurActivité = new SimpleStringProperty(secteurActivité);
		this.adresseRue = new SimpleStringProperty(adresseRue);
		this.adresseVille = new SimpleStringProperty(adresseVille);
		this.adresseCodePostal = new SimpleStringProperty(adresseCodePostal);
	}
	
	

}
