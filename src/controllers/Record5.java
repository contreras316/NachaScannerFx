package controllers;

import java.util.ArrayList;

public class Record5 {
	
	//private String serviceClassType; //will be needed for record 6 validation
	private String achId;
	private String stringrow;

	public Record5(String achid) {
		this.achId = achid;
		}
	
	public void scanRowOne(ArrayList<String> row) {
		

		
		if(row.isEmpty()) {
			System.out.println("Error: Could not read record type 5. It's either missing or currupted.");
			return;
		}else {
				
				for(int i =0; i< row.size(); i++) {
					
					stringrow = (String) row.get(i);
					splitandcheckfields();
			}
		}
		
		
		
	}//end of scanrowone method
	
	private void splitandcheckfields() {
		if(stringrow.length() < 2) {System.out.println("record 5 is less than 3");}
		
		String subst5 = stringrow.substring(0,4); //5200 5220 5225
		String substCompanyId = stringrow.substring(40,50); // Banks routing
		

		
		if(!subst5.contains("5200")&& !subst5.contains("5220") && !subst5.contains("5225") ) {
			System.out.println("Record 5: Field 1-4 needs to be either 5200,5220,5225.");
			System.out.println(subst5);
		}
		
		if(!substCompanyId.contains(achId)) {
			System.out.println("Record 5: Field 41-50 needs to be the ACH ID assigned.");
		}
		
		
	}
	
	

}
