package snakesGame;

import java.util.Scanner;

public class LaddersAndSnakes {
	Player[][] Board = new Player[10][10]; // sets up the 2D array for the board
	Boards Specials = new Boards(); // creates a version of snake and ladder location boards
	Player player1 = new Player(); // creates player 1
	Player player2 = new Player(); // creates player 2
	boolean done = false; // game defaults to not being finished
	
	public int flipdice() // rolls a die that contains values 1-6
	{
		return (int) (Math.random()*6 + 1); // selects a random number 1-6
	}
	public void play(int PlayerCount) // starts the game
	{
		Scanner input = new Scanner(System.in);
		if(PlayerCount == 2) // proper amount of players, continues as normal
		{
			
		}
		else if(PlayerCount > 2) // too many players, pretends it is just two
		{
			System.out.println("-- Error: " + PlayerCount + " is too many players. Playing with 2 players instead.");
			play(2);
			return;
		}
		else if(PlayerCount == 1) // too few players, does not play
		{
			System.out.print("-- Error: Can't play by yourself! Not playing");
			return;
		}
		
		System.out.println("-- Please Name Player 1");
		player1.setName( input.nextLine()); //records player name in object
		System.out.println("-- Please Name Player 2");
		player2.setName( input.nextLine()); //records player name in object
		int order = PlayerOrder(); //records player order
		if(order == 1) // if player one goes first
		{
			while(!done) // loops moves until someone has won
			{
				MovePlayer(player1);
				if(!done) 
				{
					MovePlayer(player2);
				}
				if(done) // checks if any player has won
				{
					return;
				}
				System.out.println("-- No player has won. Another turn will be played. \n");
			}
		}
		else // if player two goes first
		{
			while(!done) // loops moves until someone has won
			{
				MovePlayer(player2);
				if(!done)
				{
					MovePlayer(player1);
				}
				if(done) //checks if any player has won
				{
					return;
				}
				System.out.println("-- No player has won. Another turn will be played. \n");
			}
		}
			
	}
	public int PlayerOrder() // chooses the order of players
	{
		System.out.println("-- Picking Player Order");
		int a = flipdice(); // rolls a dice for player 1
		System.out.println("- "+ player1.getName() + " rolled a " + a);
		int b = flipdice(); // rolls a dice for player 2
		System.out.println("- "+ player2.getName() + " rolled a " + b);
		if(a > b) // sees if player one rolled higher than player 2
		{
			System.out.println("-- "+ player1.getName() + " rolled a higher number. They will go first. Good for them! \n");
			return 1;
		}
		else if(a < b) // sees if player two rolled higher than player 1
		{
			System.out.println("-- "+ player2.getName() + " rolled a higher number. They will go first. Good for them! \n");
			return 2;
		}
		else // if neither rolled higher, they tied
		{
			System.out.println("-- The players seemed to have tied. Let's have them reroll! \n");
			return PlayerOrder();
		}
	}
	public int[] FindPlayer(Player P) // locates the player on the board
	{
		int location = 1; // creates a variable for the location of the player
		for(int i = 0; i < Board.length; i++) // sorts through the 2D array
		{
			for(int j = 0; j < Board[i].length; j++) // sorts through the 2D array
			{
				if( Board[i][j] == P) // checks to see if player is found
				{
					return new int[] {i,j};
				}
			}
		}	
		return new int[] {0,0}; // if player isn't on the board, they are at spot 0
	}
	public void MovePlayer(Player p)
	{
		int[] CurrentLocation = FindPlayer(p); // gets players current location from 2D array board
		Board[CurrentLocation[0]][CurrentLocation[1]] = null; //removes player from their current spot
		int slocation = CurrentLocation[0]*10 + CurrentLocation[1]; // remembers the starting location of player
		System.out.print( p.getName() + " is on square " + slocation + " //  "); 
		int MoveAmount = flipdice(); //rolls dice for player
		System.out.print( p.getName() + " rolled a " + MoveAmount + " //  ");
		if(CurrentLocation[1] + MoveAmount > 9) // need to keep unit digit less than 10
		{
			CurrentLocation[0] = CurrentLocation[0] + 1;
			CurrentLocation[1] = CurrentLocation[1] + MoveAmount - 10;
		}
		else
		{
			CurrentLocation[1] = CurrentLocation[1] + MoveAmount;
		}
		int location = slocation + MoveAmount; // keeps track of int value of the moved location
		if(location == 100) // they win if this condition is met
		{
			done = true;
			p.setLocation(CurrentLocation);
			System.out.println(p.getName() + " is now on square " + location );
			System.out.print("\n \n" + p.getName() + " won the game!!!! ");
			return;
		}
		if (location > 100) // they need to be pushed back if this condition is met
		{
			System.out.print(p.getName() + " went above 100. We'll send them down //  ");
			if(CurrentLocation[1] - 2*(location - 100) < 0) // unit digit of space needs to be between 0-9 at all times
			{
				CurrentLocation[0] = CurrentLocation[0] - 1;
				CurrentLocation[1] = CurrentLocation[1] - 2*( location -100) + 10;
			}
			else
			{
				CurrentLocation[1] = CurrentLocation[1] - 2*(location - 100);
			}
		}
		location = CurrentLocation[0]*10 + CurrentLocation[1]; // keeps track of int value of the location
		if(Specials.snakeCheck(CurrentLocation) < 0 ) //checks for snakes on the square
		{
			int snakedrop = Specials.snakeCheck(CurrentLocation); // records the distance the snake pushes someone down
			System.out.print("Uh oh! " + p.getName() + " landed on the " + location + " square snake! They moved back " + -1* Specials.snakeCheck(CurrentLocation) + " squares. //  ");
			location = location + snakedrop; // gets new int value of location with the snake drop
			CurrentLocation[0] = (int) location/10; // gets row on board
			CurrentLocation[1] = location - CurrentLocation[0]*10; // gets column on board
		}
		if(Specials.ladderCheck(CurrentLocation) > 0) //checks if a ladder also is on the square
		{
			int ladderjump = Specials.ladderCheck(CurrentLocation); // records the upward distance of ladder
			System.out.print("Yay! " + p.getName() + " landed on the " + location + " square ladder! They moved up " +  Specials.ladderCheck(CurrentLocation) + " squares. //  ");
			location = location + ladderjump; 
			if(location == 100) // checks for winning condition
			{
				done = true; // game is done
				p.setLocation(CurrentLocation); // saves player location in its object
				System.out.println(p.getName() + " is now on square " + location );
				System.out.print("\n \n" + p.getName() + " won the game!!!! ");
				return; //ends move sequence
			}
			CurrentLocation[0] = (int) location/10; //gets new row on board
			CurrentLocation[1] = location - CurrentLocation[0]*10; //gets column on board
		}
		if(Board[CurrentLocation[0]][CurrentLocation[1]] != null ) //checks if other player is on the same board square
		{
			Board[0][1] = Board[CurrentLocation[0]][CurrentLocation[1]]; // if they are, they are moved to square 1
			System.out.print(Board[0][1].getName() + " just got kicked back to square 1 //  ");
		}
		Board[CurrentLocation[0]][CurrentLocation[1]] = p; // places player back on board at their new spot
		p.setLocation(CurrentLocation); // saves player location in its object
		System.out.println(p.getName() + " is now on square " + location ); // announces player's final square for turn
	}
}
