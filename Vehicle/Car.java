
/**
 * Write a description of class Car here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Car extends Vehicle implements Comparable, Safety
{   
    private int passengers;
    
    /**
     * Overloaded constructors with default values
     */
    public Car() {
        this("Car", "White", 2017, 0, 18.0, 5);
    }
    public Car(String model, String color, int year) {
        this(model, color, year, 0, 12.0, 4);
    }
    public Car(String model, String color, int year, int odometer, double gasCap, int passengers) {
        super(model, color, year, odometer, gasCap);
        this.passengers = passengers;
        if(gasCap < 12 || gasCap > 20)
            throw new RuntimeException("Gas capacity out of bounds!");
    }
    
    /**
     * Cost divided by passengers for a given miles
     */
    public double costPerPassenger(int miles) {
        double gas = miles / getMpg();
        return  gas * PRICE_PER_GALLON / passengers;
    }
    
    public int getPassengers() {return passengers;}
    
    @Override
    public String honk() {
        return "BLAARRGG";
    }
    
    /**
     * @param other Car class object to be compared with
     * @return this - that in terms of year and model name
     * @throws ClassCastException if @param is not instanceof Car
     */
    @Override
    public int compareTo(Object other) {
        Car that = (Car) other;
        int thisYr = getYear();
        int thatYr = that.getYear();
        String thisModel = getModel();
        String thatModel = that.getModel();
        
        if(thisYr != thatYr)
            return thisYr - thatYr;
        return thatModel.compareTo(thisModel); // String compareTo is that - this
    }
    
    @Override
    public int calculateSafety() {
        int miles = getOdometer();
        int mileScore = 0;
        if(miles <= 0)
            mileScore = 10;
        else if(miles < 100000)
            mileScore = miles / 10000;
        
        return getYear() - baseYr + mileScore;
    }
}
