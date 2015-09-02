/*************************************************************************
 *  ID: A11163016 
 *  NAME: Peter Tran
 *  LOGIN: cs11ehc
 *
 *  Compilation:  javac FoodOrder.java
 *  Execution:    java FoodOrder
 *  About: This program prompts the user to buy a drink, dinner and desert.
 *************************************************************************/
import java.util.Scanner;

public class FoodOrder {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String name;
        int selection;
        float total_cost = 0;
	final double WATER_PRICE = 0.00;
	final double COKE_PRICE = 2.00;
	final double MILK_PRICE = 0.50;
	final double JUICE_PRICE = 0.99;
	final double HAMBURGER_PRICE = 5.50;
	final double STEAK_PRICE = 15.75;
	final double FISH_PRICE = 12.35;
	final double MAMMOTH_PRICE = 99.99;
	final double CHEESECAKE_PRICE = 8.90;
	final double ICE_CREAM_PRICE = 2.25;
	final double APPLE_PIE_PRICE = 4.60;
	final double COFFEE_PRICE = 1.25;
 
        //Grab the user's name.
        System.out.print("Enter your name: ");
        name = scnr.nextLine();
 
        // Get the user's drink order
        // write the drink menu here. Then use the scanner to take the
		// drink order from the user
	System.out.println("Hello, " + name + 
			   ". What would you like to drink?");
	System.out.println("1. Water - $0.00\n2. Coke  - $2.00"+
			   "\n3. Milk  - $0.50\n4. Juice - $0.99");
	selection = scnr.nextInt();
	
	switch(selection){
	case 1:
	    System.out.println("Water selected!");
	    total_cost += WATER_PRICE; 
	    break;
	case 2:
	    System.out.println("Coke slected!");
	    total_cost += COKE_PRICE;
	    break;
	case 3:
	    System.out.println("Milk selected!");
	    total_cost += MILK_PRICE;
	    break;
	case 4:
	    System.out.println("Juice selected!");
	    total_cost += JUICE_PRICE;
	    break;
        default :
	    System.out.println("Unknown drink selection. Nothing selected!");
      	    break;
	}
        
        // get user's dinner order
	// write the dinner menu+switch statement for the dinner order
	System.out.println("What would you like for dinner?");
	System.out.println("1. Hamburger - $5.50\n2. Steak     - $15.75\n"+ 
			   "3. Fish      - $12.35\n4. Mammoth   - $99.99");
        selection = scnr.nextInt();

	switch(selection){
	case 1:
	    System.out.println("Hamburger selected!");
	    total_cost += HAMBURGER_PRICE;
	    break;
	case 2:
	    System.out.println("Steak selected!");
	    total_cost += STEAK_PRICE;
	    break;
	case 3:
	    System.out.println("Fish selected!");
	    total_cost += FISH_PRICE;
	    break;
	case 4:
	    System.out.println("Mammoth selected!");
	    total_cost += MAMMOTH_PRICE;
	    break;
	default:
	    System.out.println("Unknown dinner selection. Nothing selected!");
	    break;
	}
        
        // get user's desert order
        // write the desert menu+switch statement for the desert order
	System.out.println("What would you like for dessert?");
	System.out.println("1. Cheesecake - $8.90\n2. Ice Cream  - $2.25\n" + 
			   "3. Apple Pie  - $4.60\n4. Coffee     - $1.25");
	selection = scnr.nextInt();
	
	switch(selection){
	case 1:
	    System.out.println("Cheesecake selected!");
	    total_cost += CHEESECAKE_PRICE;
	    break;
	case 2:
	    System.out.println("Ice Cream selected!");
	    total_cost += ICE_CREAM_PRICE;
	    break;
	case 3:
	    System.out.println("Apple Pie selected!");
	    total_cost += APPLE_PIE_PRICE;
	    break;
	case 4:
	    System.out.println("Coffee selected!");
	    total_cost += COFFEE_PRICE;
	    break;
	default:
	    System.out.println("Unknown desert selction. Nothing selected!");
	    break;
	}
		
        //Print the name and meal cost back to the user.
	System.out.printf(name + ", your order costs: $%.2f\n",total_cost);
        
        scnr.close();
        return;
    }
}
