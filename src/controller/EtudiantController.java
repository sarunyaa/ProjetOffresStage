package controller;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
<<<<<<< HEAD
=======
import java.sql.Date;
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

<<<<<<< HEAD

=======
import com.mysql.jdbc.StringUtils;
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e

import dao.EtudiantDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
<<<<<<< HEAD
import model.Etudiant;
import model.Utilisateur;
import pattern.EmailValide;
=======
import javafx.util.converter.LocalDateStringConverter;
import model.Etudiant;
import model.Utilisateur;
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e


public class EtudiantController implements Initializable {

	Connection connection = Connect.ConnectDB() ;


	@FXML
	private TextField textNom;

	@FXML
	private TextField textPrenom;

	@FXML
	private DatePicker textDdn;

<<<<<<< HEAD
=======

	//	@FXML
	//	private TextField textNiv;

>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e
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
<<<<<<< HEAD
=======
	@FXML
	LocalDate date(ActionEvent event) {

		LocalDate date = textDdn.getValue();
		System.out.println(date);
		return date;
	}






>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e
	@FXML
	LocalDate date(ActionEvent event) {

		LocalDate date = textDdn.getValue();
		System.out.println(date);
		return date;
	}

	@FXML
	void sinscrire(ActionEvent event) throws ClassNotFoundException {

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

<<<<<<< HEAD
		EmailValide validator = new EmailValide();
		boolean s = (validator.validate(adresseMail));

		if (nom == "" || (s== false)|| prenom == "" || dateDeNaissance != date(null) || niveauEtude == "" || login == "" || motdepasse == ""){
			//Pop-up
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Veuillez remplir tout les champs !");
			alert.showAndWait();
		}


		if (s== false){
			//Pop-up
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Email invalide !");
			alert.showAndWait();
		}
		else{

=======
		Etudiant et = new Etudiant(nom, prenom, null, niveauEtude, adresseMail, login, motdepasse);
		Utilisateur u = new Utilisateur();
		EtudiantDao dao = new EtudiantDao();
		dao.ajouter(u, et);

		System.out.println(nom + " ajouté dans la base, sous le login de " + login);
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e


<<<<<<< HEAD

			Etudiant et = new Etudiant(nom, prenom, null, niveauEtude, adresseMail, login, motdepasse);
			Utilisateur u = new Utilisateur(login, motdepasse);
			EtudiantDao dao = new EtudiantDao();
			dao.ajouter(u, et);

			System.out.println(nom + " ajouté dans la base, sous le login de " + login);

			//Pop-up
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText(null);
			alert.setContentText("Bienvenue !");
			alert.showAndWait();	


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
				primaryStage .setScene(scene);
			} catch (IOException ex) {
				System.err.println("Erreur au chargement: " + ex);
			}
			primaryStage.setTitle("Mon profil");
			primaryStage.show();
			primaryStage.setResizable(false);
			((Node) event.getSource()).getScene().getWindow().hide();
			
			
			//final String createU = "INSERT into Utilisateur (login, motdepasse, type) VALUE (?,?,?);";

			final String appears = ("SELECT FROM Etudiant (nom , prenom , dateDeNaissance, adresseMail, FROM Etudiant WHERE ID=?");
			
		}
	}
}







=======
}
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e



