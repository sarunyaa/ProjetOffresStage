package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.mysql.jdbc.PreparedStatement;

import application.Main;
import dao.EtudiantDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
<<<<<<< HEAD
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
=======
<<<<<<< HEAD
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
=======
<<<<<<< HEAD
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
=======
>>>>>>> sarunyaa/master
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e
>>>>>>> 73f42eab7b21fa84485c73524bd3bc780e9eaf07
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Entreprise;
import model.Etudiant;
import model.OffreStage;

public class AdminController implements Initializable {

	Connection connection = Connect.ConnectDB() ;


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
	private TableView<Entreprise> tableVentreprise;

	@FXML
	private TableColumn<Entreprise, Integer> idEnt;

	@FXML
	private TableColumn<Entreprise, String> rsE;

	@FXML
	private TableColumn<Entreprise, Integer> telE;

	@FXML
	private TableColumn<Entreprise, String> secteurE;

	@FXML
	private TableColumn<Entreprise, String> villeE;

	@FXML
	private TableColumn<Entreprise, String> rueE;

	@FXML
	private TableColumn<Entreprise, String> codeE;

	@FXML
	private Tab tabPaneEt;

	@FXML
	private TableView<Etudiant> tableVetudiant;

	@FXML
	private TableColumn<Etudiant, Integer> idE;

	@FXML
	private TableColumn<Etudiant, String> nomE;

	@FXML
	private TableColumn<Etudiant, String> prenomE;

	@FXML
	private TableColumn<Etudiant, Date> ddnE;

	@FXML
	private TableColumn<Etudiant, String> nivE;

	@FXML
	private TableColumn<Etudiant, String> mailE;

	@FXML
	private TableView<OffreStage> tableVoffre;
	
	@FXML
    private TableColumn<?, ?> idOffreCo;

<<<<<<< HEAD
    @FXML
    private TableColumn<?, ?> Entreprise_id_EntrepriseCo;

    @FXML
    private TableColumn<?, ?> libelleOffreCo;

    @FXML
    private TableColumn<?, ?> descriptifOffreCo;

    @FXML
    private TableColumn<?, ?> domaineOffreCo;

    @FXML
    private TableColumn<?, ?> dateDebutOffreCo;

    @FXML
    private TableColumn<?, ?> dureeOffreCo;

    @FXML
    private TableColumn<?, ?> cheminOffreCo;


	ObservableList<Etudiant> listeEt= FXCollections.observableArrayList();
	ObservableList<Entreprise> listeEnt= FXCollections.observableArrayList();
	ObservableList<OffreStage> listeoffre= FXCollections.observableArrayList();



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initEtu();
		listEtudiant();
		
		initEnt();
		listEntreprise();
		
		
		listOffre();
		initOffre();

	}
=======
	@FXML
	private Button buttonCreerEntreprise;
<<<<<<< HEAD

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
=======

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
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e
	private ListView path;
	
	@FXML
	private TextField pathtext;


	//clic sur bouton consulter -> page d'offres de stages
	@FXML
	void consulterOffres(ActionEvent event) {
		//System.out.println("bouton os cliqué");
<<<<<<< HEAD
=======
=======
	private ImageView imageP;
>>>>>>> 73f42eab7b21fa84485c73524bd3bc780e9eaf07
	
	public void initEnt(){
		idEnt.setCellValueFactory(new PropertyValueFactory<>("idEntreprise"));
		rsE.setCellValueFactory(new PropertyValueFactory<>("raisonSociale"));
		rueE.setCellValueFactory(new PropertyValueFactory<>("adresseRue"));
		villeE.setCellValueFactory(new PropertyValueFactory<>("adresseVille"));
		codeE.setCellValueFactory(new PropertyValueFactory<>("adresseCodePostal"));
		telE.setCellValueFactory(new PropertyValueFactory<>("telEntreprise"));
		secteurE.setCellValueFactory(new PropertyValueFactory<>("secteurActivite"));
		



	}
	
<<<<<<< HEAD
	void listEntreprise(){
		PreparedStatement state = null;


		try {

			state = (PreparedStatement) connection.prepareStatement("SELECT * FROM `Entreprise`");
			ResultSet rs = state.executeQuery();

			while(rs.next()){
				int idEntreprise= rs.getInt("id_Entreprise");

				String raisonSociale= rs.getString("raisonSociale");
				String adresseRue= rs.getString("adresseRue");
				String adresseVille= rs.getString("adresseVille");
				String adresseCodePostal= rs.getString("adresseCodePostal");
				int telEntreprise= rs.getInt("telEntreprise");
				String secteurActivite= rs.getString("secteurActivité");
				


				listeEnt.add(new Entreprise(raisonSociale, adresseRue, adresseVille, adresseCodePostal, telEntreprise,secteurActivite));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tableVentreprise.getItems().setAll(listeEnt);
		
		
	}

	public void initEtu(){
		idE.setCellValueFactory(new PropertyValueFactory<>("idEtudiant"));
		nomE.setCellValueFactory(new PropertyValueFactory<>("nom"));
		prenomE.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		ddnE.setCellValueFactory(new PropertyValueFactory<>("dateDeNaissance"));
		nivE.setCellValueFactory(new PropertyValueFactory<>("niveauEtude"));
		mailE.setCellValueFactory(new PropertyValueFactory<>("adresseMail"));


	}

	
	void listEtudiant() {

		PreparedStatement state2 = null;


		try {

			state2 = (PreparedStatement) connection.prepareStatement("SELECT * FROM `Etudiant`");
			ResultSet rs = state2.executeQuery();

			while(rs.next()){
				int idEtudiant= rs.getInt("idEtudiant");
			//	System.out.println(idEtudiant);

				String nomEtudiant= rs.getString("nom");
			//	System.out.println(nomEtudiant);
				String prenomEtudiant= rs.getString("prenom");
			//	System.out.println(prenomEtudiant);
				String ddnEtudiant= rs.getString("dateDeNaissance");
			//	System.out.println(ddnEtudiant);
				String nivEtude= rs.getString("niveauEtude");
			//	System.out.println(nivEtude);
				String mailEtudiant= rs.getString("adresseMail");
			//	System.out.println(mailEtudiant);



				listeEt.add(new Etudiant(nomEtudiant, prenomEtudiant, null, ddnEtudiant, mailEtudiant) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tableVetudiant.getItems().setAll(listeEt);

	}
	
	//méthode pr initialiser les colonne du tab
		public void initOffre(){
			idOffreCo.setCellValueFactory(new PropertyValueFactory<>("idOffre"));
			libelleOffreCo.setCellValueFactory(new PropertyValueFactory<>("libelleOffre"));
			descriptifOffreCo.setCellValueFactory(new PropertyValueFactory<>("descriptifOffre"));
			domaineOffreCo.setCellValueFactory(new PropertyValueFactory<>("domaineOffre"));
			dateDebutOffreCo.setCellValueFactory(new PropertyValueFactory<>("dateDebutOffre"));
			dureeOffreCo.setCellValueFactory(new PropertyValueFactory<>("dureeOffre"));
			cheminOffreCo.setCellValueFactory(new PropertyValueFactory<>("cheminOffre"));
			Entreprise_id_EntrepriseCo.setCellValueFactory(new PropertyValueFactory<>("Entreprise_id_Entreprise"));

		}



		public void listOffre(){
			PreparedStatement state1 = null;

			try {

				state1 = (PreparedStatement) connection.prepareStatement("SELECT * FROM `OffreStage`");
				ResultSet rs = state1.executeQuery();

				while(rs.next()){
					int idOffre= rs.getInt("idOffre");
					
					int Entreprise_id_Entreprise= rs.getInt("Entreprise_id_Entreprise");
					String libelleOffre= rs.getString("libelleOffre");
					String descriptifOffre= rs.getString("descriptifOffre");
					String domaineOffre= rs.getString("domaineOffre");
					String dateDebutOffre= rs.getString("dateDebutOffre");
					String dureeOffre= rs.getString("dureeOffre");
					String cheminOffre= rs.getString("cheminOffre");
					

					listeoffre.add(new OffreStage(idOffre,  Entreprise_id_Entreprise,libelleOffre, descriptifOffre, domaineOffre, dateDebutOffre, dureeOffre, cheminOffre));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			tableVoffre.getItems().setAll(listeoffre);


		}



	//clic sur bouton consulter -> page d'offres de stages
	@FXML
	void consulterOffres(ActionEvent event) {
		//System.out.println("bouton os cliqué");
=======
    //clic sur bouton consulter -> page d'offres de stages
    @FXML
    void consulterOffres(ActionEvent event) {
    	//System.out.println("bouton os cliqué");
>>>>>>> sarunyaa/master
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e
>>>>>>> 73f42eab7b21fa84485c73524bd3bc780e9eaf07

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
<<<<<<< HEAD
=======
    
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
>>>>>>> 73f42eab7b21fa84485c73524bd3bc780e9eaf07

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
<<<<<<< HEAD
			//listview.getItems().add(selectedFile.getAbsolutePath());
=======
			path.getItems().add(file.getAbsolutePath());
			pathtext.getCharacters();
>>>>>>> 73f42eab7b21fa84485c73524bd3bc780e9eaf07
			System.out.println("browse");
		}
		else{
			System.out.println("File isn't valid");
		}

<<<<<<< HEAD
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




}

=======
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

<<<<<<< HEAD
	//clique sur "change my profil photo" -> fichier de séléction photo
	public void changerPhotoProfil(ActionEvent event) {
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

=======
>>>>>>> ccb4f467acb2f431cf35554b547d6584567d397e
>>>>>>> 73f42eab7b21fa84485c73524bd3bc780e9eaf07




