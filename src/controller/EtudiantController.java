package controller;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class EtudiantController implements Initializable {

	Connection connection = Connect.ConnectDB() ;


	@FXML
	private TextField textNom;

	@FXML
	private TextField textPrenom;

	@FXML
	private DatePicker textDdn;

	@FXML
	private TextField textNiv;

	@FXML 
	private TextField textMail;

	@FXML
	private TextField textLogin;

	@FXML
	private TextField textMDP;

	@FXML
	private Hyperlink retourLink;



	@FXML
	private Button buttonOk = new Button();

	//Inscription
	ObservableList<String> niveauList = FXCollections
			.observableArrayList("Choisir niveau","BAC+2", "BAC+3", "BAC+4", "BAC+5");

	@FXML
	private ComboBox<String> choixNiveau = new ComboBox();


	@FXML
	void retourAccueil(ActionEvent event) {
		Stage primaryStage = new Stage();

		try {
			// Localisation du fichier FXML.
			final URL url1 = getClass().getClassLoader().getResource("view/Accueil.fxml");

			// Création du loader.
			final FXMLLoader fxmlLoader = new FXMLLoader(url1);

			// Chargement du FXML.
			final AnchorPane root = (AnchorPane) fxmlLoader.load();

			// Création de la scène.
			final Scene scene = new Scene(root, 800, 600);
			primaryStage.setScene(scene);
		} catch (IOException ex) {
			System.err.println("Erreur au chargement: " + ex);
		}
		primaryStage.setTitle("Accueil");
		primaryStage.show();
		primaryStage.setResizable(false);
		((Node) event.getSource()).getScene().getWindow().hide();

	}
	//Initilisation des choix
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//choixNiveau.setValue("Choisir un niveau");
		choixNiveau.setItems(niveauList);		

	}

	@FXML
	void sinscrire(ActionEvent event) {

		System.out.println("bouton OK cliqué");	

		//recupération des données entrées par l'utilisateur 
		String nom=textNom.getText();
		String prenom=textPrenom.getText();
		LocalDate dateDeNaissance=textDdn.getValue();
		String niveauEtude=textNiv.getText();
		String adresseMail=textMail.getText();
		String login=textLogin.getText();
		String motdepasse=textMDP.getText();


		PreparedStatement state,state1;
		ResultSet res;
		boolean flag =false ;

		try{
			String req1 = "SELECT `idEtudiant`,`nom`,`prenom`, `dateDeNaissance`,`niveauEtude`,`adresseMail` FROM Etudiant WHERE nom=? AND prenom=? "
					+ "AND dateDeNaissance=? AND niveauEtude=? AND  adresseMail=?";

			state1 = connection.prepareStatement(req1);

			//state1.setInt(1,idEtudiant);
			state1.setString(2,nom);
			state1.setString(3,prenom);
			res=state1.executeQuery();	

			if (res != null){
				flag=true;

				while(res.next()){ //tant qu'il y a qqchose dans la table
					state = connection.prepareStatement("insert into Etudiant (idEtudiant,nom,prenom,dateDeNaissance,niveauEtude,adresseMail)values(?,?,?,?,?,?)");
					//state.setInt(1,idEtudiant);
					state.setString(1,nom);
					state.setString(2,prenom);
					//state.setValue(3,dateDeNaissance);
					state.setString(4,niveauEtude);
					state.setString(5,adresseMail);
					//rajouter login + mdp ? a recuperer de l'utilisateur

					int rs= state.executeUpdate();

					System.out.println("Etudiant ajouté");

				}
			} else System.out.println("Etudiant pas ajouté");

		} catch(SQLException e){
			e.printStackTrace();
		}

	}

	/*	public void sinscrire(int idEtudiant,String nom,String prenom, Date dateDeNaissance, String niveauEtude, String adresseMail)throws ClassNotFoundException, SQLException{


		 buttonOk.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				if(event.getSource()==buttonOk){
					System.out.println("bouton OK cliqué");	

					String nom=textNom.getText();
					String prenom=textPrenom.getText();
					String ddn=textDdn.getText();
					String niveau=textNiv.getText();
					String mail=textMail.getText();
					String login=textLogin.getText();
					String motdepasse=textMDP.getText();


					 PreparedStatement state,state1;
			         ResultSet res;
					 boolean flag =false ;

					 try{
					 String req1 = "SELECT `idEtudiant`,`nom`,`prenom`, `dateDeNaissance`,`niveauEtude`,`adresseMail` FROM Etudiant WHERE nom=? AND prenom=? "
					 		+ "AND dateDeNaissance=? AND niveauEtude=? AND  adresseMail=?";
						state1 = connection.prepareStatement(req1);

						state1.setInt(1,idEtudiant);
						 state1.setString(2,nom);
						 state1.setString(3,prenom);
						 res=state1.executeQuery();	

						 if (res != null){
						        flag=true;

					      while(res.next()){
								state = connection.prepareStatement("insert into Etudiant (idEtudiant,nom,prenom,dateDeNaissance,niveauEtude,adresseMail)values(?,?,?,?,?,?)");
								state.setInt(1,idEtudiant);
								state.setString(1,nom);
								state.setString(2,prenom);
								state.setDate(3,dateDeNaissance);
								state.setString(4,niveauEtude);
								state.setString(5,adresseMail);
								//rajouter login + mdp ? a recuperer de l'utilisateur

								int rs= state.executeUpdate();

					System.out.println("Etudiant ajouté");

					      }
				       } else System.out.println("Etudiant pas ajouté");

				       } catch(SQLException e){
							e.printStackTrace();
				       }
				}
				}  

			}); */

}



