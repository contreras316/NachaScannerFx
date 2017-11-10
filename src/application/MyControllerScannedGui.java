package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MyControllerScannedGui implements Initializable {
	
	private Stage primaryStage;
	
	private AnchorPane mainLayout;
	
	public void setStage(Stage stage) {
		this.primaryStage = stage;
	}
	
	@FXML
	Button btnBack;

	@Override
	public void initialize(URL location, ResourceBundle resources) {}
	
	public void btnBackAction(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("mainFXML.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		
		//send stage instance to controller
		MyControllerMainGui myControllerMainGui = loader.getController();
		myControllerMainGui.setStage(this.primaryStage);
		
	}
	
	

}
