/*************************************************************************
 *  ID: A11163016 
 *  NAME: Peter Tran
 *  LOGIN: cs11ehc
 *
 *  Compilation:  javac Debug.java
 *  Execution:    java Debug
 *  About: This program prompts the user to enter their name, and
 *         then echos the name back to the user. 
 *************************************************************************/
import java.util.Scanner; //import java.util.Scanner

public class Debug {
    public static void main(String[] args) {
	Scanner scnr = new Scanner(System.in); //Scanner scnr = new Scanner();
	String name; //string name;
	
	//Grab the user's name. We only care about their first name
	//System.out.print('Enter your name: ');
	System.out.print("Enter your name: ");
	
	//name = scnr.next;
	name=scnr.next();

	//Print the name back to the user
	//System.out.println("Your name is: " name);
	System.out.println("Your name is: " + name);
	return;
    }
}