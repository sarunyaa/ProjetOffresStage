package controller;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.mysql.jdbc.PreparedStatement;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import model.OffreStage;

public class EtuController implements Initializable{
	Connection connection = Connect.ConnectDB() ;

	@FXML
	private ImageView imageP;

	@FXML
	private Button modifierP;

	@FXML
	private TableView<OffreStage> offresTab;
	@FXML
	private TableColumn<OffreStage, Integer> idOffreCo;
	@FXML
	private TableColumn<OffreStage, String>libelleOffreCo;
	@FXML
	private TableColumn<OffreStage, String>descriptifOffreCo;
	@FXML
	private TableColumn<OffreStage, String>domaineOffreCo;
	@FXML
	private TableColumn<OffreStage, String>dateDebutOffreCo;
	@FXML
	private TableColumn<OffreStage, String>dureeOffreCo;
	@FXML
	private TableColumn<OffreStage, String>cheminOffreCo;
	@FXML
	private TableColumn<OffreStage, Integer>Entreprise_id_EntrepriseCo;


	@FXML
	private TextArea intitule;

	@FXML
	private TextArea domaine;

	@FXML
	private TextArea debut;

	@FXML
	private TextArea duree;

	@FXML
	private TextArea description;

	@FXML
	private Button buttonCV;

	@FXML
	private Button buttonLDM;

	@FXML
	private Button buttonPostuler;

	@FXML
	private TextArea pathCV;

	@FXML
	private TextArea pathLDM;

	private File fileCV;
	private File fileLDM;

	private FileInputStream cv;
	private FileInputStream lm;
	//private FileInputStream fis;
	@FXML
	private TextField idEtudiantTF;




	ObservableList<OffreStage> liste= FXCollections.observableArrayList();


	//méthode pr initialiser les colonne du tab
	public void initCol(){
		idOffreCo.setCellValueFactory(new PropertyValueFactory<>("idOffre"));
		libelleOffreCo.setCellValueFactory(new PropertyValueFactory<>("libelleOffre"));
		descriptifOffreCo.setCellValueFactory(new PropertyValueFactory<>("descriptifOffre"));
		domaineOffreCo.setCellValueFactory(new PropertyValueFactory<>("domaineOffre"));
		dateDebutOffreCo.setCellValueFactory(new PropertyValueFactory<>("dateDebutOffre"));
		dureeOffreCo.setCellValueFactory(new PropertyValueFactory<>("dureeOffre"));
		cheminOffreCo.setCellValueFactory(new PropertyValueFactory<>("cheminOffre"));
		Entreprise_id_EntrepriseCo.setCellValueFactory(new PropertyValueFactory<>("Entreprise_id_Entreprise"));

	}


	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("ok");
		initCol();

		consulterOffre();

	}

	public void consulterOffre(){
		PreparedStatement state = null;

		//	System.out.println("req SELECT oK");
		try {

			state = (PreparedStatement) connection.prepareStatement("SELECT * FROM `OffreStage`");
			ResultSet rs = state.executeQuery();

			while(rs.next()){
				int idOffre= rs.getInt("idOffre");
				System.out.println(idOffre);

				int Entreprise_id_Entreprise= rs.getInt("Entreprise_id_Entreprise");
				System.out.println(Entreprise_id_Entreprise);
				String libelleOffre= rs.getString("libelleOffre");
				System.out.println(libelleOffre);
				String descriptifOffre= rs.getString("descriptifOffre");
				System.out.println(descriptifOffre);
				String domaineOffre= rs.getString("domaineOffre");
				System.out.println(domaineOffre);
				String dateDebutOffre= rs.getString("dateDebutOffre");
				System.out.println(dateDebutOffre);
				String dureeOffre= rs.getString("dureeOffre");
				System.out.println(dureeOffre);
				String cheminOffre= rs.getString("cheminOffre");
				System.out.println(cheminOffre);


				liste.add(new OffreStage(idOffre,  Entreprise_id_Entreprise,libelleOffre, descriptifOffre, domaineOffre, dateDebutOffre, dureeOffre, cheminOffre));

				//liste.add(new OffreStage(libelleOffre, descriptifOffre, domaineOffre, dateDebutOffre, dureeOffre, cheminOffre));
				System.out.println(liste);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		offresTab.getItems().setAll(liste);
		System.out.println("zaoimejfhlndkosm");

		//		OffreStage Os = offresTab.getSelectionModel().getSelectedItem();
		//		intitule.setText(Os.getLibelleOffre());




	}



	@FXML
	public void backP(ActionEvent event){


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
		primaryStage.setTitle("Mon Profil");
		primaryStage.show();
		primaryStage.setResizable(false);
		((Node) event.getSource()).getScene().getWindow().hide();
	}



	@FXML
	public void postuler(MouseEvent event){

		OffreStage Os = offresTab.getSelectionModel().getSelectedItem();
		intitule.setText(Os.getLibelleOffre());
		domaine.setText(Os.getDomaineOffre());
		debut.setText(Os.getDateDebutOffre());
		duree.setText(Os.getDureeOffre());
		description.setText(Os.getDescriptionOffre());


	}
	@FXML
	public void postulerOffre(ActionEvent event){


	}

	@FXML
	public void charger(ActionEvent event) {

		FileChooser	fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Image Files", "*.pdf", "*.doc", "*.odt", "*.jpeg", "*.png", "*.doc"),
				new ExtensionFilter("All Files", "*.*")
				);		
		
		

		buttonCV.setOnAction(e->{
			if (idEtudiantTF==null){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Information");
				alert.setHeaderText(null);
				alert.setContentText("Insérer d'abord votre identifiant!");
				alert.showAndWait();
			}
			
			

			fileCV = fileChooser.showOpenDialog(null);
			if (fileCV != null){
				pathCV.setText(fileCV.getAbsolutePath());

			}
		});

		buttonLDM.setOnAction(e->{

			System.out.println("dfghjkljhgfdsqdfghjkljhgfd");
			fileLDM = fileChooser.showOpenDialog(null);
			if (fileLDM != null){
				pathLDM.setText(fileLDM.getAbsolutePath());

			}
		});

		
//		
		OffreStage Os = offresTab.getSelectionModel().getSelectedItem();
		int idoff= Os.getIdOffre();
		int identr= Os.getEntreprise_id_Entreprise();
		Integer idEt= Integer.valueOf(idEtudiantTF.getText());

		
	//	int idetud = Integer.parseInt(idEt); 

		buttonPostuler.setOnAction(e->{

		try {
		String sql = "INSERT into Candidatures (OffreStage_idOffre, Etudiant_idEtudiant, "
		+ "Offres_Entreprise_idEntreprise,CV,LM) VALUE (?,?,?,?,?);";

		java.sql.PreparedStatement ps=connection.prepareStatement(sql);

		ps.setInt(1, idoff);
		ps.setInt(2, idEt);
		ps.setInt(3, identr);

		cv = new FileInputStream(fileCV);
		lm = new FileInputStream(fileLDM);

	//	ps.setBinaryStream(4, cv, file.length());
		
	
		byte[] pdfDataCV = new byte[(int) fileCV.length()];
		DataInputStream disCV = new DataInputStream(new FileInputStream(fileCV));
		disCV.readFully(pdfDataCV);
		disCV.close();
		ps.setBytes(4, pdfDataCV);
		
		byte[] pdfDataLDM = new byte[(int) fileLDM.length()];
		DataInputStream disLDM = new DataInputStream(new FileInputStream(fileLDM));
		disLDM.readFully(pdfDataLDM);
		disLDM.close();
		ps.setBytes(5, pdfDataLDM);


	//	ps.setBinaryStream(5, lm, file.length());

		ps.executeUpdate();
		ps.close();

		} catch (Exception e1) {
		e1.printStackTrace();
		}

		//Pop-up
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText("Succée !");
		alert.showAndWait();



		});

	}




}






