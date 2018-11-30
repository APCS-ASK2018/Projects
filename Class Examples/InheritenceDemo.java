import static java.lang.System.*;
/**
 * Write a description of class ParseRomanNum here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InheritenceDemo extends Calculation
{
    public static void run() {
        int a = 20, b = 10;
        addition(a,b);
        subtraction(a,b);
        multiplication(a,b);
    }
    
    public static void multiplication(int x, int y) {
        z = x * y;
        out.println("The product of the given numbers: " + z);
    }
}

class Calculation {
    static int z;
    
    public static void addition(int x, int y) {
        z = x + y;
        out.println("The sum of the given numbers: " + z);
    }
    
    public static void subtraction(int x, int y) {
        z = x - y;
        out.println("The difference between the given numbers: " + z);
    }
}