package application;

import java.io.IOException;
import java.net.URL;

import controller.Loader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) {
	/*	try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/Accueil.fxml"));
			primaryStage.setScene(new Scene(root, 850,600));
			primaryStage.show();
			} catch (Exception ex) {
		} */
		
		
			//Parent root = null;
		/*	
			try {
				root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Accueil.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			primaryStage.setScene(new Scene(root, 800,600));
			primaryStage.show();
		
		
	} */
			
			try {
			      // Localisation du fichier FXML.
			      final URL url = getClass().getClassLoader().getResource("view/Accueil.fxml");
			      
			      // Création du loader.
			      final FXMLLoader fxmlLoader = new FXMLLoader(url);
			      
			      // Chargement du FXML.
			      final AnchorPane root = (AnchorPane) fxmlLoader.load();
			      
			      // Création de la scène.
			      final Scene scene = new Scene(root, 800, 600);
			      primaryStage.setScene(scene);
			    } catch (IOException ex) {
			      System.err.println("Erreur au chargement: " + ex);
			    }
			    primaryStage.setTitle("Accueil");
			    primaryStage.show();
			  }
			


	}	

