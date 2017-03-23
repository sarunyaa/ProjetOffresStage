package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Utilisateur;

public class ControlUtilisateur {

	@FXML
	private TextField textLogin;

	@FXML
	private TextField textMDP;

	@FXML
	private Button buttonConnex = new Button();
	
	Connection con = Connect.ConnectDB();


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
						String req = "SELECT * FROM `Admin` WHERE `login`=? and `motdepasse`=?";
						state = con.prepareStatement(req);
						state.setString(1,login); //modifie le login=?
						state.setString(2, motdepasse ) ;
						rs = state.executeQuery();
						if (rs != null){
							while(rs.next()){
								//renvoyer la fenetre utilisateur 
								System.out.println(login);
							}
						}else{
							System.out.println("t'es bête ou quoi ?!");
						}
					} catch(SQLException e){
						e.printStackTrace();
					}
				
				}		

			}

		});

	}
}
