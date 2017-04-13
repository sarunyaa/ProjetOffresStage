package dao;

import model.Admin;
import model.Etudiant;
import model.Utilisateur;

public interface AdminInterface {
	
	public boolean trouver(String login, String pass);

	

}
