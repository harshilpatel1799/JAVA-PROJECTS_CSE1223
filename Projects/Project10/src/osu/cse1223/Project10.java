/*
 * Project10.java
 * 
 *   A program that plays and scores a round of the game Poker Dice.  In this game,
 *   five dice are rolled.  The player is allowed to select a number of those five dice
 *   to re-roll.  The dice are re-rolled and then scored as if they were a poker hand.  
 *   The following hands MUST be scored in this assignment:
 *   	* High card
 *   	* One Pair
 *   	* Two Pair
 *   	* Three of a Kind
 *   	* Full House
 *   	* Four of a Kind
 *   	* Five of a Kind
 *   For extra credit, you may also implement:
 *   	* Straight
 * My code scores a Straight as well as the other hands.==EXTRA CREDIT
 * @author HARSHIL PATEL
 * @version 20180326
 * 
 */
package osu.cse1223;
import java.util.Arrays;
import java.util.Scanner;


public class Project10 {

	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		boolean playGame=true;
		while(playGame) {
		int dice[]=new int[5];
		resetDice(dice);
		rollDice(dice);
		System.out.println("Your current dice:"+diceToString(dice));
		promptForReroll(dice,inScanner);
		diceReRoll(dice);
		System.out.println("Your final dice:"+diceToString(dice));
		System.out.println(getResult(dice));
		playGame=promptForPlayAgain(inScanner);
		System.out.println();
		}
		System.out.println("Goodbye!");
	}
	
	// Given an array of integers as input, sets every element of the array to zero.
	private static void resetDice(int[] dice) {
		for(int i=0;i<dice.length;i++) {dice[i]=0;}}
	
	// Given an array of integers as input, checks each element of the array.  If the value
	// of that element is zero, generate a number between 1 and 10 and replace the zero with
	// it.  Otherwise, leave it as is and move to the next element.
	private static void rollDice(int[] dice) {
		for(int i=0;i<dice.length;i++) {if(dice[i]==0) {dice[i]=(int)(Math.random()*10)+1;}}}
	
	// Given an array of integers as input, create a formatted String that contains the
	// values in the array in the order they appear in the array.  For example, if the 
	// array contains the values [0, 3, 7, 5, 2] then the String returned by this method
	// should be "0 3 7 5 2".
	private static String diceToString(int[] dice) {
		String diceString="";
		for(int i=0;i<dice.length;i++) {diceString=diceString+" "+dice[i];}
		return diceString;}
	
	// Given an array of integers and a Scanner as input, prompt the user with a message
	// to indicate which dice should be re-rolled.  If the user enters a valid index (between
	// 0 and the total number of dice -1) then set the die at that index to zero.  If the 
	// user enters a -1, end the loop and return to the calling program.  If the user enters
	// any other invalid index, provide an error message and ask again for a valid index.
	public static void promptForReroll(int[] dice, Scanner inScanner) {
		System.out.print("Select a die to re-roll (-1 to keep remaining dice): ");
		int reRollIndex=inScanner.nextInt();
		while (reRollIndex!=-1) {
			while (reRollIndex<-1 || reRollIndex>=5 ) {
				System.out.println("Error: Index must be between 0 and 4 (-1 to quit)!");
				System.out.print("Select a die to re-roll (-1 to keep remaining dice): ");
				reRollIndex=inScanner.nextInt();
			}
			if(reRollIndex>-1&&reRollIndex<5) {
		dice[reRollIndex]=0;
		System.out.println("Your current dice:"+diceToString(dice));
		System.out.print("Select a die to re-roll (-1 to keep remaining dice): ");
		reRollIndex=inScanner.nextInt();}
		}
		//if () {
		System.out.println("Keeping remaining dice...\nRerolling...");}
	
	// Given the user's "hand", the method re-rolls the dice that the user indicates, which are set to
	//	value '0'. It returns to the calling program a new "hand" for the user to play the game with.
	private static void diceReRoll(int[] dice) {
		for(int i=0;i<dice.length;i++) {
			if (dice[i]==0) {dice[i]=(int)(Math.random()*10)+1;}
		}}
	
	// Given a user's hand, this method sorts the array from
	// least to greatest.
	private static void diceSort(int[] dice) {
		Arrays.sort(dice);}
	
	// Given a Scanner as input, prompt the user to play again.  The only valid entries
	// from the user are 'Y' or 'N', in either upper or lower case.  If the user enters
	// a 'Y' the method should return a value of true to the calling program.  If the user
	// enters a 'N' the method should return a value of false.  If the user enters anything
	// other than Y or N (including an empty line), an error message should be displayed
	// and the user should be prompted again until a valid response is received.
	private static boolean promptForPlayAgain(Scanner inScanner) {
		System.out.print("Would you like to play again [Y/N]?: ");
		inScanner.nextLine();
		String input = inScanner.nextLine(); 
		char userInput=input.charAt(0);
		while((userInput != 'Y' && userInput != 'y' && userInput != 'N' && userInput != 'n') || input.length()!=1 ) {
			System.out.println("ERROR! Only 'Y' or 'N' allowed as input!");
			System.out.print("Would you like to play again [Y/N]?: ");
			input = inScanner.nextLine();
			userInput=input.charAt(0);
		}
		if(userInput == 'y' || userInput == 'Y') {return true;}
		else {return false;}
	}
	
	// This method returns the max value of an
	// array of integers.
	private static int maxValue (int[]dice) {
		int max=dice[0];
		for (int i=0;i<dice.length;i++) {
			int x=dice[i]; if(x>max) {max=x;}}
		return max;
	}
	
	// Given an array of integers, determines the result as a hand of Poker Dice.  The
	// result is determined as:
	//	* Five of a kind - all five integers in the array have the same value
	//	* Four of a kind - four of the five integers in the array have the same value
	//	* Full House - three integers in the array have the same value, and the remaining two
	//					integers have the same value as well (Three of a kind and a pair)
	//	* Three of a kind - three integers in the array have the same value
	//	* Two pair - two integers in the array have the same value, and two other integers
	//					in the array have the same value
	//	* One pair - two integers in the array have the same value
	//	* Highest value - if none of the above hold true, the Highest Value in the array
	//						is used to determine the result
	//
	//	The method should evaluate the array and return back to the calling program a String
	//  containing the score from the array of dice.
	//
	//  EXTRA CREDIT: Include in your scoring a Straight, which is 5 numbers in sequence
	//		[1,2,3,4,5] or [2,3,4,5,6] or [3,4,5,6,7] etc..
	private static String getResult(int[] dice) {
		String output="";
		int testValue=1;
		int[] countArray=getCounts(dice);
		for (int i=0;i<countArray.length;i++) {
			if(countArray[i]==5) {testValue=testValue*5;}
			else if(countArray[i]==5) {testValue=testValue*5;}
			else if(countArray[i]==4) {testValue=testValue*4;}
			else if(countArray[i]==3) {testValue=(testValue*3)+10;}
			else if(countArray[i]==2) {testValue=(testValue*2)+5;}
			else if(countArray[i]==1) {testValue=testValue*1;}
		}
		if (testValue==5) {return output="Five of a kind!";}
		else if (testValue==4) {return output="Four of a kind!";}
		else if (testValue==31) {return output="Full House!";}
		else if (testValue==13) {return output="3 of a Kind!";}
		else if (testValue==19) {return output="Two pair!";}
		else if (testValue==7) {return output="One Pair!";}
		else if (testValue==1) {
			if (straightTester(dice)==true) {return output="Straight!";}
			else {return output="Highest card "+maxValue(dice)+"!";}
			}
		return output;
	}
	
	// Given an array of integers as input, return back an array with the counts of the
	// individual values in it.  You may assume that all elements in the array will have 
	// a value between 1 and 10.  For example, if the array passed into the method were:
	//   [1, 2, 3, 3, 7]
	// Then the array of counts returned back by this method would be:
	// [1, 1, 2, 0, 0, 0, 1, 0, 0, 0]
	// (Where index 0 holds the counts of the value 1, index 1 holds the counts of the value
	//  2, index 2 holds the counts of the value 3, etc.)
	// HINT:  This method is very useful for determining the score of a particular hand
	//  of poker dice.  Use it as a helper method for the getResult() method above.
	private static int[] getCounts(int[] dice) {
		int[] counterOfEachDiceValue= {0,0,0,0,0,0,0,0,0,0};
		for(int i=0;i<dice.length;i++) {
			if(dice[i]==1) {counterOfEachDiceValue[0]++;}
			else if(dice[i]==2) {counterOfEachDiceValue[1]++;}
			else if(dice[i]==3) {counterOfEachDiceValue[2]++;}
			else if(dice[i]==4) {counterOfEachDiceValue[3]++;}
			else if(dice[i]==5) {counterOfEachDiceValue[4]++;}
			else if(dice[i]==6) {counterOfEachDiceValue[5]++;}
			else if(dice[i]==7) {counterOfEachDiceValue[6]++;}
			else if(dice[i]==8) {counterOfEachDiceValue[7]++;}
			else if(dice[i]==9) {counterOfEachDiceValue[8]++;}
			else if(dice[i]==10) {counterOfEachDiceValue[9]++;}	
		}
		return counterOfEachDiceValue;	
	}
	
	// Given a player's hand, this method tests if the hand is  
	// a straight or not, meaning it is consecutive in value.
	// This method returns true if it is, false if not.
	private static boolean straightTester(int[] dice) {
		boolean test;
		for(int i=0;i<dice.length-1;i++) {
			int x=dice[i];
			if(x==10) {x=0;}
			if(x+1==dice[i+1]) {test=true;}
			else {return test=false;}
		}
		return test=true;
		
	}
	
	


}