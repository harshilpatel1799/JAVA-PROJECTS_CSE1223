/*
 * Project02.java
 * This program asks the user to input a string and a substring within the former string. The program
 * outputs various operations using the string and substring. Lastly, replacing the substring within the 
 * original string with a replacement string
 * 
 * @author Harshil S. Patel
 * @version 20180121
 * 
 * EXTRA CREDIT
 * The behavior of the code when the user inputs a substring that is not within the original string,
 * is that the code experiences a runtime error. This is due Line 41, where the program tries to determine 
 * the starting position of the substring in the original string , but cannot due so as the substring is not 
 * located within the original string; therefore, outputs the integer "-1" for the index.
 * 
 * Line 41 causes this error. To fix this problem, an if-else statement needs to be present so if the user 
 * enters a substring that is not within the original string, the index would "-1", then the program would 
 * output an error message. Else the program would find the position of the substring within the original 
 * string and continue with the program.
 * 
 */



package osu.cse1223;

import java.util.Scanner;


public class Project02 {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a long string: ");
		String stringUserInput = keyboard.nextLine();
		System.out.print("Enter a substring: ");
		String substringUserInput = keyboard.nextLine();
		System.out.println("Length of your string: " + stringUserInput.length());
		System.out.println("Length of your substring: " + substringUserInput.length());
		//System.out.println("Starting position of your substring in string: " + stringUserInput.indexOf(substringUserInput));
		String beforehandString = stringUserInput.substring(0,stringUserInput.indexOf(substringUserInput));
		String afterhandString = stringUserInput.substring(stringUserInput.indexOf(substringUserInput) + substringUserInput.length(),stringUserInput.length());
		System.out.println("String before your substring: " + beforehandString);
		System.out.println("String after your substring: " + afterhandString);
		System.out.print("Enter a position between 0 and " + (stringUserInput.length()-1) + ": ");
		int positionStringValue = keyboard.nextInt();
		System.out.println("The character at position "+ positionStringValue +" is " + stringUserInput.charAt(positionStringValue));
		System.out.print("Enter a replacement string: ");
		String emptyLine = keyboard.nextLine();
		String replacementString = keyboard.nextLine();
		System.out.println("Your new string is: " + beforehandString + replacementString + afterhandString );
		
		

	}

}
