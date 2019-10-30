/**
 * Project09.java
 *
 *   A program that converts binary numbers into decimal numbers.
 *   Used to practice breaking code up into methods.
 *
 *   @author Harshil
 *   @version 20180319
 */
package osu.cse1223;
import java.util.Scanner;

public class Project09 {

    public static void main(String[] args) {
    	Scanner in=new Scanner(System.in);
    	System.out.println("Converting from Decimal to Binary");
    	String input=promptForBinary(in);
    	while(!(input.equals(""))) {
        	int output=binaryToDecimal(input);
        	System.out.println("The binary value "+input+" is "+output+" in decimal (base 10)\n");
        	input=promptForBinary(in);
        	}
    	System.out.println("Goodbye");
    }

    /**
     * Given a Scanner as input, prompt the user to enter a binary value. Use
     * the function checkForBinaryValue below to make sure that the value
     * entered is actually a binary value and not junk. Then return the value
     * entered by the user as an String to the calling method.
     *
     * @param input
     *            A scanner to take user input from
     * @return a String representing a binary value read from the user
     */
    public static String promptForBinary(Scanner input) {
    	System.out.print("Enter a binary value (empty line to quit): ");
        String userInput = input.nextLine();
        while (!checkForBinaryValue(userInput)) {
            System.out.println("ERROR - invalid binary value\n");
            System.out.print("Enter a binary value (empty line to quit): ");
            userInput = input.nextLine();
        }
        return userInput;
    }
    

    /**
     * Given a String as input, return true if the String represents a valid
     * binary value (i.e. contains only the digits 1 and 0). Returns false if
     * the String does not represent a binary value.
     *
     * @param value
     *            A String value that may contain a binary value
     * @return true if the String value contains a binary value, false otherwise
     */
    public static boolean checkForBinaryValue(String value) {
    	int counter=0;
        while(counter<value.length()) {
        	char x=value.charAt(counter);
        	int y = Character.getNumericValue(x);
        	if(y==0 || y==1) {
        		counter++;
        	}
        	else {return false;};
        }
        return true;
    }

    /**
     * Given a binary value, return an int value that is the base 10
     * representation of that value. Your implementation must use the algorithm
     * described in the Project 9 write-up. Other algorithms will receive no
     * credit.
     *
     * @param value
     *            A String containing a binary value to convert to integer
     * @return The base 10 integer value of that binary in the String
     */
    public static int binaryToDecimal(String value) {
    	int result=0;
    	int counter1=0;
    	int counter2=value.length()-1;
        while(counter1<value.length()) {
        	char x=value.charAt(counter1);
        	int y = (int) ((Character.getNumericValue(x))*(Math.pow(2,counter2)));
        	result = result + y;
        	counter2--;
        	counter1++;
        	
        }
        return result;
    }
    
}