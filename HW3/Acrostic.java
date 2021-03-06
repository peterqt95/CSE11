/*************************************************************************
  *  ID: A11163016 
  *  NAME: Peter Tran
  *  LOGIN: cs11ehc
  *
  *  Compilation:  javac Acrostic.java
  *  Execution:    java Acrostic
  *  About: This program prompts the user to enter a code string. This
  *         program will decrypt it and print out the reformatted message
  *         and code.
  *************************************************************************/
import java.util.Scanner;
public class Acrostic {
    public static void main(String[] args) {
        String code,subCode,strDecode="";
	char i,j;
	int codeIndex = 0,totalStr = 0, strLength = 0, iteration = 0;
	int codeLength;
	Scanner scanner = new Scanner(System.in);

		// Start the code breaking here!
        System.out.println("What is the code string?");
	code = scanner.nextLine();
	codeLength = code.length();
	while(codeLength > 0){
	    //reads in the 1st digit as the length of the substring
	    //then reads 2nd digit for the index of the encrypted code
	    i = code.charAt(2*iteration+totalStr);
	    j = code.charAt(2*iteration+totalStr+1);
	    strLength = i -'0'; 
	    codeIndex = j - '0';
	    //prints out substring
	    subCode = code.substring(2*iteration+totalStr+2,2*iteration+
				     totalStr+strLength+2);
	    System.out.println(subCode);
	    //adds the specific character of the substring to the final
	    //decoded message
	    strDecode += subCode.charAt(codeIndex);
	    //shifts the code to read the next substring
	    totalStr += strLength;
	    codeLength-=strLength+2;
	    iteration+=1;
	}
	System.out.println("Code: " + strDecode);
	
        return;
    }
}