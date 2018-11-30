
/**
 * Write a description of class Balance here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Balance
{
    private final int cents;
    
    public Balance(double bal) {
        this.cents = (int) (bal * 100);
    }
    
    public int[] getBal() {
        final int[] output = new int[5];
        final int[] val = {100, 25, 10, 5, 1};
        int rem = cents;
        
        for (int i = 0 ; i < 5 ; i++) {
            output[i] = rem / val[i];
            rem %= val[i];
        }
        
        return output;
    }
    
    public String toString() {
        final int[] bal = this.getBal();
        String l1 = "Balance in least number of coins";
        String l2 = "\n\tDollars: " + bal[0];
        String l3 = "\n\tQuarters: " + bal[1];
        String l4 = "\n\tDimes: " + bal[2];
        String l5 = "\n\tNickels: " + bal[3];
        String l6 = "\n\tPennies: " + bal[4];
        
        return l1 + l2 + l3 + l4 + l5 + l6;
    }
}
