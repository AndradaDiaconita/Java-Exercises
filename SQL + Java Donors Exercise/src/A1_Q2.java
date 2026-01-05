import java.util.Scanner;

public class A1_Q2 {

	public static void main(String[] args) {
		

	
		
		{
			
	// In Question 2, my program is a Scanner that helps changing the weather from Celsius to Fahrenheit and vice versa to the inputs of an user in the console.
	// I made the choice to use double for all of the variables in order for the calculated variables as C2 F2 remainder and exponent to have lots of decimals and in order for all the answers in the console to be precise..
	// I added \n to the 1st, 2nd, 3rd, 4th, 5th and 6th print so every sentence or answers skips to the next line and doesn't follow all in a single line.
	
			// Create new Scanner and Name it in order to use Input
		Scanner in2 = new Scanner (System.in);
		
			// Print the Welcome message of the Project
		System.out.print("Welcome to the Simple Meteorological Program");
		System.out.print("\n+++++++++++++++++++++++++++++++++++++++++++");
		
			// Print the question and name the variables in order to write them in the Console
		System.out.print("\nPlease enter the values for the \'Fahrenheit\' and \'Celsius\', simultaneously: ");
			double F = in2.nextDouble();
			double C = in2.nextDouble();
		
			// Name the result variables with their calculations
			// These Variables will change depending of the User input
			double C2 = 10 * (F - 32) / 18;
			double F2 = (C * 18 / 10) + 32;
			{
		System.out.print("\nThe corresponding temperature in Celsius unit is: " + C2);
		System.out.print("\nThe corresponding temperature in Fahrenheit unit is: " + F2);
			}
			
			// Math.round was used in order to round the answers.
			// Math.pow is a package used in order to calculate the exponent of the inputs.
			double remainder = Math.round(F2) % Math.round(C2);
			double exponent = Math.pow(F2, C2);
			{
		System.out.print("\nThe corresponding value for x is: " + remainder);
		System.out.print("\nThe corresponding value for y is: " + exponent);
			}
			
			// Close the scanner as it's recommended
		in2.close();
		
		}

	}

}
