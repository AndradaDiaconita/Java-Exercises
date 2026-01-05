package WheeledTransportaions;



/**
 * WheeledTransportation class that contains the number of wheels and maximum speed of the wheeled transportation.
 */
public class WheeledTransportation {
    /**
     * The number of wheels the wheeled transportation has.
     */
    protected int numberOfWheeles;
    /**
     * The maximum speed of the wheeled transportation.
     */
    protected double maximumSpeed;

    /**
     * Default constructor that initializes the number of wheels and maximum speed to 0.
     */

    public WheeledTransportation() {
        this.numberOfWheeles = 0;
        this.maximumSpeed = 0;
    }

    /**
     * Constructor that initializes the number of wheels and maximum speed to the provided values.
     * @param numberOfWheeles the number of wheels the wheeled transportation has
     * @param maximumSpeed the maximum speed of the wheeled transportation
     */

    public WheeledTransportation(int numberOfWheeles, double maximumSpeed) {
        this.numberOfWheeles = numberOfWheeles;
        this.maximumSpeed = maximumSpeed;
    }

    /**
     * Getter method to return the number of wheels the wheeled transportation has.
     * @return the number of wheels the wheeled transportation has
     */

    // getters and setters
    public int getNumberOfWheeles() {
        return numberOfWheeles;
    }

    /**
     * Setter method to set the number of wheels the wheeled transportation has to the provided value.
     * @param numberOfWheeles the new number of wheels the wheeled transportation has
     */

    public void setNumberOfWheeles(int numberOfWheeles) {
        this.numberOfWheeles = numberOfWheeles;
    }

    /**
     * Getter method to return the maximum speed of the wheeled transportation.
     * @return the maximum speed of the wheeled transportation
     */

    public double getMaximumSpeed() {
        return maximumSpeed;
    }

    /**
     * Setter method to set the maximum speed of the wheeled transportation to the provided value.
     * @param maximumSpeed the new maximum speed of the wheeled transportation
     */

    public void setMaximumSpeed(double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    /**
     * Override the equals method to return true if the provided object is equal to this object.
     * @param o the object to compare to this object
     * @return true if the provided object is equal to this object, false otherwise
     */

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WheeledTransportation that = (WheeledTransportation) o;
        return numberOfWheeles == that.numberOfWheeles && Double.compare(that.maximumSpeed, maximumSpeed) == 0;
    }

    /**
     * Override the tosString method to return a string representation of the wheeled transportation object.
     * @return a string representation of the wheeled transportation object
     */
    @Override
    public String toString() {
        return "WheeledTransportation has numberOfWheeles=" + numberOfWheeles + ", maximumSpeed=" + maximumSpeed + '}';
    }

    /**
     * is a copy method that returns a copy of the current object
     * @return a copy of the current object
     */
    public WheeledTransportation Copy(){
        return new WheeledTransportation(this.numberOfWheeles, this.maximumSpeed);
    }

}
