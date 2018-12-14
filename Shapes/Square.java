
/**
 * Write a description of class Square here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Square extends Shape implements Area
{
    private double length;
    
    public Square(String n, double l) {
        super(n);
        length = l;
    }
    
    public double getLength() {return length;}
    
    @Override
    public double getArea() {return length * length;}
    
    @Override
    public String toString() {
        return getName() + " (length = " + length + ", A = " + getArea() + ")";
    }
}
