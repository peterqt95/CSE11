/*************************************************************************
 *  ID: A11163016
 *  NAME: Peter Tran
 *  LOGIN: cs11ehc
 *
 *  Compilation:  javac Driver.java
 *  Execution:    java Driver
 *  Requires: 
 *  About:  runs the stock analysis code
 *************************************************************************/
import java.io.IOException;

public class Driver {
    
    public static void main(String[] args) throws IOException {

		// create the stock tools
		String filename = "googlestocks.csv";
		CSVParser parser = new CSVParser();
		StockOracle stocks = new StockOracle(parser.parse(filename));

		StockAnalyzer highStocks = new HighTickAnalyzer();
		StockAnalyzer lowStocks = new LowTickAnalyzer();
		StockAnalyzer meanStocks = new MeanAnalyzer();

		String[] tick;
		while( (tick = stocks.getNextTick()) != null) {
			highStocks.addStock(tick);
			lowStocks.addStock(tick);
			meanStocks.addStock(tick);
		}

		highStocks.writeJSON("highStocks.json");
		lowStocks.writeJSON("lowstocks.json");
		meanStocks.writeJSON("meanStocks.json");

		return;
    } 
}
