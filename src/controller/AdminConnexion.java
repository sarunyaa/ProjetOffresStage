package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.controlsfx.control.Notifications;

import dao.AdminDao;
import dao.EtudiantDao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Admin;
import model.Etudiant;
import model.Utilisateur;


public class AdminConnexion {

	//Ouverture connexion BD
	Connection con = Connect.ConnectDB();

	@FXML
	private Button buttonConnex;

	@FXML
	private TextField textMDP;


	@FXML
	private TextField textLogin;

	@FXML
	private Hyperlink retourLink;

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

	public void ouvreAdmin(ActionEvent event){
		Stage primaryStage = new Stage();
		try {
			// Localisation du fichier FXML.
			final URL url = getClass().getClassLoader().getResource("view/Admin.fxml");

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
	void sauthentifier(ActionEvent event) {
	//System.out.println("bouton connexion cliqué");	
		String login=textLogin.getText();
		String motdepasse=textMDP.getText();	
		System.out.println(login);
		AdminDao ad = new AdminDao();
		if(ad.trouver(login, motdepasse)){
			ouvreAdmin(event);
			Notifications notif_Connecté = Notifications.create();
			notif_Connecté.title("Connecté");
			notif_Connecté.text("Vous êtes maintenant connecté en tant que " + login);
			notif_Connecté.graphic(null);
			notif_Connecté.hideAfter(Duration.seconds(5));
			notif_Connecté.position(Pos.BASELINE_RIGHT);
			notif_Connecté.darkStyle();
			notif_Connecté.onAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
				}
			});

			notif_Connecté.showConfirm();
		}

	}
	
}
