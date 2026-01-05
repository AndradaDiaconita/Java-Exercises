package Aircrafts;



/**
 * Aircraft class that extends WheeledTransportation class
 */
public class Aircraft {
    /**
     * The price of the aircraft
     */
    protected double price;
    /**
     * The maximum elevation that the aircraft can reach
     */
    protected double maximumElevation;

    /**
     * Default constructor for Aircraft class
     */
    public Aircraft(){
        this.price = 0;
        this.maximumElevation = 0;
    }

    /**
     * Parameterized constructor for Aircraft class
     * @param price the price of the aircraft
     * @param maximumElevation the maximum elevation that the aircraft can reach
     */
    public Aircraft(double price, double maximumElevation) {
        this.price = price;
        this.maximumElevation = maximumElevation;
    }

    /**
     * Getter for the price of the aircraft
     * @return the price of the aircraft
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for the price of the aircraft
     * @param price the new price of the aircraft
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter for the maximum elevation that the aircraft can reach
     * @return the maximum elevation that the aircraft can reach
     */
    public double getMaximumElevation() {
        return maximumElevation;
    }

    /**
     * Setter for the maximum elevation that the aircraft can reach
     * @param maximumElevation the new maximum elevation that the aircraft can reach
     */
    public void setMaximumElevation(double maximumElevation) {
        this.maximumElevation = maximumElevation;
    }

    /**
     * Returns a string representation of the Aircraft object
     * @return a string representation of the Aircraft object
     */
    @Override
    public String toString() {
        return "Aircraft{" +
                "price=" + price +
                ", maximumElevation=" + maximumElevation +
                '}';
    }

    /**
     * Checks whether the given object is equal to this Aircraft object
     * @param o the object to be compared with this Aircraft object
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return Double.compare(aircraft.price, price) == 0 && Double.compare(aircraft.maximumElevation, maximumElevation) == 0;
    }

    /**
     * Creates and returns a copy of this Aircraft object
     * @return a copy of this Aircraft object
     */
    public Aircraft Copy(){
        return new Aircraft(this.price, this.maximumElevation);
    }

}
