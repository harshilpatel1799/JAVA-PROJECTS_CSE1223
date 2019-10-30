/*
 * Project06.java
 * This program prompts user to input a 16 digit credit card number. Then the program 
 * validates the number by finding the Credit Card check digit and checks to see if it matches the last digit of 
 * user's number. Lastly, telling the user if the number inputed is a valid 
 * credit card number.
 * 
 * @author Harshil Patel
 * @version 20180219
 */



package osu.cse1223;
import java.util.Scanner;
public class Project06 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a credit card number (enter a blank line to quit): ");
		String creditNumber=in.nextLine();
		boolean userInputCheck=userInputChecker(creditNumber);
		
		while (!creditNumber.isEmpty()) {
			
			if (userInputCheck==true) {
				int valid=creditCheck(creditNumber);
				String inputCheckDigit=creditNumber.substring(creditNumber.length()-1, creditNumber.length());
				int userCheckDigit=Integer.parseInt(inputCheckDigit);
				System.out.println("Check digit should be: "+ valid );
				System.out.println("Check digit is: "+userCheckDigit);
				if (valid==userCheckDigit) {
					System.out.println("Number is valid\n" );
				}
				else {System.out.println("Number is not valid\n" );}
			}

			else  {
				System.out.println("ERROR! Number MUST have exactly 16 digit\n");
			}
			System.out.print("Enter a credit card number (enter a blank line to quit): ");
			creditNumber=in.nextLine();
			userInputCheck=userInputChecker(creditNumber);
			}
		
		System.out.println("Goodbye!");
		
		}
	
	
	/** 
	 * input String as the credit card number.
	 * Uses The Luhn Algorithm to calculate the credit card check digit.
	 * 
	 * @return The check digit from user credit card number input.
	 */
	public static int creditCheck(String creditValue)
    {
	
        // BELOW THE THE EVEN POSTION VALUES ARE ADDED
	        int counterEven=0;
	        int sumEven=0;
	        while (counterEven<=14) {
	        	char positionEven=creditValue.charAt(counterEven);
	        	int evenValues=Character.getNumericValue(positionEven);
	        	evenValues=2*evenValues;
	        	if ((evenValues)>=10) {
		        	String newValue=Integer.toString(evenValues);
		        	String pos1=newValue.substring(0,1);
		        	String pos2=newValue.substring(1,2);
		        	int int1=Integer.parseInt(pos1);
		        	int int2=Integer.parseInt(pos2);
		        	evenValues=int1+int2;
		        }
	        	sumEven=sumEven+evenValues;
	        	counterEven=counterEven+2;
	        	
	        }
	       
	        
	        // BELOW THE THE ODD POSTION VALUES ARE ADDED
	        int counter=1;
	        int sumOdd=0;
	        while (counter<=13) {
	        	char positionOdd=creditValue.charAt(counter);
	        	int oddValues=Character.getNumericValue(positionOdd);
	        	sumOdd=sumOdd+oddValues;
	        	counter=counter+2;
	        }
	        
	        //Returns the Check Digit
	        int output;
	        int sum=sumEven+sumOdd;
	        String checkValueString=Integer.toString(sum);
	        int length=checkValueString.length();
	        int starter=length-1;
	        String checkValueString2=checkValueString.substring(starter,length);
	        int checkValue=Integer.parseInt(checkValueString2);
	        if (checkValue>0) {
	        	output=10-checkValue;
	        	
	        }
	        else {output=0;}
        	return output;
    }
	
	
	/** 
	 * input String as the credit card number.
	 * The method validates the user's credit card number input as 16 digits and all numbers.
	 * 
	 * @return boolean true if user's credit card number input as 16 digits and all numbers.
	 */
	public static boolean userInputChecker(String creditValue){

		if ((creditValue.length()==16)){    
		int counter=0;
		while(counter<16){  // loop to determine if input is all numbers.
		char x=creditValue.charAt(counter);
		if (Character.isDigit(x)){
		counter++;}
		else{
		return false;}
		}
		return true;
		}
		else
		{return false;}


		}
   


























}
