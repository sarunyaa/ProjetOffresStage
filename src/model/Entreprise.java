package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Entreprise extends Utilisateur{
	
	private SimpleIntegerProperty idEntreprise;
	public SimpleStringProperty raisonSociale;
	public SimpleIntegerProperty telEntreprise;
	public SimpleStringProperty secteurActivité;
	
	/* Constructeur */
	public Entreprise(int idUtilisateur, String login, String motdepasse, String adresseRue, String adresseVille,
			int adresseCodePostal) 
	{
		super(idUtilisateur, login, motdepasse, adresseRue, adresseVille, adresseCodePostal);
		this.raisonSociale = raisonSociale;
		this.telEntreprise = telEntreprise;
		this.secteurActivité = secteurActivité;
	}
	
	

}
