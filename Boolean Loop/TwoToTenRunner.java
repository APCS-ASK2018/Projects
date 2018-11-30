

public class TwoToTenRunner
{
    public static void main ( String[] args )
    {
        //add test cases
        String[] testCase = {
            "1010",
            "1100",
            "1110",
            "1111",
            "11111",
            "111111",
            "1110101",
            "10101010101",
            "1010101010110",
            "111111111111111111"
        };
        
        for(String bin : testCase) {
            long dec = Long.parseLong(bin, 2);
            System.out.println(bin + " == " + dec);
            System.out.println();
        }
    }
}