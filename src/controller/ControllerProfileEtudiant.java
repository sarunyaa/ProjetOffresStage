package controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import dao.UtilisateurDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

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
	private TextArea path;

	//Etudiant etu;
	private String login;
	private File file;
	private Image image;
	private FileInputStream fis;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		login=UtilisateurConnexion.getLogin();
		if(login==null){
			login=EtudiantController.getLogin();

		};
		
		int idd=UtilisateurDao.getiD("SELECT id_Utilisateur FROM Utilisateur WHERE login='"+login+"'");
		Connection connection = Connect.ConnectDB() ;

		try {
			String sql = "SELECT * FROM Etudiant WHERE idEtudiant='"+idd+"'";
			//	String sql = "SELECT * FROM Etudiant WHERE nom =" + nom + ", prenom =?" ;

		//	String dbName ="test";


			//Etudiant e = new Etudiant(nom, prenom, login, motdepasse);
			PreparedStatement ps=connection.prepareStatement(sql);
			//System.out.println("teest");
			ResultSet rs=ps.executeQuery();
			rs.next();
			int idn = rs.getInt("idEtudiant");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String adresseMail= rs.getString("adresseMail");
			Date Ddn = rs.getDate("dateDeNaissance");



			//	imageP = new ImageView();
			if(rs.getString("photoProfil") != null){
				
				
				InputStream input = new ByteArrayInputStream(rs.getBytes("photoProfil"));
				Image imge = new Image(input);
				imageP.setImage(imge);
				
				
			}
			
			
//					if(rs.getString("CV") != null){
//						InputStream input = new ByteArrayInputStream(rs.getBytes("photoProfil"));
//						File imge = new File(input);
			//PDDocument doc = PDDocument.load(new File(filename));
			//PDFRenderer renderer = new PDFRenderer(doc);
			

			textNom.setText(nom);
			textPrenom.setText(prenom);
			textDdn.setText(Ddn.toString());
			textMail.setText(adresseMail);
			String a = String.valueOf(idn);
			id.setText(a); //attten 
			//	imageP.setImage();

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
	public void charger(ActionEvent event) {


		FileChooser	fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"),
				new ExtensionFilter("All Files", "*.*")
				);		


		photoBrowse.setOnAction(e->{
			file = fileChooser.showOpenDialog(null);
			if (file != null){
				path.setText(file.getAbsolutePath());

				image = new Image(file.toURI().toString());


				imageP.setFitWidth(100);
				imageP.setImage(image);
			}
		});

		buttonMaj.setOnAction(e->{
			try {
				String sql = "UPDATE Etudiant SET nom= ?, prenom=?, photoProfil=? WHERE idEtudiant = ?";

				PreparedStatement ps=connection.prepareStatement(sql);
				//System.out.println("teest");

				ps.setString(1, textNom.getText());
				ps.setString(2, textPrenom.getText());
				System.out.println(textNom.getText());

				fis = new FileInputStream(file);
				ps.setBinaryStream(3, fis, file.length());
				ps.setString(4, id.getText());

				ps.executeUpdate();
				ps.close();

			} catch (Exception e1) {
				e1.printStackTrace();
			}

			//Pop-up
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText(null);
			alert.setContentText("Données mises à jour !");
			alert.showAndWait();

		});		

	}

	@FXML
	void maj(ActionEvent event) throws ClassNotFoundException, SQLException {



	}



}
