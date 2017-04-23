package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

<<<<<<< HEAD
public class Entreprise{
=======
public class Entreprise {
>>>>>>> 73f42eab7b21fa84485c73524bd3bc780e9eaf07
	
	private SimpleIntegerProperty idEntreprise;
	public SimpleStringProperty raisonSociale;
	public SimpleIntegerProperty telEntreprise;
	public SimpleStringProperty secteurActivité;
	private SimpleStringProperty adresseRue;
	private SimpleStringProperty adresseVille;
	private SimpleStringProperty adresseCodePostal;
	
	/* Constructeur */
<<<<<<< HEAD

	public Entreprise(String raisonSociale, String adresseRue, String adresseVille, String adresseCodePostal, int telEntreprise,
			String secteurActivité) {

	//	this.idEntreprise = new SimpleIntegerProperty(idEntreprise);
		this.raisonSociale = new SimpleStringProperty(raisonSociale);
		this.telEntreprise = new SimpleIntegerProperty(telEntreprise);
		this.secteurActivité = new SimpleStringProperty(secteurActivité);
		this.adresseRue = new SimpleStringProperty(adresseRue);
		this.adresseVille = new SimpleStringProperty(adresseVille);
		this.adresseCodePostal = new SimpleStringProperty(adresseCodePostal);
=======
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
>>>>>>> 73f42eab7b21fa84485c73524bd3bc780e9eaf07
	}
	
	

}
