
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Please input a balance in dollars");
        Scanner sc = new Scanner(System.in);
        
        while(!sc.hasNextDouble()) {
            System.out.println("Please input a valid numerical value!");
            sc.nextLine();
        }
        
        Balance bal = new Balance(sc.nextDouble());
        
        System.out.println(bal);
    }
}
