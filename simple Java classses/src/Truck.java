


public class Truck extends Vehicle {
    
	// instance variable
    private int speed;

    // default constructor
    public Truck() {
        super();
        // speed default 0
    }

    
    // constructor
    public Truck(int year, String make, int speed) {
        super(year, make);
        this.speed = Math.max(0, speed);
    }

    
    // accessor
    public int getSpeed() { 
    	return speed; 
    }

    
    // mutator
    public void setSpeed(int speed) { 
        this.speed = Math.max(0, speed); 
    }

    
    // must call parent's toString() to build exact way
    @Override
    public String toString() {
        return "Truck " + super.toString() + ", current speed: " + speed;
    }

    
    // accelerate maximum speed limit
    public void accelerate(int maxSpeed) {
        int next = this.speed + 10;
        if (next > maxSpeed) next = maxSpeed;
        this.speed = next;
    }

    

    @Override
    public void brake() {
        this.speed = Math.max(0, this.speed - 5);
    }
}
