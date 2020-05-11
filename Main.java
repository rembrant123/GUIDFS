package application;
	
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;


public class Main extends Application {


	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/Test.fxml"));
			// Create a scene and place it in the stage
 			Scene scene = new Scene(root);
 			scene.getStylesheets().add("application.css");
 			stage.setTitle("Input elements app"); // Set the stage title
 			stage.setScene(scene); // Place the scene in the stage
 			stage.show(); 
		} catch(Exception e) {
			//e.printStackTrace();
		} 


	}
	
	public static void main(String[] args) {
		Application.launch(args);
    }

}
