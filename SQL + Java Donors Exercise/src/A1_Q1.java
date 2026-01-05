
import java.util.Scanner;

public class A1_Q1 {

	public static void main(String[] args) {
		

		
		
		{
			
	// In Question 1, my program is a Scanner that helps showing the coordinates of objects in a 3D space.
	// I made the choice to use byte instead of double because the max value byte can have is of 127 which is the one required in the question.
	// The coordinates are chosen to be double variables because the coordinates are with many decimals.
	// I added \n to the 1st, 2nd, 3rd and 4th print so every sentence or answers skips to the next line and doesn't follow all in a single line.
			
			// Create new Scanner and Name it in order to use Input
		Scanner in = new Scanner (System.in);
		
			// Print the Welcome message of the Project
		System.out.print("Welcome to the Simple 3D-Space Program:");
		System.out.print("\n+++++++++++++++++++++++++++++++++++++++");
		
			// Print the question and name the variables in order to write them in the Console
		System.out.print("\nPlease enter the values for \'p\' and \'q\', simultaneously: ");
			byte p = in.nextByte();
			byte q = in.nextByte();
			
			// Name the result variables with their calculations
			// These Variables will change depending of the User input
			double x = (((p*22/7)/(2.718281828))+50);
			double y = (((p*22/7)/(2.718281828))+(50*12));
			double z = (q+y);
		
			double y1 = (x * 12);
			double z1 = (q + (y1 * 6));
		
			// Print the final answers in the Console thanks to the calculations variables
			{
		System.out.print("\nThe cartesian coordinates of the first object is:" + "\n" +"(" + x + ", " + y + ", " + z + ")");
		System.out.print("\nThe cartesian coordinates of the nearest object is:" + "\n" +"(" + x + ", " + y1 + ", " + z1 + ")");
			}
			
			// Close the Scanner as it's recommended
		in.close();
		
		}

		

		
	}

}
