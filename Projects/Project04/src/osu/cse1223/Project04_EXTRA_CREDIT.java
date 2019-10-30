/*
 * Project04_EXTRA_CREDIT.java
 * This program generate a random choice of Fire, Plant or Water for the computer. It should then prompts the user for 
 * their choice of Dragon type. The program compares/battles the types of dragon chosen in a tournament by type. After the user has won 2 
 * matches,the tournament completes, displaying the tournaments statistics.
 * 
 * @ author Harshil Sanjay Patel
 * @version 20180205
 */

package osu.cse1223;
import java.util.Scanner;
public class Project04_EXTRA_CREDIT {

	public static void main(String[] args) {
		int totalMatches=0;
		int userWins=0;
		int matchTies=0;
		int computerWins=0;
		while (userWins<2){
		int computerRandomPick =  (int)(3 * Math.random()) + 1;
		String computerDragonType = "";
		if (computerRandomPick==1) {computerDragonType= "Fire";}
		if (computerRandomPick==2) {computerDragonType= "Plant";}
		if (computerRandomPick==3) {computerDragonType= "Water";}
		//Above, the computer chooses Type of Dragon.
		Scanner in = new Scanner(System.in);
		System.out.print("Please select one of your dragons [Fire/Plant/Water]: ");
		String userinput = in.nextLine();
		char userDragon = userinput.charAt(0);
		int userDragonValue;
		String userDragonType = "";
		if (userDragon==('f') || userDragon == 'F'){
			userDragonType="Fire";
			System.out.println("You chose: "+ userDragonType +" dragon");
			userDragonValue=1;}
		else if (userDragon==('p') || userDragon == 'P'){
			userDragonType="Plant";
			System.out.println("You chose: "+ userDragonType +" dragon");
			userDragonValue=2;}	
		else if (userDragon==('w') || userDragon == 'W'){   
			userDragonType="Water";
			System.out.println("You chose: "+ userDragonType +" dragon");
			userDragonValue=3;}
		else {System.out.println("You don't have a "+ userinput +" dragon, so you choose no dragons.");userDragonValue=0;}
		// Above, the user chooses a Dragon.
		System.out.println("I chose: "+ computerDragonType +" dragon");
		// Above, Computer displays what type of dragon it choose.
		
		
		
		
		
		
		
		if (computerRandomPick>userDragonValue) 
		{
			if (userDragonValue==0) 
				{System.out.println("You lose by default!"+"\n");computerWins++;}
			else if (computerRandomPick==3 && userDragonValue==2) 
				{System.out.println(userDragonType +" defeats "+ computerDragonType +" - you win!"+"\n");userWins++;}
			else if (computerRandomPick==2 && userDragonValue==1) 
				{System.out.println(userDragonType +" defeats "+ computerDragonType +" - you win!"+"\n");userWins++;}
            else 
            	{System.out.println(computerDragonType +" defeats "+ userDragonType +" - you lose!"+"\n");computerWins++;}
		}	
		if (computerRandomPick==userDragonValue){System.out.println("A Tie!"+"\n");matchTies++;}
		if (userDragonValue>computerRandomPick)  
		{
			if (computerRandomPick==2 && userDragonValue==3) 
				{System.out.println(computerDragonType +" defeats "+ userDragonType +" - you lose!"+"\n");computerWins++;}
			else if (computerRandomPick==1 && userDragonValue==2) 
            	{System.out.println(computerDragonType +" defeats "+ userDragonType +" - you lose!"+"\n");computerWins++;}
			else 
				{System.out.println(userDragonType +" defeats "+ computerDragonType +" - you win!"+"\n");userWins++;}
		}
		totalMatches++;
		}
		System.out.println("Out of "+totalMatches+" matches you won "+ userWins +", I won "+computerWins+", and we tied "+matchTies+ ".");
		System.out.println("Congratulations - you win the tournament!");
	}}
