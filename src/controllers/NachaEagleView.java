package controllers;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/*This class will check if the file is empty
 * If file meets the 94 characters per line
 * 
 * 
 */

public class NachaEagleView {
	
	private boolean filepass=true;

	public NachaEagleView() {

	}
	
	public void nachacheckfile(String[] nachafile) {
		
		ArrayList<String> nachafilestringerrors = new ArrayList<String>();
		
		for(int i =0; i < nachafile.length; i++) {
			String stringofarray = (String) nachafile[i];
			
			int linenumber =i+1;
			
			if(stringofarray.length() != 94 || stringofarray.isEmpty()) {
				nachafilestringerrors.add("Line " + linenumber + " has a total of " + stringofarray.length() + " :You need a total of 94 per line.");
				
				
				filepass = false;
			}
		}
		
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Error");
		alert.setHeaderText("Nacha needs to be exact 94 characters");
		alert.setContentText("Please correct the following lines:"
				+ nachafilestringerrors);
		alert.showAndWait();
	}
	
	public boolean getfilepass() {
		return filepass;
	}

}
