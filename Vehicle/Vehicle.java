
/**
 * Write a description of class Vehicle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Vehicle
{
    public final static double PRICE_PER_GALLON = 1.91;
    
    private String model, color;
    private int year, odometer;
    private double gasCapacity, gasRemaining;
    private double mpg = 1;
    
    /**
     * Initialize instance fields with parameter
     */
    public Vehicle(String model, String color, int year, int odometer, double gasCap) {
        this.model = model;
        this.color = color;
        this.year = year;
        this.odometer = odometer;
        gasCapacity = gasCap;
    }
    
    /**
     * Mpg = miles per gas
     * @throws ArithmaticException - division by 0
     */
    public void calculateMpg(int miles, double gas) {
        mpg = miles / gas;
    }

    
    /**
     * @param gas Amount of gas to add
     * @return true if successfully added
     * @return false if negative gas or tank would've overflown
     */
    public boolean addGas(double gas) {
        if(gas < 0 || gas > gasCapacity - gasRemaining )
            return false;
        
        gasRemaining += gas;
        return true;
    }
    
    /**
     * Fill the tank to max
     * @return Amount of gas that was added
     */
    public double fillTank() {
        double toFill = gasCapacity - gasRemaining;
        gasRemaining = gasCapacity;
        return toFill;
    }
    
    /**
     * @return Max distance vehicle can travel for its mpg and gas left
     */
    public double range() {
        return gasRemaining * mpg;
    }
    
    /**
     * Consume gas to travel
     * @param miles Distance to drive (If above gas limit, then up to max miles)
     * @return Amount of gas used
     */
    public double drive(int miles) {
        int maxMiles = (int) range();
        int actualMiles = (miles < maxMiles) ? miles : maxMiles;
        double gasUsed = actualMiles / mpg;
        
        odometer += actualMiles;
        gasRemaining -= gasUsed;
        return gasUsed;
    }
    
    @Override
    public String toString() {
        return "Year: " + year + " | Color: " + color + " | Model: " + model;
    }
    
    public int getOdometer() {return odometer;}
    public double getGasRemaining() {return gasRemaining;}
    public double getGasCapacity() {return gasCapacity;}
    public double getMpg() {return mpg;}
    public int getYear() {return year;}
    public String getModel() {return model;}
    
    /**
     * Child class should implement method according to horn sound
     */
    public abstract String honk();
}
