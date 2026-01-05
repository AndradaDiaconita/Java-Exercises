package LaddersSnakes;



import java.util.Scanner;

public class PlayLadderAndSnake {
	public static void main( String[] args)
	{
		/** allows for user to be asked questions */
		Scanner input = new Scanner(System.in); 
		System.out.println("How many players would you like for Ladders & Snakes?"); 
		/** takes users player count */
		int playerCount = input.nextInt();
		/** creates an object of the game */
		LaddersAndSnakes laddersAndSnakes = new LaddersAndSnakes(); 
		/** plays game */
		laddersAndSnakes.play(playerCount); 
		
		input.close();
	}

}