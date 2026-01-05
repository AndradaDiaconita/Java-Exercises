package ass4;


/** Represents a book with a title, author, price, ISBN, genre, and year. */
public class Book {
	private String title;
    private String author;
    private double price;
    private long isbn;
    private String genre;
    private int year;

    
    /** 

    * Constructs a book object with the given title, author, price, ISBN, genre, and year.
    * @param title The title of the book.
    * @param author The author of the book.
    * @param price The price of the book.
    * @param ISBN The ISBN of the book.
    * @param genre The genre of the book.
    * @param year The year of the book.
    */
    public Book(String title, String author, double price, long ISBN, String genre, int year) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = ISBN;
        this.genre = genre;
        this.year = year;
    }
    /**

    Constructs a default book object with null values for all attributes.
    */
    public Book() {
		
	}

	/** getters and setters for all attributes */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getISBN() {
        return isbn;
    }

    public void setISBN(long ISBN) {
        this.isbn = ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Price: " + price + ", ISBN: " + isbn + ", Genre: " + genre + ", Year: " + year;
    }
}