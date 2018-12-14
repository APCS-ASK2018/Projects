
/**
 * Write a description of class Cube here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cube extends Square implements Volume
{
    public Cube(String n, double l) {
        super(n, l);
    }
    
    @Override
    public double getVolume() {return Math.pow( getLength(), 3 );}
    
    @Override
    public double getArea() {return 6 * super.getArea();}
    
    @Override
    public String toString() {
        return getName() + " (length = " + getLength() + ", A = " + getArea()
            + ", V = " + getVolume() + ")";
    }
}
