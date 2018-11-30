
/**
 * Write a description of class Vehicle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vehicle
{
    private String type;
    private int age;
    private int milepyr = 1200;
    
    public Vehicle(String type, int age) {
        this.type = type;
        this.age = age;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public int getMileAge() {
        return this.age * this.milepyr;
    }
    
    public String toString() {
        return "Vehicle\n\ttype: " + this.type + "\n\tage: " + this.age;
    }
}
