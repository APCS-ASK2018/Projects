public class Car
{
    private String name;
    private int maxSpeed;
    private int mileage;
    //add constructor(s)
    public Car(String n, int maxS, int mile) {
        name = n;
        maxSpeed = maxS;
        mileage = mile;
    }
    
    
    
    //add mutator methods. Optional
    public void setMaxSpeed(int ms) {maxSpeed = ms;}
    public void setMileage(int m) {mileage = m;}
    public int getMaxSpeed() {return maxSpeed;}
    public int getMileage() {return mileage;}
    public String getName() {return name;}
    
    @Override
    public String toString() {
        return name + ": " + mileage + "km : " + maxSpeed + "km";
    }
}
