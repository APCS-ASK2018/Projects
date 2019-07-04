package Helper;

import java.util.concurrent.TimeUnit;

/**
 * Provide various methods that are not built into java
   */
public class Util
{
    public static int arrayIndexOf(Object[] arr, Object searchTarget) {
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i].equals(searchTarget))
                return i;
        }
        return -1;
    }
    
    public static boolean arrayContains(Object[] arr, Object searchTarget) {
        return arrayIndexOf(arr, searchTarget) != -1;
    }
}
