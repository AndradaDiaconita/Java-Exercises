package snakesGame;

import java.util.Scanner;

public class PlayLadderAndSnake {
	public static void main( String[] args)
	{
		Scanner input = new Scanner(System.in); //allows for user to be asked questions
		System.out.println("How many players would you like for Ladders & Snakes?"); 
		int PlayerCount = input.nextInt(); //takes users player count
		LaddersAndSnakes laddersAndSnakes = new LaddersAndSnakes(); // creates an object of the game
		laddersAndSnakes.play(PlayerCount); // plays game
	}
}
