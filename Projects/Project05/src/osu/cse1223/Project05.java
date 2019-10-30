/*
 * Project05.java
 * This program asks the user to guess a number between 0 and 100. The program asks the user to guess until
 * the user has guessed the correct number. 
 * 
 * 
 * 
 * @author Harshil Patel
 * @version 20180212
 */


package osu.cse1223;
import java.util.Scanner;
public class Project05 {

	public static void main(String[] args) {
		int computerGuess =  (int)(200 * Math.random()) + 1;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a guess between 1 and 200: ");
		String userinput = in.nextLine();
		int userGuess=Integer.parseInt(userinput);
		int userGuessCount=1;
		while (userGuess!=computerGuess) {
			if (userGuess<0 || userGuess>200) {
				System.out.println("Your guess is out of range.  Pick a number between 1 and 200.\n");
				userGuessCount++;
				}
		    else if (userGuess<computerGuess)
				{System.out.println("Your guess was too low. Try again.\n");
				userGuessCount++;
				}
			else {
				System.out.println("Your guess was too high. Try again.\n");
				userGuessCount++;
				}
			System.out.print("Enter a guess between 1 and 200: ");
			userinput = in.nextLine();
			userGuess=Integer.parseInt(userinput);
			}
		if (userGuess==computerGuess) {
			System.out.println("Congratulations!  Your guess was correct!\n");
		}
		System.out.println("I had chosen "+computerGuess+" as the target number.");
		System.out.println("You guessed it in "+userGuessCount+" tries.");
		if (userGuessCount>10) {
			System.out.println("This just isn't your game, is it?");
		}
		else if (userGuessCount>=8) {
			System.out.println("Are you sure this is the right game for you?");
		}
		else if (userGuessCount==7) {
			System.out.println("That was not that impressive.");
		}
		else if (userGuessCount>=5) {
			System.out.println("That was pretty good.");
		}
		else if (userGuessCount>=2) {
			System.out.println("That was not that impressive.");
		}
		else {
			System.out.println("That was astounding!");
		}
	
}}



	
