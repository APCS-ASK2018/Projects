package Program.Locations;

import static Helper.Console.*;
import Helper.*;
import Program.*;

/**
 * The starting place of the game, outside the mansion
 * You don't have to enter, but it will rain soon
 * You will catch a cold if you stay out in the rain
 * 
 * This room will not be used after the first time (since exiting means game ending)
 */
public class Outside extends AbstractPlace
{
    protected static final String[] validMoves = {"enter","stay"};
    private static final int COLD_AFTER = 2;
    private static final String[] menuMsg = {
        "It looks like it's going to rain soon too.",
        "It begins to rain.",
        "You start to shiver.",
        "**Rain INTENSIFIES**"
    };
    
    public Outside() {
        super();
    }
    
    @Override
    public void printMenu() {
        print("You are outside the Halloween Mansion, in the middle of nowhere.");
        if(getCurrentMoves() < menuMsg.length)
            print(menuMsg[getCurrentMoves()]);
        else
            print("Your body temperature drops dangerously low.");
        print();
        print("(Enter) Enter the mansion.");
        print("(Stay) Stay outside.");
    }
    
    @Override
    public String[] getValidMoves() {return validMoves;}

    @Override
    public boolean canMove(String actionChoice) {
        // No special requirements for moves
        return true;
    }
    
    @Override
    public void move(String actionChoice) {
        super.move();
        print();
        if(actionChoice.equals(validMoves[1])) {
            // If stay outside
            int moves = getCurrentMoves();
            if(moves > COLD_AFTER) {
                // Damage and effect of cold increases as the player
                // continues to stay outside, eventually killing them
                print("The cold is starting to take a toll on your health.");
                Player.takeDmg(new Hazards(moves - COLD_AFTER , moves * 5 , "cold"));
            }
        } else {
            print("Entering the mansion...");
            Player.goTo(Regions.bottomHall);
        }
    }
}
