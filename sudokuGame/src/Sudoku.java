import java.util.Scanner;

public class Sudoku {
    public static void sudoku() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size n of the Sudoku (n x n): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        int[][] grid = new int[n][n];

        // input with validation
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter the " + n + " numbers of row " + (i + 1) + ": ");
                String line = scanner.nextLine();
                String[] parts = line.trim().split("\\s+");

                if (parts.length != n) {
                    System.out.println("Please enter exactly " + n + " numbers.");
                    continue;
                }

                boolean valid = true;
                for (int j = 0; j < n; j++) {
                    try {
                        grid[i][j] = Integer.parseInt(parts[j]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number. Please try again.");
                        valid = false;
                        break;
                    }
                }

                if (valid) 
                	break;
            }
        }

        // sum first row
        int targetSum = 0;
        for (int j = 0; j < n; j++) {
            targetSum += grid[0][j];
        }

        // check rows
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum != targetSum) {
                System.out.println("You lose!");
                return;
            }
        }

        // check columns
        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += grid[i][j];
            }
            if (colSum != targetSum) {
                System.out.println("You lose!");
                return;
            }
        }

        // check main diagonal
        int mainDiagSum = 0;
        for (int i = 0; i < n; i++) {
            mainDiagSum += grid[i][i];
        }
        if (mainDiagSum != targetSum) {
            System.out.println("You lose!");
            return;
        }

        // check other diagonal
        int otherDiagSum = 0;
        for (int i = 0; i < n; i++) {
            otherDiagSum += grid[i][n - 1 - i];
        }
        if (otherDiagSum != targetSum) {
            System.out.println("You lose!");
            return;
        }

        //all checks good
        System.out.println("You win!");
    }

    public static void main(String[] args) {
        sudoku();
    }
}
