package MonoWheels;
import WheeledTransportaions.WheeledTransportation;

import java.util.Objects;



/**
 * MonoWheel class that extends WheeledTransportation class
 */
public class MonoWheel extends WheeledTransportation {
    private double maximumWeight; // the maximum weight the MonoWheel can carry

    /**
     * Default constructor that initializes the maximum weight to 0.
     */
    public MonoWheel() {
        this.maximumWeight = 0;
    }

    /**
     * Constructor that initializes the maximum weight to the provided value.
     * @param maximumWeight the maximum weight the MonoWheel can carry.
     */
    public MonoWheel(double maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    /**
     * Getter method to return the maximum weight the MonoWheel can carry.
     * @return the maximum weight the MonoWheel can carry.
     */
    public double getMaximumWeight() {
        return maximumWeight;
    }

    /**
     * Setter method to set the maximum weight the MonoWheel can carry to the provided value.
     * @param maximumWeight the maximum weight the MonoWheel can carry.
     */
    public void setMaximumWeight(double maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    /**
     * Override the toString method to return a string representation of the MonoWheel object.
     * @return a string representation of the MonoWheel object.
     */
    @Override
    public String toString() {
        return "MonoWheel{" +
                "maximumWeight=" + maximumWeight +
                '}';
    }

    /**
     * Override the equals method to check if two MonoWheel objects are equal.
     * @param o the object to compare.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MonoWheel monoWheel = (MonoWheel) o;
        return Double.compare(monoWheel.maximumWeight, maximumWeight) == 0;
    }

    /**
     * Create a new MonoWheel object with the same maximum weight as the current object.
     * @return a new MonoWheel object with the same maximum weight as the current object.
     */
    public MonoWheel Copy(){
        return new MonoWheel(this.maximumWeight);
    }

}