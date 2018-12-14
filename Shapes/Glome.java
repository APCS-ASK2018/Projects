
/**
 * Write a description of class Glome here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Glome extends Sphere implements Volume
{
    public Glome(String n, double r) {
        super(n, r);
    }

    @Override
    public double getVolume() {
        double r = getRadius();
        return 0.5 * Math.pow( Math.PI * r * r, 2);
    }
    
    @Override
    public double getArea() {return Double.NaN;}
}
