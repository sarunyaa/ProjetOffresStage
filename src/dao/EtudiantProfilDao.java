package dao;

import java.sql.Date;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import controller.Connect;
import model.Etudiant;
import model.Utilisateur;

public class EtudiantProfilDao {

	java.sql.Connection connection;

	final String updateE = "INSERT into Etudiant( nom,  prénom, dateDeNaissance, niveauEtude, adresseMail) VALUE (?,?,?,?,?);";


	public EtudiantProfilDao() {

		//Connexion avec la bdd
		connection = Connect.ConnectDB() ;	
	}

	public void maj(Utilisateur u, Etudiant e) {
		PreparedStatement statementE = null;

		try {

			statementE = (PreparedStatement) connection.prepareStatement(updateE);

			statementE.setString(1, e.getNom());
			statementE.setString(2, e.getPrenom());
			statementE.setDate(3, (Date) e.getDateDeNaissance());
			statementE.setString(4, e.getNiveauEtude());
			statementE.setString(5, e.getAdresseMail());

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				statementE.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	}
}
