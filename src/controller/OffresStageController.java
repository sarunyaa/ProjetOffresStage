package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.EtudiantDao;
import dao.OffreStageDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Etudiant;
import model.OffreStage;
import model.Utilisateur;

public class OffresStageController implements Initializable {

	//initialiser la conx a la BD
	Connection connection = Connect.ConnectDB() ;


	//les champs du tableau offresTab
	
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
	private Button backP;


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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("ok");
		initCol();

		consulterOffre();
	}


	public void consulterOffre(){
		//pr la cnx a la BD
		Connect conx = new Connect();
		String affiche="SELECT * FROM `OffreStage` ";
		ResultSet rs=conx.excuteQuery(affiche) ;
		System.out.println("req SELECT oK");
		try {
			while(rs.next()){
				int idOffre= rs.getInt("idOffre");
				System.out.println(idOffre);
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
				int Entreprise_id_Entreprise= rs.getInt("Entreprise_id_Entreprise");
				System.out.println(Entreprise_id_Entreprise);

				liste.add(new OffreStage(idOffre, Entreprise_id_Entreprise, descriptifOffre, domaineOffre, dateDebutOffre, dureeOffre, cheminOffre, libelleOffre));

			//	liste.add(new OffreStage(libelleOffre, descriptifOffre, domaineOffre, dateDebutOffre, dureeOffre, cheminOffre));
				System.out.println(liste);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		offresTab.getItems().setAll(liste);

	}

	@FXML
	public void retournerP(ActionEvent event){		
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
		primaryStage.setTitle("Candidater aux offres");
		primaryStage.show();
		primaryStage.setResizable(false);
		((Node) event.getSource()).getScene().getWindow().hide();
	}
}

/*
	@FXML
	public void consulterOffre(ActionEvent event) throws ClassNotFoundException {
		int idOffre=idOffreCo.getCellData(0);
		String libelleOffre = libelleOffreCo.getCellData(0);
		String descriptifOffre = descriptifOffreCo.getCellData(0);
		String domaineOffre = domaineOffreCo.getCellData(0);
		String dateDebutOffre = dateDebutOffreCo.getCellData(0);
		String dureeOffre = dureeOffreCo.getCellData(0);
		String cheminOffre = cheminOffreCo.getCellData(0);
		int Entreprise_id_Entreprise=Entreprise_id_EntrepriseCo.getCellData(0);

		OffreStage offre = new OffreStage(idOffre, libelleOffre, descriptifOffre, domaineOffre,
				dateDebutOffre, dureeOffre, cheminOffre, Entreprise_id_Entreprise);

		OffreStageDao dao = new OffreStageDao();
		liste=dao.afficher();
		offresTab.getItems().setAll(liste);

	}
 */

