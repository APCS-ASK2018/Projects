import static java.lang.System.*;

public class RomanNumeralRunner
{
    public static void main( String args[] )
    {
        int[] decTest = {10,100,1000,2500,1500,23,38,49};
        String[] romanTest = {"LXXVII","XLIX","XX","XLIX"};
        
        for(int i : decTest) {
            out.println(i + " is " + RomanNumeral.toRoman(i));
            out.println();
        }
        
        for(String roman : romanTest) {
            out.println(roman + " is " + RomanNumeral.toDec(roman));
            out.println();
        }
    }
}