package Metros;

import Trains.Train;

import java.util.Objects;




/**
 * Metro class that extends Train class
 */
public class Metro extends Train {

    /**
     * The total number of stops for the Metro.
     */
    protected int totalNoOfStops;

    /**
     * The starting station of the Metro.
     */
    protected String startingStation;
    /**
     * The destination station of the Metro.
     */
    protected String destinationStation;

    /**
     * Constructor to initialize a Metro object with default values.
     */
    public Metro() {
        this.totalNoOfStops = 0;
        this.startingStation = null;
        this.destinationStation = null;
    }

    /**
     * Constructor to initialize a Metro object with the given parameters.
     *
     * @param totalNoOfStops     the total number of stops for the Metro
     * @param startingStation    the starting station of the Metro
     * @param destinationStation the destination station of the Metro
     */
    public Metro(int totalNoOfStops, String startingStation, String destinationStation) {
        this.totalNoOfStops = totalNoOfStops;
        this.startingStation = startingStation;
        this.destinationStation = destinationStation;
    }

    /**
     * Returns the total number of stops for the Metro.
     *
     * @return the total number of stops for the Metro
     */
    public int getTotalNoOfStops() {
        return totalNoOfStops;
    }

    /**
     * Sets the total number of stops for the Metro.
     *
     * @param totalNoOfStops the total number of stops for the Metro
     */
    public void setTotalNoOfStops(int totalNoOfStops) {
        this.totalNoOfStops = totalNoOfStops;
    }

    /**
     * Returns the starting station of the Metro.
     *
     * @return the starting station of the Metro
     */
    public String getStartingStation() {
        return startingStation;
    }

    /**
     * Sets the starting station of the Metro.
     *
     * @param startingStation the starting station of the Metro
     */
    public void setStartingStation(String startingStation) {
        this.startingStation = startingStation;
    }

    /**
     * Returns the destination station of the Metro.
     *
     * @return the destination station of the Metro
     */
    public String getDestinationStation() {
        return destinationStation;
    }

    /**
     * Sets the destination station of the Metro.
     *
     * @param destinationStation the destination station of the Metro
     */
    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    /**
     * Returns a string representation of the Metro object.
     *
     * @return a string representation of the Metro object
     */
    @Override
    public String toString() {
        return "Metro{" +
                "totalNoOfStops=" + totalNoOfStops +
                ", startingStation='" + startingStation + '\'' +
                ", destinationStation='" + destinationStation + '\'' +
                '}';
    }

    /**
     * Checks if two Metro objects are equal.
     *
     * @param o the object to compare with this Metro object
     * @return true if the two objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Metro metro = (Metro) o;
        return totalNoOfStops == metro.totalNoOfStops && Objects.equals(startingStation, metro.startingStation) && Objects.equals(destinationStation, metro.destinationStation);
    }

}
