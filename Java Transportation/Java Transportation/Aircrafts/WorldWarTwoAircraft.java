package Aircrafts;



/**
 * Class representing a World War Two aircraft.
 * Extends the Aircraft class.
 */
public class WorldWarTwoAircraft extends Aircraft {
    private boolean twinEngine;

    /**
     * Default constructor for WorldWarTwoAircraft class.
     * Sets price and maximum elevation to 0 and twinEngine to false.
     */
    public WorldWarTwoAircraft(){
        super(0, 0);
        this.twinEngine = false;
    }

    /**
     * Parameterized constructor for WorldWarTwoAircraft class.
     * @param price - price of the aircraft
     * @param maximumElevation - maximum elevation the aircraft can reach
     * @param twinEngine - whether the aircraft has twin engines or not
     */
    public WorldWarTwoAircraft(double price, double maximumElevation, boolean twinEngine) {
        super(price, maximumElevation);
        this.twinEngine = twinEngine;
    }

    /**
     * Getter for the twinEngine attribute of the WorldWarTwoAircraft object.
     * @return - true if the aircraft has twin engines, false otherwise
     */
    public boolean isTwinEngine() {
        return twinEngine;
    }

    /**
     * Setter for the twinEngine attribute of the WorldWarTwoAircraft object.
     * @param twinEngine - boolean value indicating whether the aircraft has twin engines or not
     */
    public void setTwinEngine(boolean twinEngine) {
        this.twinEngine = twinEngine;
    }

    /**
     * String representation of the WorldWarTwoAircraft object.
     * @return - a string containing the twinEngine attribute of the object
     */
    @Override
    public String toString() {
        return "WorldWarTwoAircraft{" +
                "twinEngine=" + twinEngine +
                '}';
    }

    /**
     * Equality check for WorldWarTwoAircraft objects.
     * @param o - the object to be compared
     * @return - true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorldWarTwoAircraft that = (WorldWarTwoAircraft) o;
        return twinEngine == that.twinEngine;
    }

    /**
     * Creates a copy of the current WorldWarTwoAircraft object.
     * @return - a new WorldWarTwoAircraft object with the same price, maximum elevation, and twin engine attribute
     */
    public WorldWarTwoAircraft Copy(){
        return new WorldWarTwoAircraft(this.getPrice(), this.getMaximumElevation(), this.twinEngine);
    }
}
