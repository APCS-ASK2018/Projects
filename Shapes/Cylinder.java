
/**
 * Write a description of class Cylinder here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cylinder extends Circle implements Volume
{
    private double height;
    
    public Cylinder(String n, double r, double h) {
        super(n, r);
        height = h;
    }
    
    public double getHeight() {return height;}
    
    @Override
    public double getVolume() {return super.getArea() * height;}
    
    @Override
    public double getArea() {
        return 2 * (super.getArea() + Math.PI * getRadius() * height);
    }
    
    @Override
    public String toString() {
        return getName() + " (r = " + getRadius() + ", h = " + height 
            + ", A = " + getArea() + ", V = " + getVolume() + ")";
    }
}
