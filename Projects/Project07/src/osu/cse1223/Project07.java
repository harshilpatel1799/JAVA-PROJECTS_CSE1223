/*
 * Project07.java
 * 
 *   A program that plays the dice game high/low
 *   Used to practice breaking code up into methods. 
 * 
 * @author Harshil Patel
 * @version 20180226
 * 
 */
package osu.cse1223;
import java.util.Scanner;


public class Project07 {


	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		int totalMoney=100;
		int betAmount=getBet(inScanner,totalMoney);
		while ((totalMoney>0)&&(!(betAmount==0))){
		char betType=getHighLow(inScanner);
		int rollOne=getRoll();
		System.out.println("Die 1 rolls: "+rollOne);
		int rollTwo=getRoll();
		System.out.println("Die 2 rolls: "+rollTwo);
		int rollTotal=rollOne+rollTwo;
		System.out.println("Total of two dice is: "+rollTotal);
		int winnings=determineWinnings(betType, betAmount,rollTotal);
		if (winnings<0) {
			System.out.println("You lost!");
		}
		else {System.out.println("You won "+winnings+" dollars!");}
		totalMoney=totalMoney+winnings;
		System.out.println();
		if (totalMoney>0) {
		betAmount=getBet(inScanner,totalMoney);
		rollOne=getRoll();
		rollTwo=getRoll();}
		}
		System.out.println("\nYou have "+ totalMoney +" dollars left\nGoodbye!");
		
	}
	
	
	// Given a Scanner and a current maximum amount of money, prompt the user for
	// an integer representing the number of dollars that they want to bet.  This
	// number must be between 0 and to maximum number of dollars.  If the user enters
	// a number that is out of bounds, display an error message and ask again.
	// Return the bet to the calling program.
	public static int getBet(Scanner inScanner, int currentPool) {
		System.out.println("You have "+currentPool+" dollars.");
		System.out.print("Enter an amount to bet (0 to quit): ");
		String inputString=inScanner.nextLine();
		int betAmount=Integer.parseInt(inputString);
		
		while(!(betAmount>=0&&betAmount<=currentPool)) {
			System.out.println("ERROR, INVALID BET AMOUNT, MUST BE BETWEEN $0-$100.\n");
			System.out.print("Enter an amount to bet (0 to quit): ");
			inputString=inScanner.nextLine();
			betAmount=Integer.parseInt(inputString);
		}
		return betAmount;
	}
	
	// Given a Scanner, prompt the user for a single character indicating whether they
	// would like to bet High ('H'), Low ('L') or Sevens ('S').  Your code should accept
	// either capital or lowercase answers, but should display an error if the user attempts
	// to enter anything but one of these 3 values and prompt for a valid answer.
	// Return the character to the calling program.
	public static char getHighLow(Scanner inScanner) {
		System.out.print("High, low or sevens (H/L/S): ");
		String betTypeInput=inScanner.nextLine();
		char betType=betTypeInput.charAt(0);
		betType= Character.toUpperCase(betType);
		while (!(betType=='H'||betType=='L'||betType=='S')) {
			System.out.println("ERROR, INVALID BET TYPE\n");	
			System.out.print("High, low or sevens (H/L/S): ");
			betTypeInput=inScanner.nextLine();
			betType=betTypeInput.charAt(0);
			betType= Character.toUpperCase(betType);
		}
		return betType;
	}
	
	// Produce a random roll of a single six-sided die and return that value to the calling
	// program
	public static int getRoll() {
		int randomValue =  (int)(6 * Math.random()) + 1;
		return randomValue;
	}
	
	// Given the choice of high, low or sevens, the player's bet and the total result of
	// the roll of the dice, determine how much the player has won.  If the player loses
	// the bet then winnings should be negative.  If the player wins, the winnings should
	// be equal to the bet if the choice is High or Low and 4 times the bet if the choice
	// was Sevens.  Return the winnings to the calling program.
	public static int determineWinnings(char highLow, int bet, int roll) {
		if (highLow=='H') {
			if (roll==7) {
				bet=-bet;}
			if (roll<7) {
				bet=-bet;}	
		}
		else if (highLow=='L') {
			if (roll>7) {
				bet=-bet;}
			if (roll==7) {
				bet=-bet;}
		}
		else if (highLow=='S') {
			if (roll>7) {
				bet=-bet;
				}
			if (roll==7) {
				bet=4*bet;}
			if (roll<7) {
				bet=-bet;}
			
		}
		return bet;
	}

	
	
	
	
	
	
	
	
	
}