package dao;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import controller.Connect;

public class UtilisateurDao implements UtilisateurInterface{
	
	static java.sql.Connection connection;

	final String findU ="SELECT motdepasse FROM `Utilisateur` WHERE `login`= ?";
	final String findType ="SELECT type FROM `Utilisateur` WHERE `type`= ?";
	
    public static int getiD(String requet){
    	int rep=0;
    	Connection conn=Connect.ConnectDB();
		
		try {
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(requet);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			rep=rs.getInt(1);
				
				
			
		}ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return rep;
	}
    
  
	
	@Override
	public String choixType(String type) {
		
		connection = Connect.ConnectDB() ;	
	//	boolean rep=false;

		PreparedStatement state = null;
		ResultSet rs = null; //valeur récupérée par SELECT

		try{
			state =(PreparedStatement) connection.prepareStatement(findType);
			state.setString(1, type);
			rs=state.executeQuery(); //valeur récupérée par SELECT
		state.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		return type;
	}
	
	
	@Override
	public boolean trouver(String login, String pass) {
		connection = Connect.ConnectDB() ;	
		boolean rep=false;

		PreparedStatement state = null;
		ResultSet rs = null; //valeur récupérée par SELECT

		try{
			state =(PreparedStatement) connection.prepareStatement(findU);
			state.setString(1, login);
			rs=state.executeQuery(); //valeur récupérée par SELECT

			while(rs.next()){
				if(rs.getString(1).equals(pass)){
					System.out.println(login + " est connecté");

					return true;

				};		

			}state.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rep;
	}



	
	}


