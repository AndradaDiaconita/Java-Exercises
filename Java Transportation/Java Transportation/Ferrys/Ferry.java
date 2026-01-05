package Ferrys;
import java.util.Objects;


/**
 * Ferry class that extends WheeledTransportation class
 */
public class Ferry {
    private double maximumSpeed;  // Maximum speed of the ferry
    private double maximumLoad;  // Maximum load (in weight) the ferry can carry

    /**
     * Default constructor that initializes the maximum speed and maximum load to 0.
     */
    public Ferry() {
        this.maximumLoad = 0;
        this.maximumSpeed = 0;
    }

    /**
     * Constructor that initializes the maximum speed and maximum load to the provided values.
     * @param maximumSpeed the maximum speed of the ferry
     * @param maximumLoad the maximum load (in weight) the ferry can carry
     */
    public Ferry(double maximumSpeed, double maximumLoad) {
        this.maximumSpeed = maximumSpeed;
        this.maximumLoad = maximumLoad;
    }

    /**
     * Getter method to return the maximum speed of the ferry.
     * @return the maximum speed of the ferry
     */
    public double getMaximumSpeed() {
        return maximumSpeed;
    }

    /**
     * Setter method to set the maximum speed of the ferry to the provided value.
     * @param maximumSpeed the new maximum speed of the ferry
     */
    public void setMaximumSpeed(double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    /**
     * Getter method to return the maximum load (in weight) the ferry can carry.
     * @return the maximum load (in weight) the ferry can carry
     */
    public double getMaximumLoad() {
        return maximumLoad;
    }

    /**
     * Setter method to set the maximum load (in weight) the ferry can carry to the provided value.
     * @param maximumLoad the new maximum load (in weight) the ferry can carry
     */
    public void setMaximumLoad(double maximumLoad) {
        this.maximumLoad = maximumLoad;
    }

    /**
     * Override the toString method to return a string representation of the Ferry object.
     * @return a string representation of the Ferry object
     */
    @Override
    public String toString() {
        return "Ferry{" +
                "maximumSpeed=" + maximumSpeed +
                ", maximumLoad=" + maximumLoad +
                '}';
    }

    /**
     * Override the equals method to check if two Ferry objects are equal.
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ferry ferry = (Ferry) o;
        return Double.compare(ferry.maximumSpeed, maximumSpeed) == 0 && Double.compare(ferry.maximumLoad, maximumLoad) == 0;
    }

    /**
     * Create a new Ferry object with the same maximum speed and maximum load as the current object.
     * @return a new Ferry object with the same maximum speed and maximum load as the current object
     */
    public Ferry Copy(){
        return new Ferry(this.maximumSpeed, this.maximumLoad);
    }

}