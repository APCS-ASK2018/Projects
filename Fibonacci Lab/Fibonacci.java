
/**
 * Write a description of class Fibonacci here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fibonacci
{
    public static int fibSplit(int nth) {
        if(nth == 0) return 0;
        if(nth == 1) return 1;
        return fibSplit(nth - 1) + fibSplit(nth - 2);
    }
    
    public static int fibTail(int nth) {
        return fibTail(nth, 0, 1);
    }
    
    private static int fibTail(int nth, int fib1, int fib2) {
        if(nth == 0) return 0;
        if(nth == 1) return fib2;
        return fibTail(nth - 1, fib2, fib1 + fib2);
    }
}
