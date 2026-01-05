package main.stuff;

public class TooFullException extends Exception {
	private String record;

	
	public TooFullException(String record) {
		super("Table too full to insert record: " + record);
		this.record = record;
	}

	
	public String getRecord() {
		return record;
	}
}
