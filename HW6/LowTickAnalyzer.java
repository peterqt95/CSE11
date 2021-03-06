/********************************************************************
 * ID: A11163016
 * NAME: Peter Tran
 * LOGIN: cs11ehc
 *
 * Compilation:
 * About:
 *******************************************************************/
import java.awt.*; 
import java.util.Scanner;

public class LowTickAnalyzer extends StockAnalyzer { 
    /**
     * Adds a stock tick to the stock analyzer. The analyzer assumes
     * that the stock tick has the form and adds the low value:
     * <p>
     * date, open value, high value, low value, close value, volume, adj close
     * <p>
     * @param tick is a string array that represents a single stock tick
     *
     */
    public void addStock(String[] tick) {
	dates.add(tick[0]);
	values.add(Double.valueOf(tick[3]));
	
	return;
    }
}