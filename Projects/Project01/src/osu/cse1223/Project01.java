/*
 * Project01.java
 * This program uses two user inputed numbers and conducts basic arithmetic 
 * operations using the two numbers. The the value of the arithmetic operations
 * is displayed.
 * 
 * 
 * @author Harshil S. Patel
 * @version 20180113
 */



package osu.cse1223;

import java.util.Scanner;

public class Project01 {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		int number1 = keyboard.nextInt();
		System.out.print("Enter the second number: ");
		int number2 = keyboard.nextInt();
		int sumNumber = (number1 + number2);
		int diffrenceNumber = (number1 - number2);
		int productNumber = (number1 * number2);
		int divisionNumber = (number1 / number2);
		int remainderNumber = (number1 % number2);
		int avgValueNumber = (sumNumber/2);
	    System.out.println(number1 + " + " + number2 + " = " + sumNumber);
		System.out.println(number1 + " - " + number2 + " = " + diffrenceNumber);
		System.out.println(number1 + " * " + number2 + " = " + productNumber);
		System.out.println(number1 + " / " + number2 + " = " + divisionNumber);
		System.out.println(number1 + " % " + number2 + " = " + remainderNumber);
		System.out.println("The average of your two numbers is: " + avgValueNumber);
			
	}
}
