package Program.Locations;

import Program.*;

/**
 * Umbrella class for all locations
 * 
 * Note that input sanatizing will be done by Kb class in the game runner
 * No need to re-check in canMove(string) method
 */
public abstract class AbstractPlace
{
    // All subclasses will have
    // public static final String[] validMoves
    // Java doesn't allow abstract + static so no good way to set varying options
    
    private int visitCount;
    private int currentMoves;
    private int totalMoves;
    
    public AbstractPlace() {
        visitCount = 0;
        currentMoves = 0;
        totalMoves = 0;
    }
    
    // @Override this when resetting location after each entry
    public void enter() {
        visitCount++;
        currentMoves = 0;
    }
    
    public abstract void printMenu();
    
    public abstract boolean canMove(String actionChoice);
    
    public abstract void move(String actionChoice);
    
    public abstract String[] getValidMoves();
    
    protected void move() {
        // Default operations every move must do
        // But should only be triggered through polymorphic move(string) method
        currentMoves++;
        totalMoves++;
        Player.moves++;
    }
    
    public int getCurrentMoves() {
        return currentMoves;
    }
    
    public int getTotalMoves() {
        return totalMoves;
    }
}
