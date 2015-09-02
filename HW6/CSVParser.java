/*************************************************************************
 *  ID: A11163016 
 *  NAME: Peter Tran
 *  LOGIN: cs11ehc
 *
 *  Requires: 
 *  About:  
 *************************************************************************/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class CSVParser {
    
    /**
     * Asks for a CSV formatted value and parses the line read in
     * which eliminates the commas and stores the line into tempData
     * which will then be converted into an array and return the address
     * of that array.
     *
     * @param filename is the CSV file containing stock information
     * @return String[][] returns the array address of the values stored
     */
    public static String[][] parse(String filename) throws IOException {
		ArrayList<String[]> tempData = new ArrayList<String[]>();
		String header = "";
		String current = "";
		// Add file io code here
		FileInputStream fileByteStream = null;
		Scanner inFS = null;
		try{
		    fileByteStream = new FileInputStream(filename);
		    inFS = new Scanner(fileByteStream);
		    header = inFS.nextLine();
		    while(inFS.hasNext()){
			current = inFS.nextLine();
			tempData.add(current.split(","));
		    }
		    inFS.close();
		}
		catch(IOException e){
		    System.err.println("Caught IOException: " + e.getMessage());
		}
		try{
		    fileByteStream.close();
		}
		catch(IOException e){
		    System.err.println("Caught IOException : " + e.getMessage());
		}
			
		
		String[][] data = tempData.toArray(new String[tempData.size()][]);
		return data;
	}
}
