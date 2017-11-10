/*package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Checksum;

public class Main {



	public static void main(String[] args) throws IOException {
		
		boolean fileflag = false;
		ArrayList<String> allRows = new ArrayList<String>();
		
		
		NachaScanner nachaScanner = new NachaScanner();
		
		try {
		allRows = nachaScanner.getRows("ccdtest.txt");
		}finally {
			
		}
		//testing
		
		 * we need to convert the obj array to a string array so we can
		 * start splitting it to check in detail
		 * 
		 
		//First step: convert ArrayList to an Object array
		Object[] objRowArray = allRows.toArray();
		//Second step: convert Object array to String Array
		String[] strRowArrays = Arrays.copyOf(objRowArray, objRowArray.length, String[].class);
		
		// --------------check file to make sure it is not empty also------------
		//---------------to make sure it follows nacha specs --------------------
		
		NachaEagleView checkfile = new NachaEagleView();
		checkfile.nachacheckfile(strRowArrays);
		
		// --------------split file and send it to corresponding records --------
		
		
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
		

	}

}
*/