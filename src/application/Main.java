package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


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
		
		
			Parent root = null;
			
			try {
				root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Connexion.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			primaryStage.setScene(new Scene(root, 600,400));
			primaryStage.show();
		
		
	}


	
}
