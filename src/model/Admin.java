package model;

public class Admin {
	
	private String login;
	private String mdp;
	
	//constructeur
	public Admin(String login, String mdp) {
		this.login = login;
		this.mdp = mdp;
	}
	
	public Admin(){}
	
	
	//Accesseurs
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
	

}
