package controller;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.stage.FileChooser;

public class Connect {

	Connection conn=null;
	
	String filename= null;
	public static String path;

	public static Connection ConnectDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/gestion_stages","root","");
			System.out.println("Connexion avec BDD ok");
			return con;
		}catch(ClassNotFoundException | SQLException e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	public void filen() {
		try {

			FileChooser chooser = new FileChooser();
			chooser.setTitle("Choisir une image png");
			// chooser.setApproveButtonText("Ajouter une image");
			chooser.showOpenDialog(null);
			File f = chooser.showOpenDialog(null);
			filename = f.getAbsolutePath();
			this.path = (filename);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public String getp(){

		return path; 
	}

}

//con=Connect.ConnectDB();
