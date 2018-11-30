
/**
 * Write a description of class ArrayT here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayDemo
{
    public static void run() {
        int[] test = {3,3,5,5,6,7,7,83,2,4};
        
        ArrayDemo.printVal(test, false);
    }
    
    private static void printVal(int[] arr, boolean reverse) {
        if(reverse) {
            for(int i = arr.length - 1; i>=0 ; i--) {
                System.out.println(arr[i]);
            }
        } else {
            for(int i : arr) {
                System.out.println(i);
            }
        }
    }
}
