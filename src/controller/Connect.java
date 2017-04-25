package controller;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.stage.FileChooser;

public class Connect {

	Connection conn=null;
	Statement state;

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
	
	//méthode prédefini pour executeQuery (pr select, delete)
		public ResultSet excuteQuery(String requette){
			ResultSet resultat;
			try{
				state= (Statement) conn.createStatement();
				resultat= state.executeQuery(requette);
			}catch(SQLException ex){
				System.out.println("Exception at executeQuery:Connect"+ex.getLocalizedMessage());
				return null;
			}finally{

			}
			return resultat;
		}
		
		public boolean excute(String requette2){
			ResultSet resultat;
			try{
				state= (Statement) conn.createStatement();
				state.execute(requette2);
				return true;
			}catch(SQLException ex){

				JOptionPane.showMessageDialog(null, "error:"+ex.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
				System.out.println("Exception at execute:Connect"+ex.getLocalizedMessage());
				return false;
			}finally{

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
