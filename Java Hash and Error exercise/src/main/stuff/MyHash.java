package main.stuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class MyHash {
	private String[] table;
	private int size = 0;

	
	public boolean isFull() {
		return size == table.length;
	}

	
	public int getTableSize() {
		return table.length;
	}

	
	public void incSize() {
		++size;
	}

	
	public int getSize() {
		return size;
	}

	
	public MyHash(String filename) {
		super();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(System.getProperty("user.dir"), filename).getAbsolutePath()));
			String line;
			int totalsize = 0;

			// Count the number of non-empty lines in the file
			while ((line = reader.readLine()) != null) {
				String str = line.trim();
				if (!str.isEmpty()) {
					totalsize++;
				}
			}

			// Create the hash table
			System.out.println("Our hash table will be " + determineTableSize(totalsize) + " long for " + totalsize
					+ " elements.");
			this.table = new String[determineTableSize(totalsize)];
			reader.close();
			reader = new BufferedReader(new FileReader(new File(System.getProperty("user.dir"), filename).getAbsolutePath()));
			while ((line = reader.readLine()) != null) {
				String str = line.trim();
				if (str.isEmpty())
					continue;
				insert(str);
			}

			reader.close();
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		} catch (TooFullException e) {
			System.err.println("Error filling hash table: " + e.getMessage());
			e.printStackTrace();
		}
	}

	
	protected String get(int index) {
		return table[index];
	}

	protected void put(int index, String record) {
		table[index] = record;
	}

	
	abstract protected int hash(String str);

	abstract protected String find(String str) throws NotFoundException, TooFullException;

	abstract protected void insert(String str) throws TooFullException;

	
	abstract protected int determineTableSize(int i);

}
