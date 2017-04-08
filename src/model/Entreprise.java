package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Entreprise {
	
	private SimpleIntegerProperty idEntreprise;
	public SimpleStringProperty raisonSociale;
	public SimpleIntegerProperty telEntreprise;
	public SimpleStringProperty secteurActivité;
	private String adresseRue;
	private String adresseVille;
	private int adresseCodePostal;
	
	/* Constructeur */
	public Entreprise(String login, String motdepasse, String adresseRue, String adresseVille,
			int adresseCodePostal) 
	{
<<<<<<< HEAD
=======
		super(login, motdepasse);
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e
		this.raisonSociale = raisonSociale;
		this.telEntreprise = telEntreprise;
		this.secteurActivité = secteurActivité;
	}
	
	

}
