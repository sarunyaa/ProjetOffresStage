package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.mysql.jdbc.Statement;

import application.Main;
import dao.EtudiantDao;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Etudiant;
import model.Utilisateur;

public class ControllerProfileEtudiant implements Initializable {


	java.sql.Connection connection = Connect.ConnectDB();

	@FXML
	private TextField textNom;

	@FXML
	private TextField textPrenom;

	@FXML
	private TextField numTel;

	@FXML
	private TextField textAdresse;

	@FXML
	private TextField textDdn;

	@FXML
	private TextField textMail;
	
	@FXML
	private TextField id;

	@FXML
	private TextField textAnnee;

	@FXML
	private ImageView imageP;

	@FXML
	private Button photoBrowse;

	@FXML
	private Button accesCandidater;

	@FXML
	private Button buttonMaj;

	@FXML
	private ListView path;

	//Etudiant etu;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Connection connection = Connect.ConnectDB() ;


		try {
			String sql = "SELECT * FROM Etudiant";
		//	String sql = "SELECT * FROM Etudiant WHERE nom =" + nom + ", prenom =?" ;



			//Etudiant e = new Etudiant(nom, prenom, login, motdepasse);
			PreparedStatement ps=connection.prepareStatement(sql);
			//System.out.println("teest");
			ResultSet rs=ps.executeQuery();
			rs.last();
			int idn = rs.getInt("idEtudiant");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			//	Date Ddn = rs.getDate("dateDeNaissance");
			String adresseMail= rs.getString("adresseMail");


			textNom.setText(nom);
			textPrenom.setText(prenom);
			//	textDdn.setText(Ddn));
			textMail.setText(adresseMail);
			String a = String.valueOf(idn);
			id.setText(a);

		}catch(Exception e){
			e.printStackTrace();
		}

	}


	//clic sur bouton candidater -> page d'offres de stages et de candidature
	@FXML
	public void accederCandidater(ActionEvent event) {

		//System.out.println("bouton os cliqué");

		Stage primaryStage = new Stage();

		try {
			// Localisation du fichier FXML.
			final URL url = getClass().getClassLoader().getResource("view/Etudiant.fxml");

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
		primaryStage.setTitle("Candidater aux offres");
		primaryStage.show();
		primaryStage.setResizable(false);
		((Node) event.getSource()).getScene().getWindow().hide();
	}


	@FXML
	public void changerPhotoProfilEtudiant(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();

		//Set extension filter
		FileChooser.ExtensionFilter extFilter = 
				new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG", "jpg files (*.jpg)", "*.jpg",
						"PNG files (*.PNG)", "*.PNG","png files (*.png)", "*.png",
						"JPEG files (*.JPEG)", "*.JPEG","jpeg files (*.jpeg)", "*.jpeg");

		fileChooser.getExtensionFilters()
		.addAll(extFilter);


		//Show open file dialog
		File file = fileChooser.showOpenDialog(null);

		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			imageP.setImage(image);
		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}

		if (file != null){
			path.getItems().add(file.getAbsolutePath());
			System.out.println("browse");
		}
		else{
			System.out.println("File isn't valid");
		}

	}


	@FXML
	void maj(ActionEvent event) throws ClassNotFoundException {

		Connection connection = Connect.ConnectDB() ;


		try {
			String sql = "UPDATE Etudiant SET nom= ? WHERE idEtudiant = ?";

			
			
			System.out.println("zertykezaertyhurezazertyurezer");
			PreparedStatement ps=connection.prepareStatement(sql);
			//System.out.println("teest");

			ps.setString(1, textNom.getText());
			ps.setString(2, id.getText());

			//ps.setString(3, textPrenom.getText());

			//Etudiant e = new Etudiant(nom, prenom, login, motdepasse);
			//System.out.println("teest");
			ps.executeUpdate();
			ps.close();
			
			
//			rs.updateString("nom", textNom.getText());
//			rs.updateString("prenom", textPrenom.getText());
//			rs.updateString("adresseMail", textAdresse.getText());


		} catch (Exception e) {
			e.printStackTrace();
		}


		//Pop-up
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText("Données mises à jour !");
		alert.showAndWait();	



	}



}
