public class RomanNumeral
{
    private final static String LETTERS ="IVXLCDM";

    /**
     * Valid lettters of roman numeral stored as String in order to make use of indexOf method
     * Finds the numerical values of the first 2 letters
     * If 2nd letter has larger value than first (eg IV), they are grouped together and become a new value of their difference (5 - 1 = 4)
     * Otherwise, just process the first letter (eg VI -> 'V' -> 5)
     * 
     * Sum up the numerical values and slice off the roman numeral string that has been processed
     * 
     * @param roman Roman numeral as string
     * @return Decimal value of the given roman numeral
     * @throws RuntimeException when roman numeral uses unsupported letters
     */
    public static int toDec(String roman) {
        int output = 0;
        int[] temp = new int[2];
        while(roman.length() > 0) {
            for(int i = 0 ; i < 2 ; i++) {
                // Get value of 2 letters of roman numeral
                
                switch(LETTERS.indexOf(roman.charAt(i))) {
                    case -1: throw new RuntimeException("Invalid roman numeral!");
                    case 0: // I
                        temp[i] = 1;
                        break;
                    case 1: // V
                        temp[i] = 5;
                        break;
                    case 2: // X
                        temp[i] = 10;
                        break;
                    case 3: // L
                        temp[i] = 50;
                        break;
                    case 4: // C
                        temp[i] = 100;
                        break;
                    case 5: // D
                        temp[i] = 500;
                        break;
                    case 6: // M
                        temp[i] = 1000;
                        break;
                }
                
                if(roman.length() <= 1) {
                    // If no second letter left, default to 0 and break out
                    temp[1] = 0;
                    break;
                }
            }
            
            if(temp[0] < temp[1]) {
                // Is special case - 2 letters make up 1 value
                output += temp[1] - temp[0];
                roman = roman.substring(2);
            } else {
                // Normal case
                output += temp[0];
                roman = roman.substring(1);
            }
        }
        return output;
    }

    /**
     * Process from largest value to smaller value
     * Subtract the amount that has been processed, and add the corresponding roman numeral string
     * Conditionals for every critical value (k x 10^n where k is 1, 4, 5, 9)
     * 
     * @param dec Decimal number to be converted to roman numeral
     * @return String that represents the number in roman numeral
     * @throws RuntimeException when number is too large or too small
     */
    public static String toRoman(int dec) {
        if(dec > 3999 || dec <= 0)
            throw new RuntimeException("Number outside supported range!");
        final int[] DECIMAL = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        final String[] ROMAN = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuilder output = new StringBuilder();
        for(int i = ROMAN.length - 1; i >= 0; i--)
            while(dec >= DECIMAL[i]) {
                output.append(ROMAN[i]);
                dec -= DECIMAL[i];
            }
        return output.toString();
    }
}
