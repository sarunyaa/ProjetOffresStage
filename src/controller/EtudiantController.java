package controller;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EtudiantController {
	
	public boolean sinscrir(int idEtudiant,String nom,String prenom, Date dateDeNaissance, String niveauEtude, String adresseMail)throws ClassNotFoundException, SQLException{
		 Connection connection = Connect.ConnectDB() ;
		 PreparedStatement state,state1;
        ResultSet res;
		 boolean flag =false ;
		 
		 state1 = connection.prepareStatement("SELECT `idEtudiant`,`nom`,`prenom`, `dateDeNaissance`,`niveauEtude`,`adresseMail` FROM Etudiant WHERE nom=? AND prenom=? AND dateDeNaissance=? AND niveauEtude=? AND  adresseMail=?");
		 state1.setInt(1,idEtudiant);
		 state1.setString(2,nom);
		 state1.setString(3,prenom);
		 res=state1.executeQuery();
	        if(res.next()){
				state = connection.prepareStatement("insert into Etudiant (idEtudiant,nom,prenom,dateDeNaissance,niveauEtude,adresseMail)values(?,?,?,?,?,?)");
				state.setInt(1,idEtudiant);
				state.setString(1,nom);
				state.setString(2,prenom);
				state.setDate(3,dateDeNaissance);
				state.setString(4,niveauEtude);
				state.setString(5,adresseMail);
				
				int rs= state.executeUpdate();
	        
	
				if (rs!=0){
			        flag=true;
           }
		
       }  return flag ;  

}
}
