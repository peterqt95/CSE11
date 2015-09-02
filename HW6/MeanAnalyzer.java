/***************************************************************
 * ID: A11163016
 * NAME: Peter Tran
 * LOGIN: cs11ehc
 *
 * Compilation:
 * About:
 ***************************************************************/
import java.util.ArrayList;
import java.awt.*;
import java.util.Scanner;

public class MeanAnalyzer extends StockAnalyzer {
    private int counter = 0;
    private int n = 0;
    private double total = 0;
    private ArrayList<Double> tempValues = new ArrayList<Double>();
    /**
     * Adds a stock tick to the stock analyzer. The analyzer assumes 
     * that the stock has the form:
     * <p>
     * date, open value, high value, low value, close value, volume, adj close
     * <p>
     * Stores the values of the high stock and calculates a 10 point moving average
     * of the high stock values.
     * @param tick a string array that represents a single stock tick
     */
    public void addStock(String[] tick){
	dates.add(tick[0]);
	//Stores 0 for the first 9 values since there aren't 10 values
	if(counter < 9){
	    values.add(0.0);
	    total += Double.valueOf(tick[2]);
	    tempValues.add(Double.valueOf(tick[2]));
	    counter++;
	}
	//Calculates 10 point moving average
	else if(counter >= 9){
	    tempValues.add(Double.valueOf(tick[2]));
	    total += Double.valueOf(tick[2]);
	    if(counter == 9){
		values.add(total/10);
	    }
	    else{
		total -= tempValues.get(n);
		values.add(total/10);
		n++;
	    }
	    counter++;
	}
	return;
    }
}