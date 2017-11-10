package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private Stage primaryStage;
	private AnchorPane mainLayout;
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Nacha Scanner");
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("mainFXML.fxml"));
			mainLayout = loader.load();
			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//send stage instance to controller
			MyControllerMainGui myControllerMainGui = loader.getController();
			myControllerMainGui.setStage(this.primaryStage);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
