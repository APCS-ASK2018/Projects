
/**
 * Write a description of class BMW here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BMW extends Car
{
    public BMW(String n, int maxS, int mile) {
        super(n,maxS,mile);
    }
    
    @Override
    public String toString() {return "BMW " + super.toString();}
}
