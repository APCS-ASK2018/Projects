import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class QuadraticRunner
{
    public static void main( String[] args )
    {
        final int[][] COEFF_TESTS = {
            {5, -8, 3},
            {3, 2, -7},
            {9, 6, 1},
            {1, 2, 2}
        };
        
        Quadratic quadCalc = new Quadratic();
        
        for(int[] coeff : COEFF_TESTS) {
            quadCalc.setEquation(coeff[0], coeff[1], coeff[2]);
            System.out.println(coeff[0] + "x^2  " + coeff[1] + "x  " + coeff[2]);
            quadCalc.print();
            System.out.println();
        }
    }
}