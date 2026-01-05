package LaddersSnakes;




/**Player model is here for reusability for when the game is scaled for more than two players!*/
		/**location and name are private to keep with encapsulation*/
public class Player {
	/** Default constructor */
			public Player() {}

			/** Instance Variables */
			private int[] location = new int[] {0,0};
			private String name;


			/** Getters for location, returns the square value */
			public int getlocationInt() 
			{
				return location[0]*10 + location[1];
			}
			/** Getters for location, returns the row and column of the player */
			public int[] getLocation() 
			{
				return location;
			}
			/** Getters for names, returns players names */
			public String getName() 
			{
				return name;
			}
			/** Setters for location, records player row and column */
			public void setLocation(int[] a) 
			{
				location = a;
			}
			/** Setters for names, records player name */
			public void setName(String b) 
			{
				name = b;
			}
		}


