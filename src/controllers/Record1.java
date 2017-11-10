package controllers;

import java.util.ArrayList;

public class Record1 {
	
	private String stringrow;
	

	public Record1() {}
	
	public void scanRowOne(ArrayList<String> row) {
		

		
		if(row.isEmpty()) {
			System.out.println("Error: Could not read record type 1.");
			return;
		}else if(row.size() > 1) {
			System.out.println("Error: There can only be one Record 1 line in the NACHA file.");
			return;
 
			}else {
				
				for(int i =0; i< row.size(); i++) {
					
					stringrow = (String) row.get(i);
			}
		}
		
		splitandcheckfields();
		
		
		
	}//end of scanrowone method
	
	private void splitandcheckfields() {
		
		String subst101 = stringrow.substring(0,3); //CONSTANT 101 always
		String substaccount = stringrow.substring(4,13); // Banks routing
		
		if(!subst101.contains("101")) {
			System.out.println("Record 1: Field 1-3 needs to be 101.");
		}
		
		if(!substaccount.contains("091000019")) {
			System.out.println("Record 1: Field 4-13 needs to be Wells account 091000019");
		}
		
		
	}
	
	

}
