package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Utilisateur;

public class ControlUtilisateur  {
	
	

	//Ouverture connexion BD
	Connection con = Connect.ConnectDB();

	//Authentification 
	@FXML
	private TextField textLogin;

	@FXML
	private TextField textMDP;

	@FXML
	private Button buttonConnex = new Button();
	
	@FXML
    private Hyperlink retourLink;
	
	@FXML
    private RadioButton radioEtudiant;

    @FXML
    private RadioButton radioEntreprise;


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
	

	
	@FXML
	public void sauthentifier(Event event)throws Exception{
		//public void sauthentifier(String login, String motdepasse) throws ClassNotFoundException, SQLException{


		buttonConnex.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				if(event.getSource()==buttonConnex){
					System.out.println("bouton connexion cliqué");	
					String login=textLogin.getText();
					String motdepasse=textMDP.getText();	

					PreparedStatement state =null;
					ResultSet rs; //valeur récupérée par SELECT
					//System.out.println(login);

					
					try{
						String req = "SELECT * FROM `Etudiant` WHERE `login`=? and `motdepasse`=?";
						state = con.prepareStatement(req);
						state.setString(1,login); //modifie le login=?
						state.setString(2, motdepasse ) ;
						rs = state.executeQuery();
						if (rs != null){
							while(rs.next()){
								//renvoyer la fenetre utilisateur 
								System.out.println(login + "connecté");
							}
						}else{
							System.out.println("Utilisateur inconnu");
						}
					} catch(SQLException e){
						e.printStackTrace();
					}
				
				}		

			}

		});

	}


	
}
