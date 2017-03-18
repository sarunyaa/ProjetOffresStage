package model;

public class Utilisateur {
	
	private int idUtilisateur;
	private String login;
	private String motdepasse;
	private String adresseRue;
	private String adresseVille;
	private int adresseCodePostal;
	
	
	/* Constructeur */
	public Utilisateur(int idUtilisateur, String login, String motdepasse, String adresseRue, String adresseVille,
			int adresseCodePostal) {
		this.idUtilisateur = idUtilisateur;
		this.login = login;
		this.motdepasse = motdepasse;
		this.adresseRue = adresseRue;
		this.adresseVille = adresseVille;
		this.adresseCodePostal = adresseCodePostal;
	}


	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}
	
	

}
