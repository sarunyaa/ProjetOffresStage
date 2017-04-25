package controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AccueilController {

	@FXML
	private Button buttonConnexion = new Button();

	@FXML
	private Button buttonInscription = new Button();

	@FXML
	private Hyperlink adminLink = new Hyperlink("Se connecter en tant qu'administrateur");


	//Hypertext pour se connecter en tant qu'admin
	@FXML
	public void adminHyperlink(ActionEvent event){
		System.out.println("hyperlink admin cliqué");

		Stage primaryStage = new Stage();

		try {
			// Localisation du fichier FXML.
			final URL url = getClass().getClassLoader().getResource("view/ConnexionAdmin.fxml");

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
		primaryStage.setTitle("Se connecter en tant qu'administrateur");
		primaryStage.show();
		primaryStage.setResizable(false);
		((Node) event.getSource()).getScene().getWindow().hide();
	}


	//Bouton connexion -> page d'authentification
	@FXML
	public void clicConnexion(ActionEvent event){

		System.out.println("bouton connexion cliqué");

		Stage primaryStage = new Stage();

		try {
			// Localisation du fichier FXML.
			final URL url = getClass().getClassLoader().getResource("view/Connexion.fxml");

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
		primaryStage.setTitle("Se connecter en tant qu'utilisateur");
		primaryStage.show();
		primaryStage.setResizable(false);
		((Node) event.getSource()).getScene().getWindow().hide();
	}


	//Bouton inscription -> page d'inscription
	@FXML
	public void clicInscription(ActionEvent event){

		System.out.println("bouton inscription cliqué");

		Stage primaryStage = new Stage();

		try {
			// Localisation du fichier FXML.
			final URL url1 = getClass().getClassLoader().getResource("view/Inscription.fxml");

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
		primaryStage.setTitle("Création d'un profil : Etudiant");
		primaryStage.show();
		primaryStage.setResizable(false);
		((Node) event.getSource()).getScene().getWindow().hide();

	}
	@FXML
	void clicAbout(ActionEvent event) {
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("A propos");
	alert.setHeaderText(null);
	alert.setContentText("Bienvenue dans notre application vous donnant accès aux offres de stage" + "\n" + " proposées par l'université." +"\n"+" Inscrivez vous afin de pouvoir consulter et candidater. ");
	alert.showAndWait();
	}


	@FXML
	void clicContact(ActionEvent event) {
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("Contactez nous !");
	alert.setHeaderText(null);
	alert.setContentText("BENREDJEM Sara\nsarabenredjem@gmail.com \n \nRAMANANJO Chloé\nchloe.ramananjo@outlook.com\n\nSATKUNARAJAH Sarunyaa\nsaru.rajah@gmail.com");
	alert.showAndWait();

	}

	@FXML
	void clicHelp(ActionEvent event) {
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("Besoin d'aide ?");
	alert.setHeaderText(null);
	alert.setContentText("Pour toute question, veuillez nous contacter via l'onglet CONTACTEZ-NOUS \n ou adressez vous directement à la scolarité de l'université. ");
	alert.showAndWait();

	}


}

