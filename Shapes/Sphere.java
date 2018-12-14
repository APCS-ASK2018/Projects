
/**
 * Write a description of class Sphere here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sphere extends Circle implements Volume
{
    public Sphere(String n, double r) {
        super(n, r);
    }
    
    @Override
    public double getVolume() {return 4 * Math.PI * Math.pow(getRadius(), 3) / 3;}
    
    @Override
    public double getArea() {return 4 * Math.PI * getRadius() * getRadius();}
    
    @Override
    public String toString() {
        return getName() + " (r = " + getRadius() + ", A = " + getArea()
            + ", V = " + getVolume() + ")";
    }
}
