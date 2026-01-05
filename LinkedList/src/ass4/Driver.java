package ass4;

import java.io.*;
import java.util.*;

public class Driver {
	public static void main(String[] args) {

		ArrayList<Book> arrLst = new ArrayList<Book>();
		BookList bkLst = new BookList();

		// Read contents of Book.txt file and initialize ArrayList and BookList objects
		try (BufferedReader br = new BufferedReader(new FileReader("Books.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				String title = values[0];
				String author = values[1];
				double price = Double.parseDouble(values[2]);
				long isbn = Long.parseLong(values[3]);
				String genre = values[4];
				int year = Integer.parseInt(values[5]);

				Book b = new Book(title, author, price, isbn, genre, year);
				arrLst.add(b);
				if (year >= 1900 && year <= 2024) {
					bkLst.addToStart(b);
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return;
		}

		try {
			BufferedWriter writer = null;
			boolean hasInvalidYears = false;
			for (Book b : arrLst) {
				if (b.getYear() < 1900 || b.getYear() > 2024) {
					hasInvalidYears = true;
					if (writer == null) {
						writer = new BufferedWriter(new FileWriter("YearErr.txt"));
					}
					writer.write(b.toString());
					writer.newLine();
				}
			}
			if (hasInvalidYears) {
				writer.close();
			}
		} catch (IOException e) {
			System.out.println("Error creating file: " + e.getMessage());
		}

		try (// Display menu options to user
				Scanner scanner = new Scanner(System.in)) {
			int userInput = 0;
			while (userInput != 8) {
				System.out.println("\nPlease select an option:");
				System.out.println(
						"1) Give me a year # and I would extract all records of that year and store them in a file for that year");
				System.out.println("2) Ask me to delete all consecutive repeated records");
				System.out.println(
						"3) Give me an author name and I will create a new list with the records of this author and display them");
				System.out.println(
						"4) Give me an ISBN number and a Book object, and I will insert Node with the book before the record with this ISBN");
				System.out.println(
						"5) Give me 2 ISBN numbers and a Book object, and I will insert a Node between them, if I find them!");
				System.out.println(
						"6) Give me 2 ISBN numbers and I will swap them in the list for rearrangement of records; of course if they exist!");
				System.out.println(
						"7) Tell me to COMMIT! Your command is my wish. I will commit your list to a file called Updated_Books");
				System.out.println("8) Tell me to STOP TALKING. Remember, if you do not commit, I will not!");
				userInput = scanner.nextInt();
				scanner.nextLine(); // Consume the newline character

				switch (userInput) {
				case 1:
					System.out.print("Enter the year number: ");
					int year = scanner.nextInt();
					scanner.nextLine(); // consume the newline character
					bkLst.storeRecordsByYear(year);
					break;

				case 2:
					bkLst.delConsecutiveRepeatedRecords();
					bkLst.displayContent();
					break;

				case 3:
					System.out.print("Enter the author name: ");
					String author = scanner.nextLine();
					BookList authorLst = bkLst.extractAuthList(author);
					System.out.println("Books by " + author + ":");
					authorLst.displayContent();
					break;

				case 4:
					System.out.print("Enter the ISBN number: ");
					long isbn = scanner.nextLong();
					scanner.nextLine();
					Book bk = new Book();
					bkLst.insertBefore(isbn, bk);
					bkLst.displayContent();
					break;

				case 5:
				    System.out.print("Enter the ISBN number of the first book: ");
				    long isbn1 = scanner.nextLong();
				    System.out.print("Enter the ISBN number of the second book: ");
				    long isbn2 = scanner.nextLong();
				    System.out.print("Enter title, author, price, genre, and year separated by commas: ");
				    scanner.nextLine(); // consume newline character
				    String[] attrs = scanner.nextLine().split(",");
				    String title = attrs[0].trim();
				    author = attrs[1].trim();
				    double price = Double.parseDouble(attrs[2].trim());
				    String genre = attrs[3].trim();
				    year = Integer.parseInt(attrs[4].trim());
				    Book bk2 = new Book(title, author, price, 0, genre, year); // initialize with default ISBN value of 0
				    if (bkLst.insertBetween(isbn1, isbn2, bk2)) {
				        System.out.println("Book Inserted!");
				    }
				    else {
				        System.out.println("Not inserted");
				    }
				    bkLst.displayContent();
				    break;

				case 6:
					System.out.print("Enter the ISBN number of the first book: ");
				    long isbn3 = scanner.nextLong();
				    System.out.print("Enter the ISBN number of the second book: ");
				    long isbn4 = scanner.nextLong();

				    if (bkLst.swap(isbn3, isbn4)) {
				        System.out.println("Books swapped successfully!");
				    } else {
				        System.out.println("Unable to swap books.");
				    }

				    bkLst.displayContent();
				    break;

				case 7:
					bkLst.commit();
					System.out.println("Changes have been committed to file Updated_Books.");
					bkLst.displayContent();
					break;

				case 8:
					System.out.println("Exiting program. Don't forget to commit your changes!");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid option. Please select an option between 1-8.");
					break;
				}
			}
		}
	}
}
