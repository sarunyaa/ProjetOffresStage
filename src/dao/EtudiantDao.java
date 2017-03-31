package dao;

import com.mysql.jdbc.Connection;

import controller.Connect;

public class EtudiantDao implements EtudiantInterface {
	
	java.sql.Connection connection;
	
	final String insert = "INSERT into etudiant (nom, prenom, dateDeNaissance, niveauEtude, adresseMail) VALUE (?,?,?,?,?);";
	final String delete = "DELETE FROM etudiant where id=? ;";
	final String update = "UPDATE etudiant set nom=?, prenom=?, dateDeNaissance=?, niveauEtude=?, adresseMail=? ";
	
	public EtudiantDao(){
		 connection = Connect.ConnectDB() ;	
		}
	
	@Override
	public void ajouter() {
		
		
	}

	@Override
	public void supprimer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifier() {
		// TODO Auto-generated method stub
		
	}

}
