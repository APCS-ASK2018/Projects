
/**
 * Write a description of class Truck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Truck extends Vehicle
{
    public static final double costPoundPerMile = 50;
    private double cargo;
    
    /**
     * Overloaded constructor for Truck
     */
    public Truck() {
        this("Truck","Black",2016,0,200.0,97000.0);
    }
    public Truck(String model, String color, int year) {
        this(model, color, year, 0, 150.0, 80000.0);
    }
    public Truck(String model, String color, int year, int odometer, double gasCap, double cargo) {
        super(model, color, year, odometer, gasCap);
        this.cargo = cargo;
        if(cargo < 50000 || cargo > 100000)
            throw new RuntimeException("Cargo out of bounds!");
        if(gasCap < 125 || gasCap > 300)
            throw new RuntimeException("Gas capacity out of bounds!");
    }
    
    /**
     * @param miles Travelling distance
     * @returns Cost for transporting 100 pounds of cargo for @param
     */
    public double costPerHundred(int miles) {
        return 100 * costPoundPerMile * miles;
    }
    
    public double getCargo() {return cargo;}
    
    @Override
    public String honk() {
        return "BLLAAARRRRGGG";
    }
}
