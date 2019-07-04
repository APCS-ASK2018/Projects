package Program;

import static Helper.Console.*;
import Helper.*;
import Program.*;
import Program.Locations.AbstractPlace;
import Program.Items.AbstractItem;
import java.util.Arrays;

/**
 * Game runner
 * Runs the game for 1 round
 */
public class Game
{
    /*
     * -1 = Not started
     * 0 = Playing
     * 1 = Win
     * 2 = Lose
       */
    public static int gameState;
    
    public static void run() throws Exception {
        gameState = 0;
        String endingMsg;
        
        AbstractPlace location;
        Hazards lethalHit = null;
        while(true) {
            // Re-evaluate health
            // End game if player is killed by damage
            Player.recalcHealth();
            if(!Player.isAlive()) {
                gameState = 2;
                lethalHit = Player.getDamages().get(0);
                break;
            }
            
            // End game if marked as over
            if(gameState > 0) break;
            
            // Print move count
            print("===========================================================");
            print("Move #" + (Player.moves + 1));
            
            // Report health
            print("Your health is " + Player.health + "/" + Player.MAX_HEALTH);
            if(Player.getDamages().size() > 0) {
                print("Active effects:");
                print(Player.getDamages());
            }
            
            // Ask player for item usage
            String[] inventory = Player.getInventoryAsString();
            if(inventory.length != 0) {
                print("Your inventory contains the following items:");
                print(Arrays.asList(inventory));
                print();
                print("Would you like to use an item?");
                while(Kb.readBool()) {
                    print("Which item would you like to use?");
                    String itemToUse = Kb.readString(inventory);
                    Player.useItem(itemToUse);
                    print("Use another item?");
                }
            }
            
            // Get location and print menu
            location = Player.getLocation();
            location.printMenu();
            
            // Ask and evaluate valid player choice
            String actionChoice;
            while(true) {
                actionChoice = Kb.readString(location.getValidMoves());
                if(location.canMove(actionChoice)) {
                    location.move(actionChoice);
                    break;
                }
            }
            
            print();
            print("Press any key to continue.");
            Kb.readInput();
        }
        
        // Evaluate ending message based on game state and player's last location
        // or damages
        clear();
        print("Game Over");
        switch(gameState) {
            case 1: // win
                print("You successfully escaped!");
                break;
            case 2: // lose
                print("You were killed by " + lethalHit.source);
                break;
            case 3: // lame ending
                print("As a vampire, you continue to live in this mansion. Forever.");
        }
    }
    
    public static void help() throws Exception {
        print("This is a \"choose-your-adventure\" style game.");
        print("You will guide your character through a sinister-looking building.");
        print("Your job is to escape, preferably alive in one piece.");
        print();
        print("During various stages of gameplay, you will be presented with choices of action.");
        print("Every move has consequences so pick wisely.");
        print();
        print("Press any key for next page.");
        Kb.readInputNoQuit("I'm not finished!!!");
        clear();
        
        print("Your character has " + Player.MAX_HEALTH + " health points.");
        print("You can lose health at an instance or lose health repeatedly over time.");
        print("Occasionally, you may find an item that can partially restore your health.");
        print("In addition, you may find various items that assist or hinder your journey.");
        print();
        print("At any point in the game, you may type \"Quit\" to end the game.");
        print("Upon doing so, you may hang your head in shame for abandoning your character eternally.");
        print();
        print("Press any key to begin playing.");
        Kb.readInput();
        clear();
    }
}
