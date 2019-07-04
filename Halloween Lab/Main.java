import static Helper.Console.*;
import Helper.*;
import Program.*;
import Program.Locations.*;

/**
 * Main method
 * Starts the app
 * Has error handling and replay
 */
public class Main
{
    public static void main(String[] args) throws Exception {
        while(true) {
            try {
                clear();
                resetGame();
                print("\t\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/");
                print("\t Halloween Adventures");
                print("\t/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
                Game.help();
                Game.run();
            } catch(Exception e) {
                String errorMsg = e.getMessage();
                if(errorMsg != null && errorMsg.equals("Quit")) {
                    // Exception due to player quitting the game
                    clear();
                    print("Quitter!");
                    print();
                    for(int i = 0 ; i < 3 ; i++) {
                        sleep(1000);
                        print("Shame!");
                    }
                } else {
                    // Exception resulted from code error
                    // Print error for debugging, then exit program
                    e.printStackTrace();
                    return;
                }
            }
            
            sleep(1000);
            print();
            print("New game?");
            if(!Kb.readBool())
                return;
        }
    }
    
    public static void resetGame() {
        Regions.resetRegions();
        Player.resetPlayer();
    }
}
