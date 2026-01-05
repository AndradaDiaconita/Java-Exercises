package LaddersSnakes;


import java.util.Scanner;


/** In this file, it is written all the code necessary in making the game work, from the amount of players, who starts first, the array,
 location and where they move, etc.*/


/** Public Class named LaddersAndSnakes */ 
public class LaddersAndSnakes {
	/** sets up the 2D array for the board */
	Player[][] board = new Player[10][10]; 
	/** creates player 1  object */
	Player player1 = new Player(); 
	/** creates player 2 object */
	Player player2 = new Player(); 
	/** game defaults to not being finished */
	boolean done = false; 
	
	/** Public void called play where it shows that the game starts and has an int attribute called PlayerCount */
	public void play(int PlayerCount) 
	{
		
		Scanner input = new Scanner(System.in);
		/** Proper amount of players, starts the game as it should be */
		if(PlayerCount == 2) 
		{

		}
		/** Too many players, pretends it is just two and starts the game as it should be */
		else if(PlayerCount > 2) 
		{
			System.out.println("-- Error: " + PlayerCount + " is too many players. Playing with 2 players instead.");
			/** the game will play it as a count of 2 (aka the if playercount = 2) */
			play(2);
			return;
		}
		/** too few players, close the console, do not play ,  have to press "run" again */
		else if(PlayerCount == 1) 
		{
			System.out.print("-- Error: Can't play by yourself! Not playing");
			/** will return to not started */
			return;
		}

		System.out.println("-- Please Name Player 1");
		/** Setter for name of player 1 */
		player1.setName( input.nextLine()); 
		System.out.println("-- Please Name Player 2");
		/** Setter for name of player 1 */
		player2.setName( input.nextLine());
		/** int attribute called order where it records the player order and has to take first one (1) */
		int order = PlayerOrder(1); //records player order
		/** If player one goes first, then: */
		if(order == 1) 
		{
			/** While the game is not won, the loop moves */
			while(!done) 
			{
				MovePlayer(player1);
				/** if still not done, it moves the other player */
				if(!done)
				{
					MovePlayer(player2);
				}
				/** if it's done and one of the player's has won, then boolean done becomes true and game ends */
				if(done) // checks if any player has won
				{
					return;
				}
				System.out.println("-- No player has won. Another turn will be played. \n");
			}
		}
		/** if player 2 goes first instead of order == 1 */
		else 
		{
			/** loop moves until someone has won */
			while(!done) 
			{
				MovePlayer(player2);
				if(!done)
				{
					MovePlayer(player1);
				}
				/** checks if any player has won */
				if(done)
				{
					return;
				}
				System.out.println("-- No player has won. Another turn will be played. \n");
			}
		}
		input.close();

	}
	/** New public int attribute called flip dice, where it rolls a die that contains values 1-6 */
	public int flipdice()
	{
		/** selects a random number 1-6, do *6 +1 in order to have numbers >0 and <6 */
		return (int) (Math.random()*6 + 1); 
	}
	/** Take the same attribute but related to an int attribute called rollcount, which chooses the order of players */
	public int PlayerOrder(int rollCount) 
	{
		System.out.println("-- Picking Player Order");
		/** method where you roll a dice for player 1 */
		int a = flipdice(); 
		System.out.println("- "+ player1.getName() + " rolled a " + a);
		/** method where you roll a dice for player 2 */
		int b = flipdice(); 
		System.out.println("- "+ player2.getName() + " rolled a " + b);
		/** sees if player 1 higher than player 2 */
		if(a > b) 
		{
			System.out.println("-- "+ player1.getName() + " rolled a higher number in just " + rollCount + " rolls. They will go first. Good for them! \n");
			return 1;
		}
		/** sees if player 2 rolled higher than player 1 */
		else if(a < b) 
		{
			System.out.println("-- "+ player2.getName() + " rolled a higher number in just" + rollCount + " rolls. They will go first. Good for them! \n");
			return 2;
		}
		/** if neither rolled higher, they tied */
		else 
		{
			System.out.println("-- The players seemed to have tied. Let's have them reroll! \n");
			/** restarts PlayerOrder and does the rollcount again, this is why we add 1, "new" rollcount */
			return PlayerOrder(rollCount + 1);
		}
	}
	/** new array int attribute called FindPlayer, that has the object Player P , located the player on the board */
	public int[] FindPlayer(Player P)
	{
		/** creates a variable for the location of the player */
		int location = 1; 
		/** sorts through the 2D array with and for loop, starts at 0 and increases, the maximum is the board length */
		for(int i = 0; i < board.length; i++) 
		{
			/** same idea */
			for(int j = 0; j < board[i].length; j++) 
			{
				/** Checks to see if player is found in a specific place in the array (board) */
				if( board[i][j] == P) 
				{
					/** return new place at that specific array place */
					return new int[] {i,j};
				}
			}
		}	
		/**if player isn't on the board, they are at spot 0 */
		return new int[] {0,0};
	}
	/** New public void called MovePlayer that contains the Player object P */
	public void MovePlayer(Player p)
	{
		/** Create array int called CurrentLocation which gets players current location from 2D array board */
		int[] CurrentLocation = FindPlayer(p); 
		/** removes player from their current spot by writing = to null */
		board[CurrentLocation[0]][CurrentLocation[1]] = null; 
		/** remembers the starting location of player */
		int slocation = CurrentLocation[0]*10 + CurrentLocation[1]; 
		System.out.print( p.getName() + " is on square " + slocation + " //  "); 
		/** rolls dice for a player the flipdice method mentionned above */
		int MoveAmount = flipdice(); 
		System.out.print( p.getName() + " rolled a " + MoveAmount + " //  ");
		/** need to keep unit digit less than 10 */
		if(CurrentLocation[1] + MoveAmount > 9) 
		{
			CurrentLocation[0] = CurrentLocation[0] + 1;
			CurrentLocation[1] = CurrentLocation[1] + MoveAmount - 10;
		}
		else
		{
			CurrentLocation[1] = CurrentLocation[1] + MoveAmount;
		}
		/** keeps track of int value of the moved location */
		int location = slocation + MoveAmount; 
		/** they win if this condition is met */
		if(location == 100) 
		{
			done = true;
			/** set the location to the winner spot */
			p.setLocation(CurrentLocation);
			System.out.println(p.getName() + " is now on square " + location );
			System.out.print("\n \n" + p.getName() + " won the game!!!! ");
			/** return to the game being done = true, so end of game, there is a winner */
			return;
		}
		/** they need to be pushed back if this condition is met */
		if (location > 100) 
		{
			System.out.print(p.getName() + " went above 100. We'll send them down //  ");
			/** unit digit of space needs to be between 0-9 at all times */
			if(CurrentLocation[1] - 2*(location - 100) < 0) 
			{
				CurrentLocation[0] = CurrentLocation[0] - 1;
				CurrentLocation[1] = CurrentLocation[1] - 2*( location -100) + 10;
			}
			else
			{
				CurrentLocation[1] = CurrentLocation[1] - 2*(location - 100);
			}
		}
		/** keeps track of int value of the location */
		location = CurrentLocation[0]*10 + CurrentLocation[1];
		/** checks for snakes on the square */
		if(snakeCheck(CurrentLocation) < 0 ) 
		{
			/** create int variable called snakedrop, which records the distance the snake pushes someone down */
			int snakedrop = snakeCheck(CurrentLocation); 
			System.out.print("Uh oh! " + p.getName() + " landed on the " + location + " square snake! They moved back " + -1* snakeCheck(CurrentLocation) + " squares. //  ");
			/** gets new int value of location with the snake drop */
			location = location + snakedrop; 
			/** gets row on board */
			CurrentLocation[0] = (int) location/10; 
			/** gets column on board */
			CurrentLocation[1] = location - CurrentLocation[0]*10; 
		}
		/** checks if a ladder also is on the square */
		if(ladderCheck(CurrentLocation) > 0) 
		{
			/** create int variable called ladderCheck, which records the upward distance of ladder */
			int ladderjump = ladderCheck(CurrentLocation); 
			System.out.print("Yay! " + p.getName() + " landed on the " + location + " square ladder! They moved up " +  ladderCheck(CurrentLocation) + " squares. //  ");
			location = location + ladderjump; 
			/** checks for winning condition */
			if(location == 100) 
			{
				/** game is done */
				done = true; 
				/** saves player location in its object */
				p.setLocation(CurrentLocation); 
				System.out.println(p.getName() + " is now on square " + location );
				System.out.print("\n \n" + p.getName() + " won the game!!!! ");
				/** ends move sequence */
				return; 
			}
			/** gets new row on board*/
			CurrentLocation[0] = (int) location/10; 
			/** gets column on board */
			CurrentLocation[1] = location - CurrentLocation[0]*10; 
		}
		/** checks if other player is on the same board square */
		if(board[CurrentLocation[0]][CurrentLocation[1]] != null ) 
		{
			/** if they are, they are moved to square 1 */
			board[0][1] = board[CurrentLocation[0]][CurrentLocation[1]]; 
			System.out.print(board[0][1].getName() + " just got kicked back to square 1 //  ");
		}
		/** places player back on board at their new spot */
		board[CurrentLocation[0]][CurrentLocation[1]] = p; 
		/** saves player location in its object */
		p.setLocation(CurrentLocation); 
		/** announces player's final square for turn */
		System.out.println(p.getName() + " is now on square " + location ); 
	}

	/** checks to see if the square a player is moving to has a snake head */
	public int snakeCheck( int location[]) 
	{
		/** creates a board to place snakes on */
		int[][] Snakes = new int[10][10]; 
		Snakes[1][6] = -10; Snakes[4][8] = -18; Snakes[6][4] = -4; Snakes[7][9] = -60; Snakes[9][8] = -20;
		/** locates snake heads on the board and how much they go down */
		Snakes[9][7] = -21; Snakes[9][5] = -71; Snakes[9][3] = -25; 

		/** checks for a snake head at player's current spot */
		if(Snakes[location[0]][location[1]] < 0) // 
		{
			return  Snakes[location[0]][location[1]];
		}
		else
		{
			/** nothing happens if no snake */
			return 0; 
		}
	}
	
	/** checks to see if the square a player is moving to has a ladder bottom */
	public int ladderCheck( int location[]) 
	{
		/** creates a board to place ladders on */
		int[][] Ladders = new int[10][10]; 
		Ladders[8][0] = 20; Ladders[0][1] = 37; Ladders[0][4] = 10; Ladders[0][9] = 22; Ladders[2][8] = 56; Ladders[2][1] = 21;
		/** locates ladder bottoms on the board and how much they go up */
		Ladders[3][6] = 8; Ladders[5][1] = 16; Ladders[7][1] = 20; 
		/** checks for a ladder bottom at player's current spot */
		if(Ladders[location[0]][location[1]] > 0) 
		{
			/** returns how much the ladder takes the player up*/
			return Ladders[location[0]][location[1]]; 
		}
		/** nothing happens if no ladder */
		return 0; 
	}
}


