package comp352.assignment4;

import java.io.File;
import main.stuff.MyHash;
import main.stuff.NotFoundException;
import main.stuff.TooFullException;




public class HashMaster extends MyHash {
	 // Constructor should handle possible exceptions related to the filename parameter
    public HashMaster(String filename) throws IllegalArgumentException {
        super(filename);
        if (filename == null || !fileExists(filename)) {
            throw new IllegalArgumentException("Invalid filename provided");
        }
    }
    
    // Check if a file exists
    protected boolean fileExists(String filename) {
        File file = new File(filename);
        return file.exists();
    }

    @Override
    public void insert(String str) throws TooFullException {
        int index = theFind(str);
        if (index != -1) {
        	put(index,str); // Insert the key at the found index
        	incSize(); // Increment the size of the hash table
        }
    }
    
 // Find an empty slot for insertion or determine if the key already exists
    private int theFind(String str) throws TooFullException {
        int index = hash(str); // Calculate the hash index for the key
        int tries = 0;
        int step = 1; // Step size for quadratic probing
        while (++tries <= getTableSize()) {
            if (get(index) == null) {
                return index; // Empty slot found, return index
            }
            if (get(index).equals(str)) {
                return -1; // Key already exists, return -1
            }
            index = (index + (step * step)) % (getTableSize());
            step++;
        }
        throw new TooFullException(str); // No empty slot found, table is full
    }

    protected String find(String str) throws NotFoundException, TooFullException {
        int index = hash(str);
        int tries = 0;
        int step = 1;
        while (++tries <= getTableSize()) {
            if (get(index) == null) {
                throw new NotFoundException(index); // Key not found
            }
            if (get(index).equals(str)) {
                return str; // Key found
            }
            index = (index + step * step) % getTableSize(); // Quadratic probing
            step++;
        }
        throw new TooFullException(str); // No empty slot found, table is full
    }

   
    protected int hash(String str) {
        final int offset = 0x811c9dc5; // Initial hash offset value
        final int prime = 0x01000193; // Prime constant used for hashing

        int hash = offset; // Initialize the hash value with the offset
        for (int i = 0; i < str.length(); i++) {
            hash ^= str.charAt(i); // XOR the current character with the hash value
            hash *= prime; // Multiply the hash value by the prime constant
        }
        
    
        
        return Math.abs(hash) % getTableSize(); // Map the hash value to the index within the table size adn return
    }


    // Override the determineTableSize method to provide a better default table size
    @Override
    protected int determineTableSize(int i) {
        return (int) (i); // Adjust the table size based on the input size
    }
	

}
