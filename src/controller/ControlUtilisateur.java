package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Utilisateur;

public class ControlUtilisateur {
@FXML
private TextField textLogin;
@FXML
private TextField textMDP;


	
@FXML
public void sautehntifier(Event event)throws Exception{
	//public void sautehntifier(String login, String motdepasse) throws ClassNotFoundException, SQLException{
	
	String login=textLogin.getText().trim();
	String motdepasse=textMDP.getText().trim();	
	
	Connection con = Connect.ConnectDB();
	PreparedStatement state =null;
	ResultSet rs;
	state =con.prepareStatement("SELECT * FROM utilisateur WHERE login=? and motdepasse=?");
    state.setString(1,login); 
    state.setString(2, motdepasse ) ;
    rs=state.executeQuery();
    if(rs.next()){
    	//renvoyer la fenetre utilisateur 
    	
    }else{
    	//renvoyer une fenetre d'alerte login ou mdp incorrect
   
   state.close();
   
}
}

}
