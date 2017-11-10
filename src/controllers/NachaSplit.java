package controllers;

import java.util.ArrayList;

/*This class is for splitting the nacha file to separete String Array.
 * This will allow the program to search each individual line record for specs
 * It will split the file by record
 * It will also copy the first line of each record to then check that it follows a sequence
 */

public class NachaSplit {
	
	private ArrayList<String> record1 = new ArrayList<String>();
	private ArrayList<String> record5 = new ArrayList<String>();
	private ArrayList<String> record6 = new ArrayList<String>();
	private ArrayList<String> record8 = new ArrayList<String>();
	private ArrayList<String> record9 = new ArrayList<String>();
	
	//private char[] firstrecordnumber;
	

	public NachaSplit() {

	}
	
	public void nachaRecordSplit(String[] nachafile) {
		
		for(int i = 0; i < nachafile.length; i++) {
			
			String stringofarray = (String) nachafile[i];
			
			if(stringofarray.startsWith("6")) {
				record6.add(stringofarray);
			}else if(stringofarray.startsWith("5")) {
				record5.add(stringofarray);
			}else if(stringofarray.startsWith("8")) {
				record8.add(stringofarray);
			}else if(stringofarray.startsWith("9")) {
				record9.add(stringofarray);
			}else if (stringofarray.startsWith("1")) {
				record1.add(stringofarray);
			}
		}

	}

	public ArrayList<String> getRecord1() {return record1;}
	public ArrayList<String> getRecord5() {return record5;}
	public ArrayList<String> getRecord6() {return record6;}
	public ArrayList<String> getRecord8() {return record8;}
	public ArrayList<String> getRecord9() {return record9;}
	
	

	
}
