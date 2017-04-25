package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ControllerCv implements Initializable {

	@FXML
	private ImageView Cv;
	@FXML
	private TextField oui;

	//	private File file;
	//	private Image image;
	//	private FileInputStream fis;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Connection connection = Connect.ConnectDB() ;

		try {
			String sql = "SELECT CV FROM Candidatures WHERE idCandidatures= 13;";
			//	String sql = "SELECT * FROM Etudiant WHERE nom =" + nom + ", prenom =?" ;

			//	String dbName ="test";


			//Etudiant e = new Etudiant(nom, prenom, login, motdepasse);
			PreparedStatement ps=connection.prepareStatement(sql);
			//System.out.println("teest");
			//ps.setInt(1, 12);
			ResultSet rs=ps.executeQuery();
			File file =new File("fou");
			FileOutputStream output = new FileOutputStream(file);
			System.out.println("Writing to file " + file.getAbsolutePath());


			while(rs.next()){
				InputStream input = rs.getBinaryStream("CV");
				byte [] buffer = new byte[1024];
				while(input.read(buffer) > 0){
					output.write(buffer);
				}

				
				Desktop d = Desktop.getDesktop();
				d.open(file);

			}
			//			if(rs.getString("CV") != null){
			//				InputStream input = new ByteArrayInputStream(rs.getBytes("CV"));
			//				Image imge = new Image(input);
			//				Cv.setImage(imge);
			//			}


		}catch(Exception e){
			e.printStackTrace();
		}

	}

}


