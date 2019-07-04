package Program.Locations;

import static Helper.Console.*;
import Program.*;

/**
 * Trap room - You cannot exit once you enter
 * Eat corpse and random chance of surviving as vampire
 * ... or die
 */
public class Bedroom extends AbstractPlace
{
    protected static final String[] validMoves = {"pray","eat"};
    private static final int VAMPIRE_CHANCE = 20;
    
    public Bedroom() {
        super();
    }
    
    @Override
    public void printMenu() {
        int moveCount = getCurrentMoves();
        print("Looking around the room, you notice the following:");
        print("The room is completely sealed. No windows nor chimneys.");
        print("There is a rotting corpse on the floor.");
        if(moveCount == 0) {
            print("And...");
            sleep(3000);
            print("!!!");
            sleep(1000);
            print("The door closed by itself and there is no handle on the inside!");
        }
        print("You are trapped in this room!");
        print();
        print("(Pray) Pray for help.");
        if(moveCount >= 2) {print("(Eat) Eat the corpse.");}
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
        if(validMoves[0].equals(actionChoice)) {
            // Pray for help
            int moveCount = getCurrentMoves();
            print("\"Mommy! Help! I'm trapped in a room and I can't get out!\"");
            for(int i = 0 ; i < 3 ; i++) {
                sleep(1000);
                print("...");
            }
            print("You prayed for help...");
            sleep(100);
            print("but none came...");
            if(moveCount > 1 && moveCount <= 3) {
                print("...just like last time.");
                print("...and you start to get hungry...");
            }
            if(moveCount > 3) {
                print("...just like last time.");
                print("Praying to no avail, you waste away in the room, becoming another body in the room.");
                Player.kill("hunger");
            }
        } else {
            // Eat corpse
            int randInt = (int) (Math.random() * 100);
            if(randInt < VAMPIRE_CHANCE) {
                // Successful conversion
                print("You feel an odd sense of tingling in your stomache as you digest the body...");
                print("You begin to twitch as the pain grows...");
                sleep(3000);
                print("\"AAAAHHHHHH\"");
                sleep(3000);
                print("You became a vampire!");
                Game.gameState = 3;
            } else {
                // Failed conversion
                print("Yuck!");
                print("The rotten meat made you sick.");
                Player.takeDmg(new Hazards(2,10,"poison"));
            }
        }
    }
}
