/**
 * Provide shortcut for controlling console output
   */

package Helper;

public class Console
{
    public static void print() {
        print("");
    }
    
    public static void print(Object obj) {
        System.out.println(obj);
    }
    
    public static void clear() {
        for(int i = 0 ; i < 30 ; i++)
            System.out.println();
    }
    
    public static void sleep(int millisecond) {
        try{
            Thread.sleep(millisecond);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
