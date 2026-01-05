


public class Vehicle {
	
    // instance variables must be private
    private int year;
    private String make;

    
    // default constructor
    public Vehicle() {
        // leave defaults 0, null per spec
    }

    // constructor
    public Vehicle(int year, String make) {
        this.year = year;
        this.make = make;
    }

    // copy constructor
    public Vehicle(Vehicle other) {
        this.year = other.year;
        this.make = other.make;
    }

    
    // accessors
    public int getYear() { 
    	return year; 
    }
    
    public String getMake() { 
    	return make; 
    }

    
    // mutators
    public void setYear(int year) { 
    	this.year = year; 
    }
    
    public void setMake(String make) { 
    	this.make = make; 
    }

    
    
    // toString per spec
    @Override
    public String toString() {
        return "year: " + year + ", make: " + make;
    }

    
    
    // equals(Vehicle) per spec
    public boolean equals(Vehicle v) {
        if (v == null) return false;
        if (this.year != v.year) return false;
        if (this.make == null) return v.make == null;
        return this.make.equals(v.make);
    }

    
    
    // brake() in base does nothing (for polymorphism)
    public void brake() {
        // left empty
    }
}
