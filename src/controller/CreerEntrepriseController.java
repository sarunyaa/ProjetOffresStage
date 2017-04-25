package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import dao.EntrepriseDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Entreprise;
import model.Utilisateur;

public class CreerEntrepriseController implements Initializable {

	Connection connection = Connect.ConnectDB() ;


	@FXML
	private TextField NomTF;

	@FXML
	private TextField RueTF;

	@FXML
	private TextField VilleTF;

	@FXML
	private TextField CPTF;

	@FXML
	private TextField MailTF;

	@FXML
	private TextField TelTF;

	@FXML
	private TextField SecteurTF;

	@FXML
	private Button ValiderBouton;

	@FXML
	private Button AnnulerBouton;
	
	@FXML
	private TextField textLogin;

	@FXML
	private TextField textMDP;

	
	private static String login;


	public static String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}

	
	Connect conx = new Connect();	



	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	public void creerEntreprise(ActionEvent event){
		//	Connect conx = new Connect();
		//CREATION INTERFACE TEXTFIELD LOGIN MDP
		login=textLogin.getText();
		String motdepasse=textMDP.getText();
		String raisonSociale = NomTF.getText();
		String adresseRue = RueTF.getText();
		String adresseVille = VilleTF.getText();
		String adresseCodePostal = CPTF.getText();
		String mailEntreprise = MailTF.getText();
		String telEntreprise = TelTF.getText();
		String secteurActivité = SecteurTF.getText();

		if(raisonSociale.isEmpty()||adresseRue.isEmpty()
				||adresseVille.isEmpty()||adresseCodePostal.isEmpty()||
				mailEntreprise.isEmpty()||telEntreprise.isEmpty()||
				secteurActivité.isEmpty()){
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("veuillez remplir tout les champs");
			alert.showAndWait();
			return;
		}

		//		String req = "INSERT INTO Entreprise VALUES ("+
		//				"'"+raisonSociale+"',"+
		//				"'"+adresseRue+"',"+
		//				"'"+adresseVille+"',"+
		//				"'"+adresseCodePostal+"',"+
		//				"'"+mailEntreprise+"',"+
		//				"'"+telEntreprise+"',"+
		//				"'"+secteurActivité+"'"+
		//				")";

		//		final String req = "INSERT into Entreprise (id_Entreprise, raisonSociale, adresseRue,"
		//				+ "adresseVille,adresseCodePostal,mailEntreprise,"
		//				+ "telEntreprise,secteurActivité) VALUE (?,?,?,?,?,?,?,?);";
		//		System.out.println(req);
		//


		connection = Connect.ConnectDB() ;	

		Entreprise ent = new Entreprise(raisonSociale, adresseRue, adresseVille, adresseCodePostal, mailEntreprise, telEntreprise, secteurActivité);
		EntrepriseDao daoEnt = new EntrepriseDao();
		Utilisateur u = new Utilisateur(login,motdepasse);

		daoEnt.ajouter(u, ent);

		//		try {
		//			statement = (PreparedStatement) connection.prepareStatement(req);
		//			//	statement.setInt(1, 0);
		//			statement.setString(1, u.getLogin());
		//			statement.setString(2, u.getMotdepasse());
		//			statement.setString(3, "Etudiant");
		//
		//
		//
		//			statement.execute();
		//			statement1.execute();
		//
		//
		//		} catch (SQLException ex) {
		//			ex.printStackTrace();
		//		} finally {
		//			try {
		//				statement.close();
		//				statement1.close();
		//
		//			} catch (SQLException ex) {
		//				ex.printStackTrace();
		//			}
		//		}
	}	



	//		if(conx.excute(req)) {
	//			Alert alert = new Alert(Alert.AlertType.INFORMATION);
	//			alert.setHeaderText(null);
	//			alert.setContentText("SUCCÉS DE LA CRÉATION");
	//			alert.showAndWait();
	//			return;
	//		}else //erreur
	//		{
	//			Alert alert = new Alert(Alert.AlertType.ERROR);
	//			alert.setHeaderText(null);
	//			alert.setContentText("ECHEC DE LA CRÉATION");
	//			alert.showAndWait();
	//			return;
	//
	//		}






}