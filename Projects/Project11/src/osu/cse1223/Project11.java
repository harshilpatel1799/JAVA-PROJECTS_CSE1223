/*
 * Project11.java
 * 
 *   A program that plays simple word guessing game.  In this game the user provides a list of 
 *   words to the program.  The program randomly selects one of the words to be guessed from 
 *   this list.  The player then guesses letters in an attempt to figure out what the hidden 
 *   word might be.  The number of guesses that the user takes are tracked and reported at the 
 *   end of the game.
 *   
 *   See the write-up for Project 11 for more details.
 * 
 * @author Harshil Patel
 * @version 20180403
 * 
 */
package osu.cse1223;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Project11 {

	
	public static void main(String[] args)  {
		Scanner in=new Scanner(System.in);
		System.out.print("Enter a filename containing your wordlist: "); 
		String fileName=in.nextLine();
		try 
		{
			boolean playGame=true;
			while (playGame==true) {
			File file=new File(fileName);
			Scanner inputFile=new Scanner(file);
			ArrayList<String> words=getList(inputFile);	
			System.out.println("Read "+ words.size() +" words from the file\n");
			String wordToGuess=getRandomWord(words).toUpperCase();
			String stars=stringToStars(wordToGuess);
			System.out.println("The word to guess is: "+stars);
			String previouslyGuessed="";
			System.out.print("Previous characters guessed: "+previouslyGuessed+"\n");
			char x=getCharacterGuess(in);
			while (prevousCharInputChecker(x, previouslyGuessed)==false) {
				System.out.println("You've already guessed "+ x +" try another character\n"); 
				System.out.println("The word to guess is now: "+stars);
				System.out.print("Previous characters guessed: "+previouslyGuessed+"\n");
				x=getCharacterGuess(in);
			}
			previouslyGuessed=previouslyGuessed+x;
			System.out.println("The character "+ x +" occurs in "+ checkChar(x, wordToGuess) +" positions");
			//System.out.println(x+" "+wordToGuess);
			System.out.println();
			stars=modifyGuess(x,wordToGuess,stars);
			System.out.println("The word to guess is now: "+stars);
			int guessCounter=0;
			String result=didUserGuessRight(in,wordToGuess);
			guessCounter++;
			System.out.println(result);
			char y=result.charAt(0);
			while(y=='Y'||y=='T') {
				System.out.println("The word to guess is now: "+stars);
				System.out.print("Previous characters guessed: "+previouslyGuessed+"\n");
				x=getCharacterGuess(in);
				while (prevousCharInputChecker(x, previouslyGuessed)==false) {
					System.out.println("You've already guessed "+ x +" try another character\n"); 
					System.out.println("The word to guess is now: "+stars);
					System.out.print("Previous characters guessed: "+previouslyGuessed+"\n");
					x=getCharacterGuess(in);
					}
					previouslyGuessed=previouslyGuessed+", "+x;
					System.out.println("The character "+ x +" occurs in "+ checkChar(x, wordToGuess) +" positions");
				System.out.println();
				stars=modifyGuess(x,wordToGuess,stars);
				System.out.println("The word to guess is now: "+stars);
				result=didUserGuessRight(in,wordToGuess);
				guessCounter++;
				System.out.print(result);
				y=result.charAt(0);
				System.out.println();
			}
			System.out.println("\nYou achieved the correct answer in "+ guessCounter +" guesses!");
			playGame=promptForPlayAgain(in);
			System.out.println();
			}
			System.out.println("Thanks for playing!  Goodbye!");
		}
		catch(IOException e) 
		{
			System.out.println("I'm sorry, I'm having trouble reading the file "+ fileName);
			System.out.println("\nGoodbye!");
		}		
	}

	// This method returns false if a given char is not within the a 
	// given string, returns true otherwise.
	public static boolean prevousCharInputChecker(char in, String in2) {
		boolean output=true;
		for(int i=0;i<in2.length();i++) {
			char x=in2.charAt(i);
			if (x==in) {return false;}
			else {output=true;}
		}
		return output;
	}
	
	// Given a string as an input, this method returns to the main 
	// program a string made of "*" that is as longs as input string.
	public static String stringToStars(String input){
		String output="";
		for(int i=0;i<input.length();i++) {
			output=output+"*";
		}
		return output;
	}
	
	// Given a Scanner as input, returns a List<String> of strings read from the Scanner.
	// The method should read words from the Scanner until there are no more words in the file
	// (i.e. inScanner.hasNext() is false).  The list of strings should be returned to the calling program.
	public static ArrayList<String> getList(Scanner inScanner) {
		ArrayList<String> list = new ArrayList<String>();
		while(inScanner.hasNext()){
			list.add(inScanner.nextLine()) ;}
		return list;
	}

	// Given two strings as input, compares the first string (guess) to the second
	// (solution) character by character.  If the two strings are not exactly the same,
	// return false.  Otherwise return true.
	public static boolean checkWord(String guess, String solution) {
		boolean output=true;
		if (guess.length()==solution.length()) {
		int counter=0;
		while(counter<guess.length()) {
			char x=guess.charAt(counter);
			char y=solution.charAt(counter);
			if(x==y) {output=true;} else {return false;}
			counter++;}
		}
		else {output=false;}
		return output;
	}
	
	// Given a ArrayList<String> list of strings as input, randomly selects one of the strings
	// in the list and returns it to the calling program.
	public static String getRandomWord(ArrayList<String> inList) {
		int x=inList.size()-1;
		int random=(int)(Math.random()*(x))+1;
		String output=inList.get(random);
		return output;
	}
	
	// Given a Scanner as input, prompt the user to enter a character.  If the character
	// enters anything other than a single character provide an error message and ask
	// the user to input a single character.  Otherwise return the single character to
	// the calling program.
	public static char getCharacterGuess(Scanner inScanner) {
		System.out.print("Enter a character to guess: ");
		String input=inScanner.nextLine().toUpperCase();
		while(input.isEmpty()||input.length()!=1||Character.isDigit(input.charAt(0))) {
			System.out.println("That is not a valid input" + "\n" + "Please try again.");
			System.out.print("Enter a character to guess: ");
			input=inScanner.nextLine().toUpperCase();}
		char y=input.charAt(0);
		return y;
	}
	
	// Given a character inChar and a ArrayList<Character> list of characters, check to see if the
	// character inChar is in the list.  If it is, return true.  Otherwise, return false. 
	public static boolean checkInList(char inChar, ArrayList<Character> inList) {
		boolean output=true;
		int counter=0;
		for(int i=0;i<inList.size();i++) {
			char y=inList.get(i);
			if(y==inChar) {counter++;}
		}
		if(counter>0) {output=true;}
		else {output=false;}
		return output;
	}
	
	// Given a String, return a String that is the exact same length but consists of 
	// nothing but '*' characters.  For example, given the String DOG as input, return
	// the string ***
	public static String starWord(String inWord) {
		int x=inWord.length();
		String output="";
		int counter = 0;
		while(counter<x) {output=output+"*"; counter++;}
		return output;
	}
	
	// Given a character and a String, return the count of the number of times the
	// character occurs in that String.
	public static int checkChar(char guessChar, String guessWord) {
		int x=guessWord.length();
		int counter = 0;
		int output=0;
		while(counter<x) {
			char y=guessWord.charAt(counter);
			if(y==guessChar) {output++;} counter++;}
		return output;
	}

	// Given a character, a String containing a word, and a String containing a 'guess'
	// for that word, return a new String that is a modified version of the 'guess' 
	// string where characters equal to the character inChar are uncovered.
	// For example, given the following call:
	//   modfiyGuess('G',"GEOLOGY", "**O*O*Y")
	// This functions should return the String "G*O*OGY".
	public static String modifyGuess(char inChar, String word, String currentGuess) {
		ArrayList<Character> currentString=new ArrayList<Character>();
		for (int i=0;i<currentGuess.length();i++) {currentString.add(currentGuess.charAt(i));}
		int x=word.length();
		int counter=0;
		while(counter<x) {
			char y=word.charAt(counter);
			if (y==inChar) {
				currentString.set(counter, inChar);
			}
			counter++;}
		String output="";
		for (int i=0;i<currentString.size();i++) {
			output=output+currentString.get(i);
		}
		return output;
	}
	
	// Given a Scanner as input, prompt the user to play again.  The only valid entries
	// from the user are 'Y' or 'N', in either upper or lower case.  If the user enters
	// a 'Y' the method should return a value of true to the calling program.  If the user
	// enters a 'N' the method should return a value of false.  If the user enters anything
	// other than Y or N (including an empty line), an error message should be displayed
	// and the user should be prompted again until a valid response is received.
	public static boolean promptForPlayAgain(Scanner inScanner) {
		System.out.print("Would you like a rematch [y/n]? ");
		String input = inScanner.nextLine(); 
		char userInput=input.charAt(0);
		while((userInput != 'Y' && userInput != 'y' && userInput != 'N' && userInput != 'n') || input.length()!=1 ) {
			System.out.println("\nThat is not a valid answer.  Please answer [y/n].");
			System.out.print("Would you like a rematch [y/n]? ");
			input = inScanner.nextLine();
			userInput=input.charAt(0);
		}
		if(userInput == 'y' || userInput == 'Y') {return true;}
		else {return false;}
	}
	
	// Given a Scanner as input, prompt the user to enter an input for the word.  If the character
	// enters anything other than a valid input provide an error message and ask
	// the user to input a valid string input. The program then checks if the user
	// entered the correct word, returning true if he/she did.
	public static String didUserGuessRight(Scanner inScanner,String guessWord) {
		System.out.print("Enter your guess: ");
		String input=inScanner.nextLine().toUpperCase();
		if(input.isEmpty()) {return"You have chosen to pass\n" + "\n" + "Please guess another letter and try again.";}
		else if(input.equals(guessWord)) {return "Congratulations! "+ input +" is the correct word.";}
		else {return "That is not the correct word.\n\nPlease guess another letter and try again.";}
	}
	
}