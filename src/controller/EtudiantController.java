package controller;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class EtudiantController implements Initializable {
	
	Connection connection = Connect.ConnectDB() ;

	
	@FXML
	private TextField textNom;
	
	@FXML
	private TextField textPrenom;
	
	@FXML
	private TextField textDdn;
	
	@FXML
	private TextField textNiv;
	
	@FXML 
	private TextField textMail;
	
	@FXML
	private TextField textLogin;
	
	@FXML
	private TextField textMDP;
	
	@FXML
	private Button buttonOk = new Button();
	
	//Inscription
		ObservableList<String> niveauList = FXCollections
				.observableArrayList("Choisir niveau","BAC+2", "BAC+3", "BAC+4", "BAC+5");
		
		@FXML
		private ComboBox<String> choixNiveau = new ComboBox();
		
		
		//Initilisation des choix
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			//choixNiveau.setValue("Choisir un niveau");
			choixNiveau.setItems(niveauList);		
			
		}
	
	
	
	public void sinscrire(int idEtudiant,String nom,String prenom, Date dateDeNaissance, String niveauEtude, String adresseMail)throws ClassNotFoundException, SQLException{
		 
		 
		 buttonOk.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				if(event.getSource()==buttonOk){
					System.out.println("bouton OK cliqué");	
					
					String nom=textNom.getText();
					String prenom=textPrenom.getText();
					String ddn=textDdn.getText();
					String niveau=textNiv.getText();
					String mail=textMail.getText();
					String login=textLogin.getText();
					String motdepasse=textMDP.getText();
					

					 PreparedStatement state,state1;
			         ResultSet res;
					 boolean flag =false ;
					 
					 try{
					 String req1 = "SELECT `idEtudiant`,`nom`,`prenom`, `dateDeNaissance`,`niveauEtude`,`adresseMail` FROM Etudiant WHERE nom=? AND prenom=? "
					 		+ "AND dateDeNaissance=? AND niveauEtude=? AND  adresseMail=?";
						state1 = connection.prepareStatement(req1);
						
						state1.setInt(1,idEtudiant);
						 state1.setString(2,nom);
						 state1.setString(3,prenom);
						 res=state1.executeQuery();	
						 
						 if (res != null){
						        flag=true;
			           
					      while(res.next()){
								state = connection.prepareStatement("insert into Etudiant (idEtudiant,nom,prenom,dateDeNaissance,niveauEtude,adresseMail)values(?,?,?,?,?,?)");
								state.setInt(1,idEtudiant);
								state.setString(1,nom);
								state.setString(2,prenom);
								state.setDate(3,dateDeNaissance);
								state.setString(4,niveauEtude);
								state.setString(5,adresseMail);
								//rajouter login + mdp ? a recuperer de l'utilisateur
								
								int rs= state.executeUpdate();
					        
					System.out.println("Etudiant ajouté");
								
					      }
				       } else System.out.println("Etudiant pas ajouté");
				    	   
				       } catch(SQLException e){
							e.printStackTrace();
				       }
				}
				}  
				
			});
			 
		 }
		 
		 
		 
	  

}

