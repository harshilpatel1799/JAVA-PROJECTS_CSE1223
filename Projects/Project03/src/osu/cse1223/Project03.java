/*
 * Project03.java
 * This program asks the user to answer a series of simple math problems,
 * then the program tells the user how many they got correct.
 * 
 * 
 * @author Harshil S. Patel
 * @version 20180128
 */





package osu.cse1223;
import java.util.Scanner;
public class Project03 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String userName = in.nextLine();
		System.out.println("Welcome " + userName + "!"  + " Please answer the following questions: \n ");
		int randomValue1 =  (int)(20 * Math.random()) + 1;
		int randomValue2 =  (int)(20 * Math.random()) + 1;
		int correct = 0;
		System.out.print(randomValue1 + " + " + randomValue2 + " = ");
		int answer1 = in.nextInt();
		if (answer1 == (randomValue1+randomValue2)) {
			correct++;
			System.out.println("Correct!\n");
		}
		else {
			System.out.println("Wrong!");
			System.out.println("The correct answer is " + (randomValue1+randomValue2)+"\n");
		}
		System.out.print(randomValue1 + " * " + randomValue2 + " = ");
		int answer2 = in.nextInt();
		
		if (answer2 == (randomValue1*randomValue2)) {
			correct++;
			System.out.println("Correct!\n");
		}
		else {
			System.out.println("Wrong!");
			System.out.println("The correct answer is " + (randomValue1*randomValue2)+"\n");
		}
		System.out.print(randomValue1 + " / " + randomValue2 + " = ");
		int answer3 = in.nextInt();
		
		if (answer3 == (randomValue1/randomValue2)) {
			correct++;
			System.out.println("Correct!\n");
		}
		else {
			System.out.println("Wrong!");
			System.out.println("The correct answer is " + (randomValue1/randomValue2)+"\n");
		}
		System.out.print(randomValue1 + " % " + randomValue2 + " = ");
		int answer4 = in.nextInt();
		
		if (answer4 == (randomValue1%randomValue2)) {
			correct++;
			System.out.println("Correct!\n");
		}
		else {
			System.out.println("Wrong!");
			System.out.println("The correct answer is " + (randomValue1%randomValue2)+"\n");
		}
		double totalQuestions = 4.0;
		double percentageCorrect = (correct/totalQuestions);
		System.out.println("You got " + correct + " correct answers");
		System.out.println("That's "+ percentageCorrect + "%!");
	}

}
