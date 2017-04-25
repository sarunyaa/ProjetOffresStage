package dao;

import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import controller.Connect;
import model.Entreprise;
import model.Utilisateur;

public class EntrepriseDao {

	java.sql.Connection connection;


	final String createE = "INSERT into Entreprise (id_Entreprise,RaisonSociale, adresseRue, "
			+ "adresseVille,adresseCodePostal,mailEntreprise,telEntreprise,secteurActivité) VALUE (?,?,?,?,?,?,?,?);";
	final String createU = "INSERT into Utilisateur (login, motdepasse,type) VALUE (?,?,?);";



	public EntrepriseDao(){
		//Connexion avec la bdd
		connection = Connect.ConnectDB() ;	
	}
	final static String findId="SELECT MAX(id_Utilisateur)FROM `Utilisateur`";
	public void ajouter(Utilisateur u, Entreprise e) {
		PreparedStatement statementU = null;
		PreparedStatement statementE = null;



		try {
			statementU = (PreparedStatement) connection.prepareStatement(createU);

			statementU.setString(1, u.getLogin());
			statementU.setString(2, u.getMotdepasse());
			statementU.setString(3, "Entreprise");



			statementE = (PreparedStatement) connection.prepareStatement(createE);

			statementE.setInt(1, UtilisateurDao.getiD(findId)+1);
			statementE.setString(2, e.getRaisonSociale());
			statementE.setString(3, e.getAdresseRue());
			statementE.setString(4, e.getAdresseVille());
			statementE.setString(5, e.getAdresseCodePostal());
			statementE.setString(6, e.getMailEntreprise());
			statementE.setString(7, e.getTelEntreprise());
			statementE.setString(8, e.getSecteurActivité());

			statementU.execute();
			statementE.execute();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				statementU.close();
				statementE.close();


			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}	
}
