/******************************************************************
 *ID: A11163016
 *Name: Peter Tran
 *Login: cs11ehc
 *
 *Description: Take in user's name, height and weight and calculate
 *user's BMI.
 ******************************************************************/
import java.util.Scanner;

public class BMI{
    public static void main (String[] args){
	Scanner scnr = new Scanner(System.in);
	String name;
	int feet = 0;
	int inches = 0;
	double pounds = 0.0;
	double BMI = 0.0;
	final int FEET_TO_INCHES = 12;
	final double INCHES_TO_METERS = 0.0254;
	final double POUNDS_TO_KG = 0.4535;

	System.out.print("Enter the user's name: ");
	name = scnr.nextLine();

	System.out.print("Enter the user's height in feet: ");
	feet = scnr.nextInt();

	System.out.print("Enter the user's height in inches: ");
	inches = scnr.nextInt();

	System.out.print("Enter the user's weight in pounds: ");
	pounds = scnr.nextDouble();
	
	BMI = pounds*POUNDS_TO_KG/Math.pow(( (feet*FEET_TO_INCHES+inches)*
					    INCHES_TO_METERS), 2);  
	System.out.printf("\n%s's BMI is %.2f\n", name, BMI);
    }
}
