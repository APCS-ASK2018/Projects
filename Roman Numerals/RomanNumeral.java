public class RomanNumeral
{
    private static final int[] DECIMAL = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
	private static final String[] ROMAN = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

    /**
     * Go through each critical value of roman numeral from largest to smallest
     * Each time a critical value is found, add its numerical value to output and skip forward by the roman numeral length
     * 
     * @param roman Roman numeral as string
     * @return Decimal value of the given roman numeral
     * @throws RuntimeException when roman numeral uses unsupported letters
     */
    public static int toDec(String txt) {
		int output = 0;
		int j = 0;
		for(int i = ROMAN.length - 1; i >= 0; i--)
			while(j < txt.length() && txt.startsWith(ROMAN[i],j)) {
				output += DECIMAL[i];
				j += ROMAN[i].length();
			}
		return output;
	}

    /**
     * Go through each critical value of roman numeral from largest to smallest
     * Subtract the amount that has been processed, and add the corresponding roman numeral string
     * 
     * @param dec Decimal number to be converted to roman numeral
     * @return String that represents the number in roman numeral
     * @throws RuntimeException when number is too large or too small
     */
    public static String toRoman(int num) {
		if(num > 3999 || num <= 0)
			throw new RuntimeException("Number outside supported range!");
		
		StringBuilder output = new StringBuilder();
		for(int i = ROMAN.length - 1; i >= 0; i--)
			while(num >= DECIMAL[i]) {
				output.append(ROMAN[i]);
				num -= DECIMAL[i];
			}
		return output.toString();
	}
}
