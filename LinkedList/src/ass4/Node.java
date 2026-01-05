package ass4;


/** A node in a linked list of Books. */
public class Node {
    private Book b;
    private Node next;

    /** 
	* Constructor for a new node with the specified Book object.
    * @param b the Book object to be stored in this node
    */
    public Node(Book b) {
        this.b = b;
        this.next = null;
    }

    /** getters and setters for all attributes */
    
    public Book getBook() {
        return b;
    }

    public void setBook(Book b) {
        this.b = b;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
