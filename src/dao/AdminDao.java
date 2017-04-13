package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.controlsfx.control.Notifications;

import com.mysql.jdbc.PreparedStatement;
import com.sun.javafx.collections.MappingChange.Map;

import controller.AdminConnexion;
import controller.Connect;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.util.Duration;
import model.Admin;

public class AdminDao implements AdminInterface {

	java.sql.Connection connection;

	final String findA ="SELECT motdepasse FROM `Admin` WHERE `login`= ?";


	public AdminDao(){
		//Connexion avec la bdd
		connection = Connect.ConnectDB() ;	
	}

	@Override
	public boolean trouver(String login, String pass) {
		
		connection = Connect.ConnectDB() ;	
		boolean rep=false;

		PreparedStatement state = null;
		ResultSet rs = null; //valeur récupérée par SELECT

		try{
			state =(PreparedStatement) connection.prepareStatement(findA);
			state.setString(1, login);
			rs=state.executeQuery(); //valeur récupérée par SELECT

			while(rs.next()){
				if(rs.getString(1).equals(pass)){
					System.out.println(login + " est connecté en tant qu'administrateur");

					return true;

				};		

			}state.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rep;
	}


}


