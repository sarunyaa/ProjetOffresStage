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

}

