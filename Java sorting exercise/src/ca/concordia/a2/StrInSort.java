package ca.concordia.a2;




import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StrInSort {
	private static int ascCount = 0;
    private static int reversalCount = 0;
    private static int overallCompares = 0;
    private static int structuringCompares = 0;
    private static int swap = 0;

    public static void main(String[] args) {

    	    // Check if the input file name is provided as an argument
    	    if (args.length < 1) {
    	        return;
    	    }

    	    // Read the input data from the file
    	    int[] data = readFile(args[0]);
  

    	    // Output the initial array
    	    outputResult(data);

    	    // Perform the structuring pass on the data
    	    structuringPass(data);

    	    // Perform the insertion sort
    	    insertionSort(data);
    	    
    	    // Update the overallCompares with the structuringCompares
    	    overallCompares += structuringCompares;

    	    // Output the sorting statistics
        System.out.println("We sorted in ASC order.");
        System.out.println("We counted " + ascCount + " ASC runs of length 4.");
        System.out.println("We performed " + reversalCount + " reversals of runs in DECR order.");
        System.out.println("We performed " + structuringCompares + " compares during structuring.");
        System.out.println("We performed " + overallCompares + " compares overall.");
        System.out.println("We performed " + swap + " swaps overall.");

        // Output the sorted array
        outputResult(data);
        
    }

    
    
    private static int[] readFile(String fileName) {
    	
        // Read the input data from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        	
            // Read the first line of the file
            String line = reader.readLine();

            // Split the line into individual numbers
            String[] numbers = line.split(" ");

            // Create an array to store the parsed integers
            int[] data = new int[numbers.length];

            // Parse each number and store it in the array
            for (int i = 0; i < numbers.length; i++) {
                data[i] = Integer.parseInt(numbers[i]);
            }

            // Return the array of parsed integers
            return data;

        } catch (IOException e) {
            // Handle any IOException that occurs during file reading
            System.out.println("ERROR! Could not read the file: " + e.getMessage());

        }

        // Return an empty array if there was an error reading the file
        return new int[0];
        
    }

    
    
    private static void outputResult(int[] array) {
    	
        // Print each element of the array
        for (int num : array) {
            System.out.print(num + " ");
        }

        // Print a new line after printing the array
        System.out.println();
        
    }



    private static void structuringPass(int[] array) {
    	
        // Get the length of the array
        int length = array.length;
        
        // Initialize the current index
        int position = 0;

        // Iterate through the array
        while (position < length - 1) {
        	
            // Set the start and end indices of the run
            int start = position;
            int end = position;
            
            // Check if the run is descending
            boolean DECR = array[position] > array[position + 1];

            // Find the longest possible run in the current direction
            while (position < length - 1 && ((DECR && array[position] > array[position + 1]) 
                    || (!DECR && array[position] < array[position + 1]))) {
                position++;
                end++;
                overallCompares++;
            }

            
            // Calculate the length of the run
            int runLength = end - start + 1;

            // Check if the run is an ascending run of length 4
            if (runLength == 4 && !DECR) {
                ascCount++;
            } 
            
            // Check if the run is descending
            else if (DECR) {
                reversalCount++;
                reversal(array, start, end);
            }
            
            // Move to the next index
            position++;
            
            // Update the structuring compares count
            structuringCompares += runLength;
        }
        
        // Adjust the structuring compares count to account for the last increment
        structuringCompares = structuringCompares - 1;
        
    }



    private static void reversal(int[] array, int start, int end) {
    	
        // Reverse the elements in the specified range
        while (start < end) {
        	
            // Swap the elements
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            
            
            // Increment the swap count
            swap++;
            
            
            // Increment the overall compares count
            overallCompares++;
            
            
            // Move the start and end indices
            start++;
            end--;
            
        }
    }

    

    private static void insertionSort(int[] array) {
    	
        // Get the length of the array
        int length = array.length;

        // Iterate over the array starting from the second element
        for (int i = 1; i < length; i++) {
            // Store the current element
            int temp = array[i];
            
            // Initialize the index for comparison
            int j = i - 1;

            // Compare and shift elements to the right
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                
                // Increment the overall compares count
                overallCompares++;
                
                // Move to the previous index
                j--;
                
                // Increment the swap count
                swap++;
                
               if (j<0) {
            	   overallCompares--;
               }
                  
            }
            
            // Place the current element at the correct position
            array[j + 1] = temp;
        }
        
        // Increment the overall compares count
        overallCompares= overallCompares+1;
        
    }


}
