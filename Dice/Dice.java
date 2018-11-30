
/**
 * Write a description of class Dice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dice
{
    private int[] rolls = new int[2];
    
    public int[] roll() {
        rolls[0] = (int) (Math.random() * 6) + 1;
        rolls[1] = (int) (Math.random() * 6) + 1;
        return rolls;
    }
    
    public boolean isSnakeEyes() {
        return (rolls[0] == 1) && (rolls[1] == 1);
    }
}
