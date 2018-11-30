

public class GCD
{
    /**
     * Euclidian algorithm
     * for GCD k
     * ak = bk + rk where a > b > r and relative prime to each other
     * ==> GCD between ak and bk == GCD between bk and rk
     */
    public static int getGCD( int num1, int num2 )
    {
        if (num1 < num2)
            return getGCD(num2 , num1);
        
        int modResult = num1 % num2;
        if (modResult == 0)
            return num2;
        
        return getGCD(num2, modResult);
    }
}