
/**
 * Write a description of class Volvo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Volvo extends Car
{
    public Volvo(String n, int maxS, int mile) {
        super(n,maxS,mile);
    }
    
    @Override
    public String toString() {return "Volvo " + super.toString();}
}
