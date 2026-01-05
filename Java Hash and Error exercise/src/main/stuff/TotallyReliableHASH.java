package main.stuff;

public class TotallyReliableHASH extends MyHash {

	
	public TotallyReliableHASH(String filename) {
		super(filename);
	}

	
	public void insert(String str) throws TooFullException {
		try {
			find(str);
		} catch (NotFoundException e) {
			put(e.getIndex(), str);
			incSize();
		}
	}

	
	protected String find(String str) throws NotFoundException, TooFullException {
		int index = hash(str);
		int tries = 0;
		while (++tries <= getTableSize() + 1) {
			if (get(index) == null)
				throw new NotFoundException(index);
			if (get(index).equals(str)) {
				return str;
			}
			index = (index + 1) % getTableSize();
		}
		throw new TooFullException(str);
	}

	
	protected int hash(String str) {
		int hash = 7;
		for (int i = 0; i < str.length(); i++) {
			hash = hash * 31 + str.charAt(i);
		}
		return Math.abs(hash) % getTableSize();
	}

	@Override
	protected int determineTableSize(int i) {
		return i;
	}
}
