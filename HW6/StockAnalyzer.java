/*************************************************************************
 *  ID: A11163016 
 *  NAME: Peter Tran
 *  LOGIN: cs11ehc
 *
 *  Compilation:  
 *  About:  
 *************************************************************************/
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class StockAnalyzer {
	protected ArrayList<String> dates;
	protected ArrayList<Double> values;

	public StockAnalyzer() {
		dates = new ArrayList<String>();
		values = new ArrayList<Double>();
	}

    public abstract void addStock(String[] tick);

    /**
     * Writes the JSON file that has the stock dates and values for each 
     * respective filename.
     *
     * @param filename a json file that represents the current stock calculation
     */
    public void writeJSON(String filename) throws IOException {
	    // Add json writing code here
	    PrintWriter pw = new PrintWriter(filename);
	    double round = 0;
	    pw.print("{\n\t\"labels\": [");
	    //Prints the dates
	    for(int i = 0; i < dates.size(); i++){
		if(i == dates.size()-1){
		    pw.print("\""+dates.get(i)+"\"");
		}
		else{
		    pw.print("\""+dates.get(i)+"\",");
		}
	    }
	    pw.print("],\n\t\"datasets\": [\n\t\t{\n\t\t\t\"data\": [");
	    //Prints the values
	    for(int i = 0; i <values.size(); i++){
		if(i == values.size()-1){
		    round = Math.floor(values.get(i)*100)/100;
		    pw.print(round);
		}
		else{
		    round = Math.floor(values.get(i)*100)/100;
		    pw.printf(round + ",");
		}
	    }
	    pw.print("]\n\t\t}\n\t]\n}");

	    
	    pw.close();
		return;
	}
}
