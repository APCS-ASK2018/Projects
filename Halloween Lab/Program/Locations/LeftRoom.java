package Program.Locations;

import static Helper.Console.*;
import Helper.*;
import Program.*;
import Program.Items.*;

/**
 * This room has various items and regenerating random loot
 * but its door knob is spiked with poison (random chance of actual poisoning)
 * 
 * knob poison chance is out of 100
 */
public class LeftRoom extends AbstractPlace
{
    protected static final String[] validMoves = {"closet","desk","cupboard","return"};
    private static final int KNOB_POISON_CHANCE = 70;
    private static final int KNOB_POISON_DURATION = 5;
    private static final int KNOB_POISON_STRENGTH = 5;
    private static final AbstractItem[] possibleLoots;
    
    static {
        possibleLoots = new AbstractItem[] {
            // Last number represents rarity, key should be very rare
            new ItemKey(1),
            new ItemRope(100),
            new ItemToxin(3,5,200)
        };
    }
    
    private AbstractItem randomLoot;
    private boolean usedDesk, usedCupboard;
    
    public LeftRoom() {
        super();
    }
    
    @Override
    public void enter() {
        super.enter();
        // Random poisoning from door knob trap
        int randInt = (int) (Math.random() * 100);
        if(randInt < KNOB_POISON_CHANCE) {
            // Got poisoned
            print("Ouch!");
            print("The poisoned spike trap activated, piercing your hand with a poisoned needle!");
            Player.takeDmg(
                new Hazards (KNOB_POISON_DURATION, KNOB_POISON_STRENGTH, "poison")
            );
        }
        
        // Regenerate random loot
        randomLoot = AbstractItem.pickRandItem(possibleLoots);
        
        // Reset loot usage stats
        usedDesk = false;
        usedCupboard = false;
    }
    
    @Override
    public void printMenu() {
        print("This room has a closet, a desk with a drawer, and a cupboard.");
        print("What do you want to do?");
        print();
        print("(Closet) Open the closet.");
        print("(Desk) Open the desk drawer.");
        print("(Cupboard) Open the cupboard.");
        print("(Return) Exit the room.");
    }
    
    @Override
    public String[] getValidMoves() {return validMoves;}
    
    @Override
    public boolean canMove(String actionChoice) {
        // No special requirements
        return true;
    }
    
    @Override
    public void move(String actionChoice) {
        super.move();
        switch(Util.arrayIndexOf(validMoves, actionChoice)) {
            case 0: // Closet
                print("*Creek*");
                sleep(1000);
                print("*Smash*");
                print("A giant axe fell out of the closet, slicing you in half!");
                Player.kill("axe");
                break;
            case 1: // Desk drawer
                if(!usedDesk) {
                    print("You found a band aid!");
                    print("This can restore up to 10 points of health.");
                    Player.collectItem( new ItemBandAid(10) );
                    usedDesk = true;
                } else
                    print("The desk drawer is now empty.");
                break;
            case 2: // Cupboard
                if(!usedCupboard) {
                    print("You found a " + randomLoot.itemType + "!");
                    Player.collectItem(randomLoot);
                    usedCupboard = true;
                } else
                    print("The cupboard is now empty.");
                    break;
            case 3: // Exit room
                print("Returning to the bottom hallway.");
                Player.goTo(Regions.bottomHall);
                break;
        }
    }
}
