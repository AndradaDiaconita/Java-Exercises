


public class Car extends Vehicle {
    
	// instance variable
    private int speed;

    // default constructor
    public Car() {
        super();
        // speed default 0
    }

    
    // constructor 
    public Car(int year, String make) {
        super(year, make);
        // speed default 0
    }

    
    // copy constructor
    public Car(Car other) {
        super(other.getYear(), other.getMake());
        this.speed = other.speed;
    }

    
    // accessor
    public int getSpeed() { 
    	return speed; 
    }

    
    // mutator
    public void setSpeed(int speed) { 
        this.speed = Math.max(0, speed); 
    }

    
    // must call parent's toString() to build exact format
    @Override
    public String toString() {
        return "Car " + super.toString() + ", current speed: " + speed;
    }

    
    // equals(Car) per spec
    public boolean equals(Car c) {
        if (c == null) return false;
        return super.equals(c) && this.speed == c.speed;
    }

    
    // accelerate(maximum speed limit)
    public void accelerate(int maxSpeed) {
        int next = this.speed + 20;
        if (next > maxSpeed) next = maxSpeed;
        this.speed = next;
    }

    
    
    @Override
    public void brake() {
        this.speed = Math.max(0, this.speed - 10);
    }

    
    // sameSpeed(Car) per spec
    public boolean sameSpeed(Car other) {
        if (other == null) return false;
        return this.speed == other.speed;
    }
}
