
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
        Scanner sc = new Scanner(System.in);
        System.out.println("First name: ");
        String firstName = sc.nextLine();
        
        System.out.println("Last name: ");
        String lastName = sc.nextLine();
        
        System.out.println("Birthday (MMDDYY)");
        String birthday = "";
        
        while(sc.hasNextLine()) {
            birthday = sc.nextLine();
            if(birthday.matches("[0-9]{6}")) {
                break;
            } else {
                System.out.println("Input valid date as numbers only");
            }
        }
        
        System.out.println( makeUsername(firstName,lastName,birthday) );
    }
    
    public static String makeUsername(String first, String last, String birth) {
        return first.substring(0,2) + last.substring(last.length()-3) + birth.substring(2,4);
    }
}
