package snakesGame;

public class Boards {
	
	public int snakeCheck( int location[]) //checks to see if the square a player is moving to has a snake head
	{
		int[][] Snakes = new int[10][10]; //creates a board to place snakes on
		Snakes[1][6] = -10; Snakes[4][8] = -18; Snakes[6][4] = -4; Snakes[7][9] = -60; Snakes[9][8] = -20;
		Snakes[9][7] = -21; Snakes[9][5] = -71; Snakes[9][3] = -25; // locates snake heads on the board and how much they go down
		
		if(Snakes[location[0]][location[1]] < 0) // checks for a snake head at player's current spot
		{
			return  Snakes[location[0]][location[1]];
		}
		else
		{
			return 0; // nothing happens if no snake
		}
	}
	public int ladderCheck( int location[]) //checks to see if the square a player is moving to has a ladder bottom
	{
		int[][] Ladders = new int[10][10]; //creates a board to place ladders on
		Ladders[8][0] = 20; Ladders[0][1] = 37; Ladders[0][4] = 10; Ladders[0][9] = 22; Ladders[2][8] = 56; Ladders[2][1] = 21;
		Ladders[3][6] = 8; Ladders[5][1] = 16; Ladders[7][1] = 20; //locates ladder bottoms on the board and how much they go up
		if(Ladders[location[0]][location[1]] > 0) //checks for a ladder bottom at player's current spot
		{
		return Ladders[location[0]][location[1]]; //returns how much the ladder takes the player up
		}
		return 0; // nothing happens if no ladder
	}
}
