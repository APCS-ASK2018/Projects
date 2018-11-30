
/**
 * Write a description of class Random here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MathRandom
{
    public static void run() {
        System.out.println("A random number");
        System.out.println( Math.random() );
        
        System.out.println("Random number from 0 - 9");
        System.out.println( (int) (Math.random() * 10) );
        
        System.out.println("Random number from 1 - 10");
        System.out.println( (int) (Math.random() * 10) + 1 );
    }
}
