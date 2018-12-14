
/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle extends Shape implements Area
{
    private double radius;
    
    public Circle(String n, double r) {
        super(n);
        radius = r;
    }
    
    public double getRadius() {return radius;}
    
    @Override
    public double getArea() {return Math.PI * radius * radius;}
    
    @Override
    public String toString() {
        return getName() + " (r = " + radius + ", A = " + getArea() + ")";
    }
}
