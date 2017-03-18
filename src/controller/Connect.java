package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Connect {

	Connection conn=null;

	public static Connection ConnectDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gestion_stages","root","");
			System.out.println("création de connexion");
			return con;
		}catch(ClassNotFoundException | SQLException e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}

//con=Connect.ConnectDB();
