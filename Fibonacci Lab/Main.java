
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    static java.util.Scanner KB = new java.util.Scanner(System.in);
    static boolean keepGoing = true;
    
    public static void main(String[] args) {
        do {
            System.out.println("Enter term or \"stop\": ");
            int nth = getNum();
            if(nth != -1) {
                int split = Fibonacci.fibSplit(nth);
                int tail = Fibonacci.fibTail(nth);
                System.out.println("Split: " + split);
                System.out.println("Tail: " + tail);
            }
        } while(keepGoing);
    }
    
    private static int getNum() {
        String input = KB.nextLine();
        keepGoing = !"stop".equalsIgnoreCase(input);
        if(!keepGoing) return -1;
        
        while(true)
            try {
                return Integer.parseInt(input);
            } catch(NumberFormatException e) {
                System.out.println("Enter a number: ");
                input = KB.nextLine();
            }
    }
}
