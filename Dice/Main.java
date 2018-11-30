
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) {
        Dice d = new Dice();
        
        while( !d.isSnakeEyes() ) {
            int[] rolls = d.roll();
            System.out.println("You rolled a " + rolls[0] + " and " + rolls[1]);
        }
        
        System.out.println("Snake Eyes! You rolled 2 '1's in a row!");
    }
}
