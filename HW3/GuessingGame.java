/*************************************************************************
 *  ID: A11163016 
 *  NAME: Peter Tran
 *  LOGIN: cs11ehc
 *
 *  Compilation:  javac GuessingGame.java
 *  Execution:    java GuessingGame
 *  About: This program picks a random number and then has the user guess
 *         it.
 *************************************************************************/
import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static final int NUM_GUESSES = 5;
    public static void main(String[] args) {
        int randNum = 0;
	int counter = 0;
	int guess = 0;
	int guessLeft = 0;
	Scanner scnr = new Scanner(System.in);
        Random generator = new Random(0);
	randNum = generator.nextInt(50) + 1; //creates integer between 1 and 50

	System.out.println("I'm thinking of a number between 1 and 50. " + 
			   "You have 5 guesses");
	while(counter < NUM_GUESSES){
	    guess = scnr.nextInt();
	    if(guess == randNum){
		System.out.println("Correct! Did you cheat?");
		break;
	    }
	    else if(guessLeft == 1){
		System.out.println("Sorry, you lose the game.");
		break;
	    }
	    else if(guess > randNum){
		counter++;
		guessLeft = NUM_GUESSES - counter;
		System.out.println("Sorry, that guess is too high. You have " +
				   guessLeft + " guesses left.");
	    }
	    else{
		counter++;
		guessLeft = NUM_GUESSES - counter;
		System.out.println("Sorry, that guess is too low. You have " + 
				   guessLeft + " guesses left.");
	    }
	}
        
        scnr.close();
        return;
    }
}