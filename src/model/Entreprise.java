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
	private SimpleIntegerProperty adresseCodePostal;
	
	/* Constructeur */

	public Entreprise(String raisonSociale, int telEntreprise,
			String secteurActivité, String adresseRue, String adresseVille, int adresseCodePostal) {

		this.raisonSociale = new SimpleStringProperty(raisonSociale);
		this.telEntreprise = new SimpleIntegerProperty(telEntreprise);
		this.secteurActivité = new SimpleStringProperty(secteurActivité);
		this.adresseRue = new SimpleStringProperty(adresseRue);
		this.adresseVille = new SimpleStringProperty(adresseVille);
		this.adresseCodePostal = new SimpleIntegerProperty(adresseCodePostal);
	}
	
	

}
