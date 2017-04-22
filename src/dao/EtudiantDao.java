package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import controller.Connect;
import model.Etudiant;
import model.Utilisateur;
import controller.EtudiantController;

public class EtudiantDao implements EtudiantInterface {

	java.sql.Connection connection;

	final String createU = "INSERT into Utilisateur (login, motdepasse) VALUE (?,?);";
	final String createE = "INSERT into Etudiant(IdEtudiant, nom,  prenom, dateDeNaissance, niveauEtude, adresseMail)VALUE (NULL,?,?,?,?,?);";
	final String getAllE ="SELECT * FROM `Etudiant` ";
	final String delete = "DELETE FROM etudiant where id=? ;";
	final String update = "UPDATE etudiant set nom=?, prenom=?, dateDeNaissance=?, niveauEtude=?, adresseMail=? ";
	//final String update = "UPDATE etudiant set nom=?, prénom=?, dateDeNaissance=?, niveauEtude=?, adresseMail=? ";


	public EtudiantDao(){
		//Connexion avec la bdd
		connection = Connect.ConnectDB() ;	
	}
	
	
	public List<Etudiant> getAll() {
		List<Etudiant> liste = null;
		PreparedStatement stat = null;
		try {
			liste = new ArrayList<Etudiant>();
			stat = (PreparedStatement) connection.prepareStatement(getAllE);
			ResultSet rs = stat.executeQuery();

			while (rs.next()) {
				Etudiant et = new Etudiant(rs.getString("nom"), rs.getString("prenom"), null, rs.getString("niveauEtude"), rs.getString("adresseMail"));
						
				liste.add(et);
				
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				stat.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return liste;
	}

	public void ajouter(Utilisateur u, Etudiant e) {
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;


		try {
			statement = (PreparedStatement) connection.prepareStatement(createU);
			//statement.setInt(1, 0);
			statement.setString(1, u.getLogin());
			statement.setString(2, u.getMotdepasse());

			statement1 = (PreparedStatement) connection.prepareStatement(createE);

			statement1.setString(1, e.getNom());
			statement1.setString(2, e.getPrenom());
			statement1.setDate(3, (Date) e.getDateDeNaissance());
			statement1.setString(4, e.getNiveauEtude());
			statement1.setString(5, e.getAdresseMail());

			statement.execute();
			statement1.execute();


		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				statement.close();
				statement1.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}	



	@Override
	public void supprimer(int id) {
		java.sql.PreparedStatement statement = null;

		try{
			statement = connection.prepareStatement(delete);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException ex){
			ex.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException ex){
				ex.printStackTrace();
			}
		}

	}

	@Override
	public void modifier(Etudiant e) {
		java.sql.PreparedStatement statement=null;

		try{
			//	statement = connection.prepareStatement(update);
			statement.setString(1,e.getNom());
			statement.setString(2,  e.getPrenom());
			statement.setDate(3, (Date) e.getDateDeNaissance());
			statement.setString(4, e.getNiveauEtude());
			statement.setString(5, e.getAdresseMail());
			statement.executeQuery();

		}catch (SQLException ex){
			ex.printStackTrace();
		}

	}







}
