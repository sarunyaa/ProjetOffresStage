package model;

public class Entreprise extends Utilisateur{
	
	private int idEntreprise;
	public String raisonSociale;
	public int telEntreprise;
	public String secteurActivité;
	
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
