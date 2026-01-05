


// Andrada Diaconita
// 261116359



import java.util.Scanner;
import java.util.Arrays;

public class Hangman2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        // show welcome title
        System.out.println("--------------------------------------------");
        System.out.println("        Welcome to HANGMAN2");
        System.out.println("--------------------------------------------\n");

        System.out.println("OK Guessing Player ... turn around, while your friend enters the word to guess!\n\n\n");
        
        
        // enter word
        System.out.print("Other Player - Enter your word (up to 10 letters only, not case sensitive): ");
        String inputWord = scanner.nextLine().toUpperCase();

        // word is valid
        while (inputWord.length() == 0 || inputWord.length() > 10 || !inputWord.matches("[A-Z]+")) {
            System.out.println("Invalid input. Please enter up to 10 letters (A-Z only): ");
            inputWord = scanner.nextLine().toUpperCase();
        }

        
        // change word to char array and make hidden version with stars
        char[] word = inputWord.toCharArray();
        char[] hidden = new char[word.length];
        Arrays.fill(hidden, '*');

        
        // alphabet array
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        
        // count times of each letter in word
        int[] letterCounts = new int[26];
        for (char c : word) {
            letterCounts[c - 'A']++;
        }

        
        
        // blank lines to hide word
        for (int i = 0; i < 20; i++) System.out.println();
        
        
        

        // set guesses left and if player won yet
        int guessesLeft = 10;
        boolean gameWon = false;

        while (guessesLeft > 0 && !gameWon) {
            // display current word state
            System.out.print("Word to date: ");
            System.out.print(hidden);
            System.out.println(" (" + guessesLeft + " guess(es) left)");

            // show alphabet
            System.out.print("Letters to try: ");
            System.out.println(alphabet);

            // ask to guess word/letter
            System.out.print("Want to solve the puzzle? Enter \"Y\" to solve the puzzle, or \"N\" to guess a character: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            
            
            if (choice.equals("Y")) {
                System.out.print("Enter your solution: ");
                String attempt = scanner.nextLine().toUpperCase();
                if (attempt.equals(inputWord)) {
                    gameWon = true;
                    break;
                } else {
                    System.out.println("Incorrect solution!");
                    guessesLeft--;
                    continue;
                }
            }

            // wrong input if not Y or N
            if (!choice.equals("N")) {
                System.out.println("Invalid input. Please enter Y or N.");
                continue;
            }

            
            
            // guess a letter
            System.out.print("Which letter should I check for? ");
            String letterInput = scanner.nextLine().toUpperCase();

            // check if letter is valid and not guessed
            if (letterInput.length() != 1 || !letterInput.matches("[A-Z]")) {
                System.out.println("--> Not a valid request - either not a letter or already guesses.");
                continue;
            }

            
            char guessedLetter = letterInput.charAt(0);
            boolean alreadyGuessed = true;
            for (char c : alphabet) {
                if (c == guessedLetter) {
                    alreadyGuessed = false;
                    break;
                }
            }

            if (alreadyGuessed) {
                System.out.println("--> Not a valid request - either not a letter or already guesses.");
                continue;
            }

            
            // use a guess regardless if correct
            guessesLeft--;

            // reveal one instance if letter is in word
            if (letterCounts[guessedLetter - 'A'] > 0) {
                for (int i = 0; i < word.length; i++) {
                    if (word[i] == guessedLetter && hidden[i] == '*') {
                        hidden[i] = guessedLetter;
                        letterCounts[guessedLetter - 'A']--;
                        break;
                    }
                }
            }

            
            // if no more of that letter left, remove it from alphabet
            if (letterCounts[guessedLetter - 'A'] == 0) {
                for (int i = 0; i < alphabet.length; i++) {
                    if (alphabet[i] == guessedLetter) {
                        alphabet[i] = '*';
                        break;
                    }
                }
            }

            if (Arrays.equals(hidden, word)) {
                gameWon = true;
                break;
            }
        }

        
        
        // print end message
        if (gameWon) {
        	System.out.println("-------------------------------");
            System.out.println("\nCongratulations!!!");
            System.out.println("You guessed the mystery word \"" + inputWord + "\" in " + (10 - guessesLeft) + " guesses!");
        } else {
        	System.out.println("-------------------------------");
            System.out.println("\nSorry you didn't find the mystery word!");
            System.out.println("It was \"" + inputWord + "\"");
        }
        System.out.println("\nGoodbye ....");
        System.out.println("-------------------------------");
    }
}
