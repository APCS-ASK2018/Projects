package Helper;

import java.util.Scanner;
import static Helper.Console.*;
import Helper.*;

/**
 * Centralize user input handling
 * Always convert input to lowercase and trim
 * 
 * @throws Exception when user types "Quit" (case insensitive)
 * Exception is used to immediately terminate the game and return to main method
 */
public class Kb
{
    private static Scanner kb = new Scanner(System.in);
    private static String[] truthy = {"true","t","yes","y","1"};
    private static String[] falsy = {"false","f","no","n","0"};
    
    public static String readInputNoQuit(String msg) {
        String input = kb.nextLine().trim().toLowerCase();
        while(input.equals("quit")) {
            print(msg);
            input = kb.nextLine().trim().toLowerCase();
        }
        return input;
    }
    
    public static String readInput() throws Exception {
        String input = kb.nextLine().trim().toLowerCase();
        if(input.equals("quit"))
            throw new Exception("Quit");
        return input;
    }
    
    public static boolean readBool() throws Exception {
        String input;
        while(true) {
            input = readInput();
            if(Util.arrayContains(truthy,input)) return true;
            if(Util.arrayContains(falsy,input)) return false;
        }
    }
    
    public static String readString(String[] strings) throws Exception {
        String input;
        while(true) {
            input = readInput();
            for(String str : strings) {
                if(str.toLowerCase().equals(input))
                    return str;
            }
        }
    }
}
