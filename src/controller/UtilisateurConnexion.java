package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import dao.UtilisateurDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UtilisateurConnexion implements  Initializable {

	//Ouverture connexion BD
	Connection con = Connect.ConnectDB();

	@FXML
	private Button buttonConnex;

	@FXML
	private TextField textMDP;
	
	
	@FXML
	private PasswordField textLogin;
	
	final ToggleGroup group = new ToggleGroup();



	@FXML
	private RadioButton radioEtudiant = new RadioButton("Etudiant") ;

	@FXML
	private RadioButton radioEntreprise = new RadioButton("Entreprise");


	@FXML
	private Hyperlink retourLink;
	private static String login=null; 
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		radioEtudiant.setToggleGroup(group);
		radioEtudiant.setUserData("Etudiant");
		radioEntreprise.setToggleGroup(group);
		radioEntreprise.setUserData("Entreprise");

		radioEtudiant.setSelected(true);
		
		

		System.out.println("radio séléctionné = " + group.getSelectedToggle().getUserData());
			//renvoie le bouton selectionné


		
	}
    
	public static boolean verifLogin(String a){
		Connection conn=Connect.ConnectDB();
		boolean rep=true;
		try {
		PreparedStatement ps=conn.prepareStatement("SELECT `login` FROM `Utilisateur`");
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			if(rs.getString(1).equals(a)){
				
				return false;
				
			};
		}ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rep;
	}
	

	@FXML
	void retourAccueil(ActionEvent event) {
		Stage primaryStage = new Stage();

		try {
			// Localisation du fichier FXML.
			final URL url = getClass().getClassLoader().getResource("view/Accueil.fxml");

			// Création du loader.
			final FXMLLoader fxmlLoader = new FXMLLoader(url);

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

	public void ouvreProfilEtu(ActionEvent event){
		Stage primaryStage = new Stage();
		try {
			// Localisation du fichier FXML.
			final URL url = getClass().getClassLoader().getResource("view/ProfilEtudiant.fxml");

			// Création du loader.
			final FXMLLoader fxmlLoader = new FXMLLoader(url);

			// Chargement du FXML.
			final AnchorPane root = (AnchorPane) fxmlLoader.load();

			// Création de la scène.
			final Scene scene = new Scene(root);
			primaryStage.setScene(scene);
		} catch (IOException ex) {
			System.err.println("Erreur au chargement: " + ex);
		}
		primaryStage.setTitle("Accueil");
		primaryStage.show();
		primaryStage.setResizable(false);
		((Node) event.getSource()).getScene().getWindow().hide();
	}  

	public void ouvreProfilEnt(ActionEvent event){
		Stage primaryStage = new Stage();
		try {
			// Localisation du fichier FXML.
			final URL url = getClass().getClassLoader().getResource("view/Entreprise.fxml");

			// Création du loader.
			final FXMLLoader fxmlLoader = new FXMLLoader(url);

			// Chargement du FXML.
			final AnchorPane root = (AnchorPane) fxmlLoader.load();

			// Création de la scène.
			final Scene scene = new Scene(root);
			primaryStage.setScene(scene);
		} catch (IOException ex) {
			System.err.println("Erreur au chargement: " + ex);
		}
		primaryStage.setTitle("Accueil");
		primaryStage.show();
		primaryStage.setResizable(false);
		((Node) event.getSource()).getScene().getWindow().hide();
	}  

	@FXML
	boolean entChoix(ActionEvent event) {
		return true;

	}

	@FXML
	boolean etuChoix(ActionEvent event) {
		return true;
	}

	@FXML
	void sauthentifier(ActionEvent event) {

		login=textLogin.getText();
		String motdepasse=textMDP.getText();	

		String type = null; //recupère le type selectionné par l'utilisateur
		
		if(radioEntreprise.isSelected()) type= (String) radioEntreprise.getUserData();
		else if (radioEtudiant.isSelected())type=(String) radioEtudiant.getUserData();
	// On prend la valeur du RadioButton selectionné pour le type.
		

		UtilisateurDao ut = new UtilisateurDao();
		
		if(ut.trouver(login, motdepasse) && ut.choixType(type).equals("Etudiant")){
			ouvreProfilEtu(event);
		}
		
		else if (ut.trouver(login, motdepasse) && ut.choixType(type).equals("Entreprise")){
			ouvreProfilEnt(event);


		}

		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Attention");
			alert.setContentText("Impossible de se connecter");
			alert.showAndWait();
		}


	}



	public static String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}

	


}



