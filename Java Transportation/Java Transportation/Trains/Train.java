package Trains;
import WheeledTransportaions.WheeledTransportation;

import java.util.Objects;



/**
 * Train class that extends WheeledTransportation class
 * @author 2021
 */
public class Train extends WheeledTransportation {

    /**
     * The number of vehicles in the train
     */
    protected int noOfVehicles;
    /**
     * The starting station of the train
     */

    // The starting station of the train
    protected String startingStations;
    /**
     * The destination of the train
     */

    // The destination of the train
    protected String destination;
    /**
     * Default constructor that initializes the number of vehicles, starting station, and destination to 0, null, and null respectively.
     */
    public Train() {
        this.noOfVehicles = 0;
        this.startingStations = null;
        this.destination = null;
    }

    /**
     * Constructor that initializes the number of vehicles, starting station, and destination to the provided values.
     * @param noOfVehicles the number of vehicles in the train
     * @param startingStations the starting station of the train
     * @param destination the destination of the train
     */

    public Train(int noOfVehicles, String startingStations, String destination) {
        this.noOfVehicles = noOfVehicles;
        this.startingStations = startingStations;
        this.destination = destination;
    }

    /**
     * Getter for the number of vehicles in the train
     * @return the number of vehicles in the train
     */
    public int getNoOfVehicles() {
        return noOfVehicles;
    }

    /**
     * Setter for the number of vehicles in the train
     * @param noOfVehicles the number of vehicles in the train
     */

    public void setNoOfVehicles(int noOfVehicles) {
        this.noOfVehicles = noOfVehicles;
    }

    /**
     * Getter for the starting station of the train
     * @return the starting station of the train
     */
    public String getStartingStations() {
        return startingStations;
    }

    /**
     * Setter for the starting station of the train
     * @param startingStations the starting station of the train
     */
    public void setStartingStations(String startingStations) {
        this.startingStations = startingStations;
    }

    /**
     * Getter for the destination of the train
     * @return the destination of the train
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Setter for the destination of the train
     * @param destination the destination of the train
     */

    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Override the toString method to return a string representation of the Train object
     * @return a string representation of the Train object
     */

    @Override
    public String toString() {
        return "Train{" +
                "noOfVehicles=" + noOfVehicles +
                ", startingStations='" + startingStations + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    /**
     * Override the equals method to check if two Train objects are equal based on their instance variables
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Train train = (Train) o;
        return noOfVehicles == train.noOfVehicles && Objects.equals(startingStations, train.startingStations) && Objects.equals(destination, train.destination);
    }

    public Train Copy(){
        return new Train(this.noOfVehicles, this.startingStations, this.destination);
    }

}