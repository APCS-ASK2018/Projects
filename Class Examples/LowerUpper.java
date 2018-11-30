
/**
 * Write a description of class Intervals here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LowerUpper
{
    public static void run() {
        final int lowerBound = 1;
        final int upperBound = 1000;
        
        int odds = sumOdd(lowerBound, upperBound);
        int evens = sumEven(lowerBound, upperBound);
        
        System.out.println("Sum of odds in [" + lowerBound + "," + upperBound + "] = " + odds);
        System.out.println("Sum of evens in [" + lowerBound + "," + upperBound + "] = " + evens);
        System.out.println("Odds - Evens = " + (odds - evens));
    }
    
    private static int sumOdd(int low, int up) {
        int sum = 0;
        
        for(int i = low ; i <= up ; i++) {
            if (i % 2 == 1)
                sum += i;
        }
        
        return sum;
    }
    
    private static int sumEven(int low, int up) {
        int sum = 0;
        
        for(int i = low ; i <= up ; i++) {
            if (i % 2 == 0)
                sum += i;
        }
        
        return sum;
    }
}
