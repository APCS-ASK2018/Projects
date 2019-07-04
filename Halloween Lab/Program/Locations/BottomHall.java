package Program.Locations;

import static Helper.Console.*;
import Helper.*;
import Program.*;

/**
 * The hallway that splits into 3 areas
 * Player can choose which region to explore
 * If player has key, he can unlock the entrance and escape
 * Key is ultra rare and is virtually non-existent
 */
public class BottomHall extends AbstractPlace
{
    protected static final String[] validMoves = {"left","middle","right","door"};
    
    public BottomHall() {
        super();
    }
    
    @Override
    public void printMenu() {
        if(getTotalMoves() == 0) {
            // First time entering
            print("*Slam*");
            print("Oh no! The wind closed the door shut!");
        }
        print("This hall splits off in 3 paths. Which path will you take?");
        print();
        print("(Left) A room on the left. The knob has a poisoned spike trap.");
        print("(Middle) The middle staircase heading up. There is a scent of blood.");
        print("(Right) A long, dark passage on the right.");
        print("(Door) Walk out through the door you came in.");
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
        // Player may be allowed to take back a choice
        print();

        if(actionChoice.equals(validMoves[0])) {
            print("Entering the left room...");
            Player.goTo(Regions.leftRoom);
        } else if(actionChoice.equals(validMoves[1])) {
            print("Heading upstairs...");
            Player.goTo(Regions.upHall);
        } else if(actionChoice.equals(validMoves[2])) {
            print("Walking through the hallway...");
            sleep(1000);
            print("*Creek*");
            print("The floor swung open! It's a trap!");
            Player.goTo(Regions.maze);
        } else {
            // Try to open the door
            print("The door is locked!");
            if(Player.hasItem("key")) {
                Player.useItem("key");
                print("Luckily, you have the key to this door.");
                // Game ends. You win
                Game.gameState = 1;
            } else {
                print("The door will not budge.");
                print("Without the key, you must find another escape path.");
            }
        }
        
        super.move();
    }
}
