

public class GCDRunner
{
    public static void main ( String[] args )
    {
        //add test cases
        int[][] testCase = {
            {5,25},
            {4,400},
            {8,80},
            {15,45},
            {6,66},
            {9,9},
            {3,543}
        };
        
        for (int i = 0, j = testCase.length ; i < j ; i++) {
            int num1 = testCase[i][0];
            int num2 = testCase[i][1];
            System.out.println(
                "The GCD of " + num1 + " and " + num2 + " is "
                + GCD.getGCD(num1, num2)
            );
        }
    }
}