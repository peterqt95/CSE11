/*************************************************************************
 *  ID: A11163016 
 *  NAME: Peter Tran
 *  LOGIN: cs11ehc
 *
 *  Compilation:  
 *  About:  
 *************************************************************************/
import java.awt.*;
import java.util.Scanner;

public class StockOracle {	
    private String[][] ticks;
    private int counter = -1;
	/**
	 * Stores the 
	 * <p>
	 * @param inputTicks expects an array of an array of Strings
	 */
	public StockOracle(String[][] inputTicks) {
	    ticks = inputTicks;
	}


	/**
	 * Returns the next stock tick. This function returns null if
	 * there are no more stock ticks available.
	 * <p>
	 * @return String[] a string array of stock information.
	 *
	 */
	public String[] getNextTick() {
	    counter++;
	    if(counter == ticks.length){
		return null;
	    }
	    else{
		return ticks[counter];
	    }
	}
}
