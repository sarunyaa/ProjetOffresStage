package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import controller.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.OffreStage;

public class OffreStageDao {

	java.sql.Connection connection;
	Connect co;
	ObservableList<OffreStage> liste= FXCollections.observableArrayList();
	final String affiche="SELECT * FROM `OffreStage` ";
	
	public OffreStageDao() {

		//Connexion avec la bdd
		connection = Connect.ConnectDB() ;	
	}
/*	
	public void afficher(){
		ResultSet rs=co.excuteQuery(affiche) ;
		System.out.println("req SELECT oK");
		try {
			while(rs.next()){
				int idOffre= rs.getInt("idOffre");
				System.out.println(idOffre);
				String libelleOffre= rs.getString("libelleOffre");
				System.out.println(libelleOffre);
				String descriptifOffre= rs.getString("descriptifOffre");
				System.out.println(descriptifOffre);
				String domaineOffre= rs.getString("domaineOffre");
				System.out.println(domaineOffre);
				String dateDebutOffre= rs.getString("dateDebutOffre");
				System.out.println(dateDebutOffre);
				String dureeOffre= rs.getString("dureeOffre");
				System.out.println(dureeOffre);
				String cheminOffre= rs.getString("cheminOffre");
				System.out.println(cheminOffre);
				int Entreprise_id_Entreprise= rs.getInt("Entreprise_id_Entreprise");
				System.out.println(Entreprise_id_Entreprise);
				
				liste.add(new OffreStage(idOffre, libelleOffre, descriptifOffre, domaineOffre, dateDebutOffre, dureeOffre, cheminOffre, Entreprise_id_Entreprise));
				System.out.println(liste);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	

	}
	/*
	idOffre
	libelleOffre	
	descriptifOffre
	domaineOffre
	dateDebutOffre
	dureeOffre
	cheminOffre
	Entreprise_id_Entreprise
	*/
}

