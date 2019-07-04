package Program.Locations;

import static Helper.Console.*;
import Helper.*;
import Program.*;

/**
 * Upstairs hall
 * Has bedroom and lethal window
 */
public class UpHall extends AbstractPlace
{
    protected static final String[] validMoves = {"bedroom","window","return"};
    
    public UpHall() {
        super();
    }
    
    @Override
    public void printMenu() {
        print("Up the stairs is yet another hall.");
        print("This floor has a bedroom and a vertical sliding window.");
        print("The window is opened, letting in the fierce wind from outside.");
        print("Where will you go?");
        print();
        print("(Bedroom) Explore the bedroom.");
        print("(Window) Look out the window.");
        print("(Return) Head back downstairs.");
    }
    
    @Override
    public boolean canMove(String actionChoice) {
        // No special requirements for moves
        return true;
    }
    
    @Override
    public String[] getValidMoves() {return validMoves;}
    
    @Override
    public void move(String actionChoice) {
        super.move();
        switch(Util.arrayIndexOf(validMoves, actionChoice)) {
            case 0: // Bedroom
                print("Opening the door...");
                sleep(500);
                print("The scent of rotting flesh hits your nose as you enter.");
                Player.goTo(Regions.bedroom);
                break;
            case 1: // Window
                print("You peak out the window, wondering if you could survive the jump.");
                if(Player.hasItem("Rope")) {
                    print("Luckily, you have some rope to assist you.");
                    print("You descend the building, clinging to the rope for dear life.");
                    Game.gameState = 1;
                } else {
                    print("\"Hmmmm... Would I be able to make this jump?\"");
                    sleep(3000);
                    print("*Smash*");
                    print("While pondering in deep thought, the window slid down, snapping your neck!");
                    Player.kill("windowSmash");
                }
                break;
            case 2: // Return downstairs
                print("\"Nothing to see here, I guess...\"");
                print("You head back downstairs.");
                Player.goTo(Regions.bottomHall);
        }
    }
}
