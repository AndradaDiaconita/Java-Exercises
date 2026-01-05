package Trams;

import Metros.Metro;

import java.util.Objects;




/**
 * Tram class that extends Metro class
 */
public class Tram extends Metro {
    /**
     * The year of creation of the Tram.
     */
    private int yearOfCreation;

    /**
     * Default constructor for Tram class
     * @param yearOfCreation the year of creation of the Tram
     */
    public Tram(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    /**
     * Parameterized constructor for Tram class
     * @param totalNoOfStops the total number of stops for the Tram
     * @param startingStation the starting station of the Tram
     * @param destinationStation the destination station of the Tram
     * @param yearOfCreation the year of creation of the Tram
     */

    public Tram(int totalNoOfStops, String startingStation, String destinationStation, int yearOfCreation) {
        super(totalNoOfStops, startingStation, destinationStation);
        this.yearOfCreation = yearOfCreation;
    }

    /**
     * Getter for the year of creation of the Tram
     * @return the year of creation of the Tram
     */

    // Getters and setters
    public int getYearOfCreation() {
        return yearOfCreation;
    }

    /**
     * Setter for the year of creation of the Tram
     * @param yearOfCreation the new year of creation of the Tram
     */

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    /**
     * Overridden toString method
     * @return the string representation of the Tram
     */
    @Override
    public String toString() {
        return "Tram has yearOfCreation=" + yearOfCreation + ", " + super.toString();
    }

    /**
     * Overridden equals method
     * @param o the object to be compared with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tram tram = (Tram) o;
        return yearOfCreation == tram.yearOfCreation;
    }


    public Tram Copy(){
        return new Tram(this.yearOfCreation, this.getStartingStation(), this.getDestinationStation(), this.getTotalNoOfStops());
    }

}