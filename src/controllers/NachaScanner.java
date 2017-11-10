package controllers;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NachaScanner {
	
	ArrayList<String> rowArray = new ArrayList<String>();

	public NachaScanner() {}
	
	public ArrayList<String> getRows (String filename) throws IOException{
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new FileReader(filename));
			
			while(scanner.hasNextLine()) {
				
				String line = scanner.nextLine();
				rowArray.add(line);
			}
			
		}finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	
		return rowArray;
	}
	
	

}
