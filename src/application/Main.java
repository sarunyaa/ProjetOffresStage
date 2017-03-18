package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("View/Accueil.fxml"));
			primaryStage.setScene(new Scene(root, 850,600));
			//root.setStyle("-fx-background-image: url(" + "'file:///Users/sarunyaa/Documents/workspace/Image/src/image1.jpg'" 
			//	+"); " + "-fx-background-size: cover;");
			primaryStage.show();
			} catch (Exception ex) {
		}
	}


	public static void main(String[] args) {
		launch(args);
	}
}
