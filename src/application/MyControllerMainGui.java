package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import controllers.NachaEagleView;
import controllers.NachaScanner;
import controllers.NachaSplit;
import controllers.Record1;
import controllers.Record5;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MyControllerMainGui implements Initializable {
	private Stage primaryStage;
	String fileAsString;
	private boolean emptyField = false;
	private boolean filepass = false;
	
	public void setStage(Stage stage) {
		this.primaryStage = stage;
	}
	
	@FXML
	private Button btnRun;
	@FXML
	private Label labelFieldFilePath;
	@FXML
	private TextField textFieldAchId;
	
	private BorderPane mainLayout;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void browseNachaFile(ActionEvent event) throws IOException {

		
		FileChooser chooser = new FileChooser();
		chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text", "*.txt"));
		chooser.setTitle("Select Nacha file");
		File file = chooser.showOpenDialog(primaryStage);
		if (file != null) {
			fileAsString = file.toString();
			labelFieldFilePath.setText(fileAsString);
		}else {}

	}
	
	public void runNachaFile(ActionEvent event) throws IOException {
		

		

		String textachid = textFieldAchId.getText().trim();
		String nachafilepath = labelFieldFilePath.getText();
		
		if(textachid.isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("ACH ID is blank");
			alert.setContentText("Please type in an ACH ID");
			alert.showAndWait();
			emptyField = true;
		}else if (nachafilepath.isEmpty()) {
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("File Path is empty");
			alert.setContentText("Please select a text file please");
			alert.showAndWait();
			emptyField = true;
		}else {
			emptyField = false;
		}
			
		
		if (!emptyField) {
			
			ArrayList<String> allRows = new ArrayList<String>();
			
			
			NachaScanner nachaScanner = new NachaScanner();
			
			try {
			allRows = nachaScanner.getRows(fileAsString);
			}finally {
				
			}
			//testing
			/*
			 * we need to convert the obj array to a string array so we can
			 * start splitting it to check in detail
			 * 
			 */
			//First step: convert ArrayList to an Object array
			Object[] objRowArray = allRows.toArray();
			//Second step: convert Object array to String Array
			String[] strRowArrays = Arrays.copyOf(objRowArray, objRowArray.length, String[].class);
			
			// --------------check file to make sure it is not empty also------------
			//---------------to make sure it follows nacha specs --------------------
			
			NachaEagleView checkfile = new NachaEagleView();
			checkfile.nachacheckfile(strRowArrays);
			Boolean filestatus = checkfile.getfilepass();
			
			
			
			
			// --------------split file and send it to corresponding records --------
			
			if (filestatus) {
				
				
				NachaSplit splitnachafile = new NachaSplit();
				splitnachafile.nachaRecordSplit(strRowArrays);
				
				
				ArrayList<String> arrayOfRecord1 = new ArrayList<String>();
				ArrayList<String> arrayOfRecord5 = new ArrayList<String>();
				ArrayList<String> arrayOfRecord6 = new ArrayList<String>();
				ArrayList<String> arrayOfRecord8 = new ArrayList<String>();
				ArrayList<String> arrayOfRecord9 = new ArrayList<String>();
				
				arrayOfRecord1 = splitnachafile.getRecord1();
				arrayOfRecord5 = splitnachafile.getRecord5();
				arrayOfRecord6 = splitnachafile.getRecord6();
				arrayOfRecord8 = splitnachafile.getRecord8();
				arrayOfRecord9 = splitnachafile.getRecord9();
				

				Record1 row1 = new Record1();
				row1.scanRowOne(arrayOfRecord1);
				
				Record5 row5 = new Record5("1234567890");
				row5.scanRowOne(arrayOfRecord5);

				
				
				System.out.println("End of program...shuting down..");


				
			

			FXMLLoader loader = new FXMLLoader();
			
			
			loader.setLocation(Main.class.getResource("NachaScannedGUI.fxml"));
			mainLayout = loader.load();
			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			
			//send stage instance to controller
			MyControllerScannedGui myControllerScannedGui = loader.getController();
			myControllerScannedGui.setStage(this.primaryStage);
			
				
			}

			
		}
		System.out.println("End of program");
			
		}
	}

	
	
	

