package model;

public class Utilisateur {
	
	private int idUtilisateur;
	private String login;
	private String motdepasse;
	private String type;
	
	
	
	/* Constructeur */
	public Utilisateur(String login, String motdepasse) {
		this.login = login;
		this.motdepasse = motdepasse;
		//this.type = type;
		
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}


	public int getIdUtilisateur() {
		return idUtilisateur;
	}


	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getMotdepasse() {
		return motdepasse;
	}


	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	
	

}
