package controller;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import com.mysql.jdbc.StringUtils;

import dao.EtudiantDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.util.converter.LocalDateStringConverter;
import model.Etudiant;
import model.Utilisateur;


public class EtudiantController implements Initializable {

	Connection connection = Connect.ConnectDB() ;


	@FXML
	private TextField textNom;

	@FXML
	private TextField textPrenom;

	@FXML
	private DatePicker textDdn;


	//	@FXML
	//	private TextField textNiv;

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
	@FXML
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


	//final DatePicker datePicker = new DatePicker();
	@FXML
	LocalDate date(ActionEvent event) {

		LocalDate date = textDdn.getValue();
		System.out.println(date);
		return date;
	}






	@FXML
	void sinscrire(ActionEvent event) {

		System.out.println("bouton OK cliqué");	

		//recupération des données entrées par l'utilisateur 
		String nom=textNom.getText();
		String prenom=textPrenom.getText();
		//		java.util.Date dateDeNaissance = 
		//				java.util.Date.from(textDdn.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		//		java.sql.Date sqlDate = new java.sql.Date(dateDeNaissance.getTime());
		//pst.setDate(5, sqlDate);
		LocalDate dateDeNaissance=textDdn.getValue();
		String niveauEtude=choixNiveau.getPromptText();
		String adresseMail=textMail.getText();
		String login=textLogin.getText();
		String motdepasse=textMDP.getText();

		Etudiant et = new Etudiant(nom, prenom, null, niveauEtude, adresseMail, login, motdepasse);
		Utilisateur u = new Utilisateur();
		EtudiantDao dao = new EtudiantDao();
		dao.ajouter(u, et);

		System.out.println(nom + " ajouté dans la base, sous le login de " + login);

	}

}



