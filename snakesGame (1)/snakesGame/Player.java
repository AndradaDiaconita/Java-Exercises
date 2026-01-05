package snakesGame;

public class Player {
	private int[] location = new int[] {0,0};
	private String name;
	public int getlocationInt() // returns the square value
	{
		return location[0]*10 + location[1];
	}
	public int[] getLocation() // returns the row and column of the player
	{
		return location;
	}
	public String getName() //returns player name 
	{
		return name;
	}
	public void setLocation(int[] a) //records player row and column
	{
		location = a;
	}
	public void setName(String b) // records player name
	{
		name = b;
	}
}
