package dao;

import model.Etudiant;
import model.Utilisateur;

public interface EtudiantInterface {
	
	public void ajouter(Utilisateur u,Etudiant e);
	public void supprimer(int id);
	public void modifier(Etudiant e);
	
	

}
