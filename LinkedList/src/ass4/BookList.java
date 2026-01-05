package ass4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BookList {
	private Node head;

	public BookList() {
		head = null;
	}

	
	
	/**

	* Adds a new Node with the specified Book object to the beginning of the linked list.

	* @param book The Book object to be added.
	*/
	public void addToStart(Book book) {
		/** Create a new node with the specified book */
		Node newNode = new Node(book);
		/** If the linked list is empty, set the new node as head and set its next to itself */
		if (head == null) {
			head = newNode;
			newNode.setNext(head);
		} else {
			/* Find the last node in the linked list */
			Node lastNode = head;
			while (lastNode.getNext() != head) {
				lastNode = lastNode.getNext();
			}
			
			 /** Set the next node of the last node to the new node */
			lastNode.setNext(newNode);
			 /** Set the next node of the new node to the head */
			newNode.setNext(head);
			 /** Set the new node as the head */
			head = newNode;
		}
	}

	/**

	* Stores the book records that have a given year in a file named "yr.txt".

	* @param yr the year to filter the book records to store
	*/
	public void storeRecordsByYear(int yr) {
		/** Initialize the current node as the head and the flag variable as false */
		Node currNode = head;
	    boolean flag = false;

	    try {
	    	/** Create a new PrintWriter with the file name as "yr.txt" */
	        PrintWriter writer = new PrintWriter(yr + ".txt");
	        /** Traverse the linked list and check if the year of each book matches the specified year */
	        while (currNode.getNext() != head) {
	            if (currNode.getBook().getYear() == yr) {
	            	/** Get the book information as a string and write it to the file */
	                String bookString = currNode.getBook().toString();
	                writer.println(bookString);
	                /** Print the book information to the console */
	                System.out.println(bookString);
	                /** Set the flag variable to true since at least one record has been found */
	                flag = true;
	            }
	            currNode = currNode.getNext();
	        }
	        /** Close the PrintWriter */
	        writer.close();
	    } catch (IOException e) {
	    	/** Print the stack trace of the exception if it occurs */
	        e.printStackTrace();
	    }

	    /** If no records have been found for the specified year, print a message to the console */
	    if (!flag) {
	        System.out.println("No records found for year " + yr);
	    }
	    }

	
	/**

	* Inserts a new book with the given information before the book with the specified ISBN.

	* @param isbn the ISBN of the book to insert the new book before

	* @param b the new book to insert

	* @return true if the book with the specified ISBN is found and the new book is inserted; false otherwise
	*/
	public boolean insertBefore(long isbn, Book b) {
		/** Initialize the current node as the head and the previous node as null */
	    Node current = head;
	    Node previous = null;

	    /** Traverse the list to find the node with the given ISBN */
	    while (current != null && current.getBook().getISBN() != isbn) {
	        previous = current;
	        current = current.getNext();
	    }

	    /** If the node is found, insert the new node before it */
	    if (current != null) {
	    	/** Prompt the user for the new book's attributes and parse them from the input */
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter title, author, price, genre, and year separated by commas: ");
	        String[] attrs = sc.nextLine().split(",");
	        String title = attrs[0].trim();
	        String author = attrs[1].trim();
	        double price = Double.parseDouble(attrs[2].trim());
	        String genre = attrs[3].trim();
	        int year = Integer.parseInt(attrs[4].trim());

	        /** Create a new Book object with the parsed attributes */
	        Book newBook = new Book(title, author, price, isbn, genre, year);

	        /** Create a new node for the new book */
	        Node newNode = new Node(newBook);

	        /** Insert the new node */
	        if (previous == null) {
	            head = newNode;
	        } else {
	            previous.setNext(newNode);
	        }
	        newNode.setNext(current);

	        return true;
	    }

	    return false;
	}

	/**

	* Inserts a new node with the given Book object in between two nodes with the given ISBNs.

	* If no such nodes exist, returns false.

	* @param isbn1 the ISBN of the node before which the new node is to be inserted

	* @param isbn2 the ISBN of the node after which the new node is to be inserted

	* @param b the Book object to be inserted as a new node

	* @return true if insertion is successful, false otherwise
	*/
	public boolean insertBetween(long isbn1, long isbn2, Book b) {
	    Node current = head;
	    Node prev = null;

	 /** Traverse the list to find the node with the first ISBN, and the node with the second ISBN immediately after it */
	    while (current != null) {
	        if (prev != null && prev.getBook().getISBN() == isbn1 && current.getBook().getISBN() == isbn2) {
	        	/** Create a new node for the new book object and insert it between the two existing nodes */
	        	Node newNode = new Node(b);
	            prev.setNext(newNode);
	            newNode.setNext(current);
	            return true;
	        }
	        prev = current;
	        current = current.getNext();
	    }

	 /** If there is no node with the second ISBN, but there is a node with the first ISBN, insert the new book node at the end of the list */
	    if (prev != null && prev.getBook().getISBN() == isbn1 && current == null) {
	        Node newNode = new Node(b);
	        prev.setNext(newNode);
	        return true;
	    }

	 /** If there is no node with the first ISBN, but there is a node with the second ISBN, insert the new book node at the beginning of the list */
	    if (prev == null && current != null && current.getBook().getISBN() == isbn1) {
	        Node newNode = new Node(b);
	        newNode.setNext(current);
	        head = newNode;
	        return true;
	    }

	 /** If neither node with the specified ISBNs exists in the list, the new book node cannot be inserted */
	    return false;
	}

	/**

	* This method prints the contents of the circular linked list.

	* If the list is empty, a message will be printed indicating that.
	*/
	public void displayContent() {
		/* If the list is empty, print a message and return */
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        Node current = head;
        Node previous = null;
     /** Traverse the list and print each book's information */
        do {
        	
        	/** If the current node has a different book than the previous node,
            * print the book's details and an arrow pointing to the next node */
            if (previous == null || !current.getBook().equals(previous.getBook())) {
                System.out.println(current.getBook().toString() + " ==>");
            }

            previous = current;
            if (current.getNext() != null) {
                current = current.getNext();
            }
        } while (current.getNext() != head);

     /** Print an arrow pointing to the head node to indicate that the list is circular */
        System.out.println("===> head");
    }

	/**

	* This method removes consecutive repeated records from the linked list of books.

	* @return true if any consecutive repeated record is deleted, false otherwise.

	* If the list is empty, an error message is printed and false is returned.
	*/
	public boolean delConsecutiveRepeatedRecords() {
		/**
		* If the list is empty, print an error message and return false.
		*/
	    if (head == null) {
	        System.out.println("Error: List is empty.");
	        return false;
	    }
	 /** set the current node as the head */
	    Node currNode = head;

	    do {
	    	/** set the previous node as the current node */
	        Node prevNode = currNode;
	        /** set the current node as the next node */
	        Node current = currNode.getNext();

	     /** loop through the linked list until the end or a different book is found */
	        do {
	        	 /** if the current node has the same book as the current node, skip it */
	            if (current.getBook().toString().equals(currNode.getBook().toString())) {
	                current = current.getNext();
	                prevNode.setNext(current);
	            } else {
	            	/** set the current node and previous node to the next nodes */
	                currNode = currNode.getNext();
	                prevNode = prevNode.getNext();
	            }
	        } while (current != head && current.getBook().toString().equals(currNode.getBook().toString()));

	     /** set the current node to the next node */
	        currNode = currNode.getNext();
	    } while (currNode.getNext() != head);

	 /** if the first two nodes have the same book, skip the first node */
	    if (head.getBook().toString().equals(head.getNext().getBook().toString())) {
	        head = head.getNext().getNext();
	    }

	    /**
	     * Print a message to indicate that consecutive files are deleted and return true.
	     */
	    System.out.println("Consecutive files deleted");
	    return true;
	}

	/**
	 * This method extracts a list of books that have a specified author.
	 * @param aut the name of the author to search for.
	 * @return a new BookList object that contains all books with the specified author.
	*/
	public BookList extractAuthList(String aut) {
		Node curr = head;
		/** create a new BookList object to store the books with the specified author */
		BookList authorList = new BookList();
		/** loop through the linked list until the last node */
		do {
			/** if the current node has the specified author, add it to the author list */
			if (curr.getBook().getAuthor().equals(aut)) {
				Book bookToAdd = curr.getBook();
				authorList.addToStart(bookToAdd);
			}
			curr = curr.getNext();
		} while (curr != head);
		
		/** Return the author list containing all books with the specified author.*/
		return authorList;
	}

	/** 

	* This method swaps the position of two nodes in the linked list based on the given ISBNs.

	* @param isbn1 the ISBN of the first book node to swap.

	* @param isbn2 the ISBN of the second book node to swap.

	* @return true if the swap was successful, false otherwise.
	*/
	public boolean swap(long isbn1, long isbn2) {
		/** if the linked list is empty or has only one element, return false */
	    if (head == null || head.getNext() == null) {
	        // List is empty or has only one element
	        return false;
	    }

	    /**  find the first node to swap */
	    Node prev1 = null;
	    Node node1 = head;
	    while (node1 != null && node1.getBook().getISBN() != isbn1) {
	        prev1 = node1;
	        node1 = node1.getNext();
	    }

	    Node prev2 = null;
	    Node node2 = head;
	    while (node2 != null && node2.getBook().getISBN() != isbn2) {
	        prev2 = node2;
	        node2 = node2.getNext();
	    }

	    /** if either ISBN1 or ISBN2 not found, return false */
	    if (node1 == null || node2 == null) {
	        // Either ISBN1 or ISBN2 not found
	        return false;
	    }

	    Book tempBook = node1.getBook();
	    node1.setBook(node2.getBook());
	    node2.setBook(tempBook);

	    return true;
	}

	/** 

	* Writes the current state of the BookList to a file called "Update_Books.txt" in the same directory.

	* If the list is empty, writes "Head is null" to the file.

	* Otherwise, writes each book in the list to the file in the following format:

	* Title, Author, Price, ISBN, Genre, Year

	* Each book is separated by a new line character.

	* If an error occurs while opening the file, prints an error message to the console.
	*/
	public void commit() {
		try (PrintWriter P = new PrintWriter(new FileOutputStream("Update_Books.txt", true))) {
			/** if the head is empty , return head is null */
			if (this.head == null) {
				P.println("Head is null");
			} else {
				Node temp = this.head;
				P.println("\n New Commit: \n");
				while (temp.getNext() != head) {
					Book book = temp.getBook();
					P.println(book.getTitle() + ", " + book.getAuthor() + ", " + book.getPrice() + ", " + book.getISBN()
							+ ", " + book.getGenre() + ", " + book.getYear());
					temp = temp.getNext();

				}
				Book book = temp.getBook();
				P.println(book.getTitle() + ", " + book.getAuthor() + ", " + book.getPrice() + ", " + book.getISBN()
						+ ", " + book.getGenre() + ", " + book.getYear());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file: " + e.getMessage());
		}
	}

}