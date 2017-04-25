package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.PreparedStatement;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import model.Candidature;
import model.CandidatureAcceptee;
import model.Etudiant;
import model.OffreStage;

public class EntrepriseController implements Initializable{
	Connection connection = Connect.ConnectDB() ;

	@FXML
	private TextField NomTA;
	@FXML
	private TextField prenomTA;
	@FXML
	private TextField idTa;
	@FXML
	private ImageView Cv;

	public int a;



	@FXML
	private TableView<CandidatureAcceptee> candidatureAccepteTab2;
	//@FXML
	TableColumn<CandidatureAcceptee, Integer> idEtud3;
	//@FXML
	TableColumn<CandidatureAcceptee, Integer> idCandidat3;



	//afficher le tableau des offres
	@FXML
	private TableView<OffreStage> offresTab;
	@FXML
	private TableColumn<OffreStage, Integer> idOffreCo;
	@FXML
	private TableColumn<OffreStage, Integer>Entreprise_id_EntrepriseCo;
	@FXML
	private TableColumn<OffreStage, String>libelleOffreCo;
	@FXML
	private TableColumn<OffreStage, String>descriptifOffreCo;
	@FXML
	private TableColumn<OffreStage, String>domaineOffreCo;
	@FXML
	private TableColumn<OffreStage, String>dateDebutOffreCo;
	@FXML
	private TableColumn<OffreStage, String>dureeOffreCo;
	@FXML
	private TableColumn<OffreStage, String>cheminOffreCo;


	ObservableList<OffreStage> liste= FXCollections.observableArrayList();


	//afficher le tableau candidatures

	@FXML
	private TableView<Candidature> candidatureTab;
	@FXML
	private TableColumn<Candidature, Integer> idCandidaturesCo;
	@FXML
	private TableColumn<Candidature, Integer>OffreStage_idOffreCo;
	@FXML
	private TableColumn<Candidature, Integer>Etudiant_idEtudiantCo;
	@FXML
	private TableColumn<Candidature, Integer>Offres_Entreprise_idEntrepriseCo;
	@FXML
	private TableColumn<Candidature, Boolean>CVCo;
	@FXML
	private TableColumn<Candidature, Boolean>LMCo;
	//@FXML
	//private TableColumn<Candidature, Hyperlink>lien;


	ObservableList<Candidature> liste2= FXCollections.observableArrayList();

	//afficher tab des candidatures accéptées
	@FXML
	private TableView<CandidatureAcceptee>candidatureAccepteTab;
	@FXML
	TableColumn<CandidatureAcceptee, Integer> idEtud2;
	@FXML
	TableColumn<CandidatureAcceptee, Integer>idCandidat2;
	//@FXML
	//private TableColumn<Etudiant, String>nomEtudA;
	//@FXML
	//private TableColumn<Etudiant, String>prenomEtudA;
	//@FXML
	//private TableColumn<Etudiant, String>adressEtud2;



	ObservableList<Etudiant> liste3= FXCollections.observableArrayList();

	ObservableList<CandidatureAcceptee> liste4= FXCollections.observableArrayList();
	ObservableList<CandidatureAcceptee> liste5= FXCollections.observableArrayList();

	@FXML
	private javafx.scene.control.Button refuserButton;
	@FXML
	private javafx.scene.control.Button accepterButton;



	//méthode pr initialiser les colonne du taboffre
	public void initCol1(){
		idOffreCo.setCellValueFactory(new PropertyValueFactory<>("idOffre"));
		libelleOffreCo.setCellValueFactory(new PropertyValueFactory<>("libelleOffre"));
		descriptifOffreCo.setCellValueFactory(new PropertyValueFactory<>("descriptifOffre"));
		domaineOffreCo.setCellValueFactory(new PropertyValueFactory<>("domaineOffre"));
		dateDebutOffreCo.setCellValueFactory(new PropertyValueFactory<>("dateDebutOffre"));
		dureeOffreCo.setCellValueFactory(new PropertyValueFactory<>("dureeOffre"));
		cheminOffreCo.setCellValueFactory(new PropertyValueFactory<>("cheminOffre"));
		Entreprise_id_EntrepriseCo.setCellValueFactory(new PropertyValueFactory<>("Entreprise_id_Entreprise"));

	}
	//méthode pr initialiser les colonne du tabcandidature
	public void initCol2(){
		idCandidaturesCo.setCellValueFactory(new PropertyValueFactory<>("idCandidature"));
		OffreStage_idOffreCo.setCellValueFactory(new PropertyValueFactory<>("idOffreCandidat"));
		Etudiant_idEtudiantCo.setCellValueFactory(new PropertyValueFactory<>("idEtudiant"));
		Offres_Entreprise_idEntrepriseCo.setCellValueFactory(new PropertyValueFactory<>("idEntrepriseCandidat"));
		//	CVCo.setCellValueFactory(new PropertyValueFactory<>("cv"));
		//LMCo.setCellValueFactory(new PropertyValueFactory<>("lm"));
		CVCo.setSortable(false);
		LMCo.setSortable(false);

		LMCo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Candidature,Boolean>, ObservableValue<Boolean>>() {

			@Override
			public ObservableValue<Boolean> call(CellDataFeatures<Candidature, Boolean> p) {
				// TODO Auto-generated method stub
				return SimpleBooleanProperty(p.getValue() != null);
			}

			private ObservableValue<Boolean> SimpleBooleanProperty(boolean b) {
				// TODO Auto-generated method stub
				return null;
			}
		});

		LMCo.setCellFactory(
				new Callback<TableColumn<Candidature, Boolean>, TableCell<Candidature, Boolean>>(){

					@Override
					public TableCell<Candidature, Boolean> call(TableColumn<Candidature, Boolean> p) {
						return new ButtonCellLDM();
					}

				});


		CVCo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Candidature,Boolean>, ObservableValue<Boolean>>() {


			@Override
			public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Candidature, Boolean> p) {
				return SimpleBooleanProperty(p.getValue() != null);

			}

			private ObservableValue<Boolean> SimpleBooleanProperty(boolean b) {
				// TODO Auto-generated method stub
				return null;
			}
		});


		CVCo.setCellFactory(
				new Callback<TableColumn<Candidature, Boolean>, TableCell<Candidature, Boolean>>(){

					@Override
					public TableCell<Candidature, Boolean> call(TableColumn<Candidature, Boolean> p) {
						return new ButtonCellCV();
					}

				});

	}

	//Define the button cell
	private class ButtonCellCV extends TableCell<Candidature, Boolean> {

		final Button cellButtonCV = new Button("CV");
		//final Button cellButtonLDM = new Button("LDM");

		ButtonCellCV() {

			cellButtonCV.setOnAction(e->{
				System.out.println("button cliker");

				String sql = "SELECT CV FROM `Candidatures` WHERE Etudiant_idEtudiant = '" + a + "'";
				//				String sql = "SELECT nom FROM `Etudiant` WHERE idEtudiant = ?;";

				System.out.println("a =" + a );
				connection = Connect.ConnectDB() ;	

				PreparedStatement ps = null;
				try {

					ps=(PreparedStatement) connection.prepareStatement(sql);

					ResultSet rs=ps.executeQuery(); 

					File fileCV = new File ("CV");
					FileOutputStream output = new FileOutputStream(fileCV);
					System.out.println("Writing to file " + fileCV.getAbsolutePath());
					while(rs.next()){

						InputStream input = rs.getBinaryStream("CV");
						byte[] buffer = new byte[1024];
						while (input.read(buffer) > 0) {
							output.write(buffer);
						}
					}

					Desktop desktop = Desktop.getDesktop();
					desktop.open(fileCV);




					//int idn = rs.getInt("idEtudiant");
					//String nom = rs.getString("nom");


					//String prenom = rs.getString("prenom");
					//String adresseMail= rs.getString("adresseMail");
					//Date Ddn = rs.getDate("dateDeNaissance");
					System.out.println("laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");


					//	System.out.println(nom);
					System.out.println("laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				}




				catch (SQLException ex) {
					ex.printStackTrace();


				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

					);
		}
		
		
		
		
		
		
		
		
		


		//Display button if the row is not empty
		@Override
		protected void updateItem(Boolean t, boolean empty) {
			super.updateItem(t, empty);
			if(!empty){
				setGraphic(cellButtonCV);
			}
		}
	}
	
	//Define the button cell
	private class ButtonCellLDM extends TableCell<Candidature, Boolean> {

		final Button cellButtonLDM = new Button("LDM");
		//final Button cellButtonLDM = new Button("LDM");

		ButtonCellLDM() {

			cellButtonLDM.setOnAction(e->{
				System.out.println("button cliker");

				String sql = "SELECT LM FROM `Candidatures` WHERE Etudiant_idEtudiant = '" + a + "'";
				//				String sql = "SELECT nom FROM `Etudiant` WHERE idEtudiant = ?;";

				System.out.println("a =" + a );
				connection = Connect.ConnectDB() ;	

				PreparedStatement ps = null;
				try {

					ps=(PreparedStatement) connection.prepareStatement(sql);

					ResultSet rs=ps.executeQuery(); 

					File fileLM = new File ("LM");
					FileOutputStream output = new FileOutputStream(fileLM);
					System.out.println("Writing to file " + fileLM.getAbsolutePath());
					while(rs.next()){

						InputStream input = rs.getBinaryStream("LM");
						byte[] buffer = new byte[1024];
						while (input.read(buffer) > 0) {
							output.write(buffer);
						}
					}

					Desktop desktop = Desktop.getDesktop();
					desktop.open(fileLM);




					//int idn = rs.getInt("idEtudiant");
					//String nom = rs.getString("nom");


					//String prenom = rs.getString("prenom");
					//String adresseMail= rs.getString("adresseMail");
					//Date Ddn = rs.getDate("dateDeNaissance");
					System.out.println("laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");


					//	System.out.println(nom);
					System.out.println("laaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				}




				catch (SQLException ex) {
					ex.printStackTrace();


				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

					);
		}
		
		
		
		
		
		
		
		
		


		//Display button if the row is not empty
		@Override
		protected void updateItem(Boolean t, boolean empty) {
			super.updateItem(t, empty);
			if(!empty){
				setGraphic(cellButtonLDM);
			}
		}
	}
	
	



	public void initCol4(){
		idEtud3.setCellValueFactory(new PropertyValueFactory<>("idEtud3"));

		idCandidat3.setCellValueFactory(new PropertyValueFactory<>("idCandidat3"));

	}

	//méthode pr initialiser les colonne du tabCandidatureAccèptée
	public void initCol3(){
		idEtud2.setCellValueFactory(new PropertyValueFactory<CandidatureAcceptee,Integer>("idEtud2"));
		idCandidat2.setCellValueFactory(new PropertyValueFactory<CandidatureAcceptee,Integer>("idCandidat2"));


	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initCol1();
		initCol2();

		consulterOffre();
		consulterCandidature();
		//	initCol3();
		//	initCol4();
		//tableauCandidatA();
		//accepterCandidature(event);
	}


	//méthode pour afficher le contenu du tableau candidature
	public void consulterCandidature(){

		PreparedStatement state = null;

		try {

			state = (PreparedStatement) connection.prepareStatement("SELECT * FROM `Candidatures`");
			ResultSet rs = state.executeQuery();

			while(rs.next()){

				int idCandidature= rs.getInt("idCandidatures");
				System.out.println(idCandidature);
				int idOffreCandidat= rs.getInt("OffreStage_idOffre");
				System.out.println(idOffreCandidat);
				int idEtudiant= rs.getInt("Etudiant_idEtudiant");
				System.out.println(idEtudiant);
				int idEntrepriseCandidat= rs.getInt("Offres_Entreprise_idEntreprise");
				System.out.println(idEntrepriseCandidat);

				//ajouter une ligne pr l'hypertext

				//InputStream input1= new ByteArrayInputStream(rs.getBytes("CV"));
				//InputStream input2= new ByteArrayInputStream(rs.getBytes("LM"));

				liste2.add(new Candidature(idCandidature, idEtudiant,idEntrepriseCandidat,idOffreCandidat));
			}
		}catch (Exception e) {
			e.printStackTrace();
			//	System.out.println("erreur");
		}
		candidatureTab.getItems().setAll(liste2);
	}

	//méthode pour afficher le contenu de la table des offres
	public void consulterOffre(){
		PreparedStatement state = null;

		//	System.out.println("req SELECT oK");
		try {

			state = (PreparedStatement) connection.prepareStatement("SELECT * FROM `OffreStage`");
			ResultSet rs = state.executeQuery();

			while(rs.next()){
				int idOffre= rs.getInt("idOffre");
				System.out.println(idOffre);

				int Entreprise_id_Entreprise= rs.getInt("Entreprise_id_Entreprise");
				System.out.println(Entreprise_id_Entreprise);
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


				liste.add(new OffreStage(idOffre,  Entreprise_id_Entreprise,libelleOffre, descriptifOffre, domaineOffre, dateDebutOffre, dureeOffre, cheminOffre));

				//liste.add(new OffreStage(libelleOffre, descriptifOffre, domaineOffre, dateDebutOffre, dureeOffre, cheminOffre));
				System.out.println(liste);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		offresTab.getItems().setAll(liste);
		System.out.println("zaoimejfhlndkosm");
	}

	//MÉTHODE PR RECUP LES INFO DE LA LIGNE SELECTIONNEE (CANDIDATURE)

	@FXML
	public void selectionerCandidature(MouseEvent event){

		Candidature cd = candidatureTab.getSelectionModel().getSelectedItem();
		int id = cd.getIdEtudiant();
		a = id;
		System.out.println("llalaalalalalalalalalalalalalaal" + id);

		String sql = "SELECT * FROM Etudiant WHERE idEtudiant= ?";

		java.sql.PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			//System.out.println("lla" + id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){

				String nomE = rs.getString("nom");
				//	System.out.println("lla" + nomE);
				String prenomE = rs.getString("prenom");

				//String adresseMailE= rs.getString("adresseMail");

				//remplire les champs à gauche
				//String a = String.valueOf(id);
				//idTa.setText(a);
				//idTa.setText("KKK");
				//System.out.println("azaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " + a);

				NomTA.setText(nomE);
				prenomTA.setText(prenomE);
				//	idTa.setText(Integer.toString( id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	@FXML
	public void accepterCandidature(ActionEvent event) {

		Candidature cd = candidatureTab.getSelectionModel().getSelectedItem();
		int ide = cd.getIdEtudiant();
		int idc= cd.getIdCandidature();
		liste5.add(new CandidatureAcceptee(ide,idc));
		candidatureAccepteTab2.getItems().setAll(liste5);



	}

	//	//méthode pr remplire le tableau candidatureAcceptée(en cliquant sur le boutton "accepter")
	//	@FXML
	//	public void accepterCandidature(ActionEvent event) {
	//
	//		final String insertCA = "INSERT into CandidaturesAcceptés ( Etudiant_idEtudiant) VALUE (?);";
	//		//final String select = "SELECT * FROM `Etudiant` WHERE idEtudiant=;";
	//
	//		PreparedStatement statement = null;
	//
	//		//ici on récupère des champs remplis a gauche
	//		//String i = String.valueOf(idTa.getText());
	//		String n=NomTA.getText();
	//		String p=prenomTA.getText();
	//		System.out.println("iciiiiiiiiiiiiiiiiiiiiii");
	//		System.out.println(n);
	//		System.out.println(p);
	//
	//
	//		//et on rajoute dans le tableau des candidature accéptées a droite 
	//		//Etudiant etudiant = new Etudiant(i,n,p);
	//		Etudiant etudiant = new Etudiant(n,p);
	//		System.out.println("nooononononononoononnononono");
	//
	//
	//		liste3.add(etudiant);
	//		System.out.println("okkkkkkk");
	//		candidatureAccepteTab.getItems().setAll(liste3);
	//		System.out.println("KOOO");
	//
	//		try {
	//			statement = (PreparedStatement) connection.prepareStatement(insertCA);
	//			//statement.setInt(1, 0);
	//			statement.setInt(1,etudiant.getIdEtudiant());
	//			//statement.setString(2, etudiant.getPrenom());
	//
	//
	//			statement.execute();
	//
	//
	//		} catch (SQLException ex) {
	//			ex.printStackTrace();
	//		} finally {
	//			try {
	//				statement.close();
	//			} catch (SQLException ex) {
	//				ex.printStackTrace();
	//			}
	//		}
	//	}

	//méthode pr remplire le tableau candidatureAcceptée(en cliquant sur le boutton "accepter")
	@FXML
	/*public void accepterCandidature(ActionEvent event) {


		Candidature cd = candidatureTab.getSelectionModel().getSelectedItem();
		int ide = cd.getIdEtudiant();
		int idc= cd.getIdCandidature();

		final String insertCA = "INSERT into CandidaturesAcceptés ( Candidatures_idCandidatures,Etudiant_idEtudiant) VALUE (?,?);";
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(insertCA);

			statement.setInt(1, ide);
			statement.setInt(2, idc);
			statement.execute();
			System.out.println("uuuuu");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	 */
	public void tableauCandidatA(){

		//récupèrer l'id de l'etudiant séléctionné 
		//	Candidature cd = candidatureTab.getSelectionModel().getSelectedItem();
		//	int idd = cd.getIdEtudiant();
		//int idc=cd.getIdCandidature();
		//System.out.println(idd);
		//	System.out.println(idc);
		String sql = "SELECT * FROM CandidaturesAcceptés ";
		System.out.println("req ok ");
		java.sql.PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			//		ps.setInt(1, idd);
			//		ps.setInt(2, idc);

			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int k=rs.getInt("Etudiant_idEtudiant");
				int j= rs.getInt("Candidatures_idCandidatures");
				System.out.println("result ok");
				/*String nomE = rs.getString("nom");
				String prenomE = rs.getString("prenom");
				String adresseE= rs.getString("adresseMail");
				 */
				//mtn on affiche ds le tableau des candidature accepté 

				liste4.add(new CandidatureAcceptee(k,j));
				System.out.println(k + "            " + j);
				System.out.println(liste4);
				//candidatureAccepteTab.getItems().setAll(liste4);
				candidatureAccepteTab.setItems(liste4);
				candidatureAccepteTab.setVisible(true);
				System.out.println("zaoimejfhlndkosm");
			}


		} catch (SQLException ex) {
			ex.printStackTrace();
		}


	}





	//méthode refuser une candidature en la supprimant de la table candidature(bouton "refuser")
	@FXML
	public void refuserCandidature(ActionEvent event) {
		Candidature cd1 = candidatureTab.getSelectionModel().getSelectedItem();
		int idC = cd1.getIdCandidature();

		String sql = "DELETE FROM Candidatures WHERE idCandidatures= ?";

		java.sql.PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idC);
			//ResultSet rs=
			ps.executeUpdate();
			//while(rs.next()){
			//Pop-up
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText(null);
			alert.setContentText("Candidature supprimée !");
			alert.showAndWait();
			//}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}







