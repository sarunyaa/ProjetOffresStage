package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import application.Main;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
<<<<<<< HEAD
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
=======
>>>>>>> sarunyaa/master
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AdminController {

	@FXML
	private Button buttonCreerEntreprise;

	@FXML
	private Button buttonDeposerOffre;

	@FXML
	private Button buttonSupprimer;

	@FXML
	private Button buttonModifier;

	@FXML
	private Button buttonConsulter;

	@FXML
	private ImageView imageP;

	@FXML
	private Button ButtonBrowse;

	@FXML
<<<<<<< HEAD
	private ListView path;
	
	@FXML
	private TextField pathtext;


	//clic sur bouton consulter -> page d'offres de stages
	@FXML
	void consulterOffres(ActionEvent event) {
		//System.out.println("bouton os cliqué");
=======
	private ImageView imageP;
	
	@FXML
	private Button ButtonBrowse;
	
    //clic sur bouton consulter -> page d'offres de stages
    @FXML
    void consulterOffres(ActionEvent event) {
    	//System.out.println("bouton os cliqué");
>>>>>>> sarunyaa/master

		Stage primaryStage = new Stage();

		try {
			// Localisation du fichier FXML.
			final URL url = getClass().getClassLoader().getResource("view/OffresStage.fxml");

			// Création du loader.
			final FXMLLoader fxmlLoader = new FXMLLoader(url);

			// Chargement du FXML.
			final AnchorPane root = (AnchorPane) fxmlLoader.load();

			// Création de la scène.
			final Scene scene = new Scene(root, 600, 400);
			primaryStage.setScene(scene);
		} catch (IOException ex) {
			System.err.println("Erreur au chargement: " + ex);
		}
		primaryStage.setTitle("Consultation des offres de stage");
		primaryStage.show();
		primaryStage.setResizable(false);
		((Node) event.getSource()).getScene().getWindow().hide();
	}

	//clic bouton creer entreprise -> page de création
	@FXML
	void creerEntreprise(ActionEvent event) {
		Stage primaryStage = new Stage();

		try {
			// Localisation du fichier FXML.
			final URL url = getClass().getClassLoader().getResource("view/CreationEntreprise.fxml");

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
		primaryStage.setTitle("Creer une entreprise");
		primaryStage.show();
		primaryStage.setResizable(false);
		((Node) event.getSource()).getScene().getWindow().hide();
	}
    
  //clique sur "change my profil photo" -> fichier de séléction photo
  	public void changerPhotoProfil(ActionEvent event) {
  		FileChooser fileChooser = new FileChooser();

  		//Set extension filter
  		FileChooser.ExtensionFilter extFilter = 
  				new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG", "jpg files (*.jpg)", "*.jpg",
  						"PNG files (*.PNG)", "*.PNG","png files (*.png)", "*.png",
  						"JPEG files (*.JPEG)", "*.JPEG","jpeg files (*.jpeg)", "*.jpeg");
  		//		FileChooser.ExtensionFilter extFilterjpg = 
  		//				new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
  		//		FileChooser.ExtensionFilter extFilterPNG = 
  		//				new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
  		//		FileChooser.ExtensionFilter extFilterpng = 
  		//				new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
  		//		new FileChooser.ExtensionFilter("jpeg files (*.jpeg)", "*.jpeg");

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
  			//listview.getItems().add(selectedFile.getAbsolutePath());
  			System.out.println("browse");
  		}
  		else{
  			System.out.println("File isn't valid");
  		}

  		Connection con = Connect.ConnectDB();
  		((Connect) con).filen();
  		String vpath = ((Connect) con).getp();
  		try {
  			if (vpath == null) {

  			} else {
  				System.out.println("llol");


  			} 
  		}catch (Exception e) {
  			e.printStackTrace();
  		}

  	}

	//clique sur "change my profil photo" -> fichier de séléction photo
	public void changerPhotoProfil(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();

		//Set extension filter
		FileChooser.ExtensionFilter extFilter = 
				new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG", "jpg files (*.jpg)", "*.jpg",
						"PNG files (*.PNG)", "*.PNG","png files (*.png)", "*.png",
						"JPEG files (*.JPEG)", "*.JPEG","jpeg files (*.jpeg)", "*.jpeg");
		//		FileChooser.ExtensionFilter extFilterjpg = 
		//				new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
		//		FileChooser.ExtensionFilter extFilterPNG = 
		//				new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
		//		FileChooser.ExtensionFilter extFilterpng = 
		//				new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
		//		new FileChooser.ExtensionFilter("jpeg files (*.jpeg)", "*.jpeg");

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
			pathtext.getCharacters();
			System.out.println("browse");
		}
		else{
			System.out.println("File isn't valid");
		}

//		Connection con = Connect.ConnectDB();
//		((Connect) con).filen();
//		String vpath = ((Connect) con).getp();
//		try {
//			if (vpath == null) {
//
//			} else {
//				System.out.println("llol");
//
//
//			} 
//		}catch (Exception e) {
//			e.printStackTrace();
//		}

	}

}





