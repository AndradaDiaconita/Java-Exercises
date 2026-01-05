package main.stuff;


public class NotFoundException extends Exception {
	private int index;

	public NotFoundException(int index) {
		super("No element found at index: " + index);
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}
