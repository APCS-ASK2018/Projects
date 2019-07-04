package Program;

import static Helper.Console.*;
import Program.Items.*;
import Program.Locations.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Player is static since only 1 character will exist
 */

public class Player
{
    public static final int MAX_HEALTH = 200;
    
    protected static int health;
    public static int moves;
    private static AbstractPlace location;
    private static ArrayList<AbstractItem> inventory;
    private static ArrayList<Hazards> damages;
    
    static {
        resetPlayer();
    }
    
    public static AbstractPlace getLocation() {return location;}
    
    public static void goTo(AbstractPlace place) {
        location = place;
        place.enter();
    }
    
    /**
     * Queues new damage to be processed
     * Instant types are added to the front of the list to be processed first
       */
    public static void takeDmg(Hazards dmg) {
        if(dmg.isInstant) damages.add(0,dmg);
        else damages.add(dmg);
    }
    
    public static void kill(String source) {
        takeDmg(new Hazards(1,Player.MAX_HEALTH,source));
    }
    
    public static void heal(int strength) {health += strength;}
    
    public static void recalcHealth() {
        if(health <= 0)
            throw new RuntimeException("Dead player was not removed!.");
        if(health > MAX_HEALTH)
            health = MAX_HEALTH;
        
        Iterator<Hazards> injuries = damages.iterator();
        int instantsCount = 0;
        while(injuries.hasNext()) {
            Hazards dmg = injuries.next();
            health -= dmg.strength;
            dmg.elapsedDuration++;
            
            if(dmg.isInstant)
                instantsCount++;
            if(health <= 0)
                // if dmg kills player, the hazards are still stored as first element
                return;
            if(dmg.ended())
                // Reason for using iterator rather than for-each
                // Need to be able to remove elements
                injuries.remove();
        }
        if(instantsCount > 1)
            throw new RuntimeException("More than 1 instant dmg type in a turn!");
    }
    
    public static void collectItem(AbstractItem item) {
        if(item.collectable) inventory.add(item);
        else if(item instanceof UsableItem) ((UsableItem) item).useItem();
        else throw new RuntimeException("Item not collectable nor usable?");
    }
    
    public static void useItem(String type) {
        int itemIndex = getItemIndex(type);
        if(itemIndex == -1)
            throw new RuntimeException("Attempting to use an item not in possession.");
        
        AbstractItem item = inventory.get(itemIndex);
        if(item instanceof UsableItem) {
            ((UsableItem) item).useItem();
            inventory.remove(item);
        } else {
            print("That item is not usable.");
        }
    }
    
    public static boolean hasItem(String type) {
        return getItemIndex(type) != -1;
    }
    
    public static int getItemIndex(String type) {
        for(int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).itemType.equals(type))
                return i;
        }
        return -1;
    }
    
    public static boolean isAlive() {return health > 0;}
    
    public static ArrayList<AbstractItem> getInventory() {return inventory;}
    
    public static String[] getInventoryAsString() {
        String[] inv = new String[inventory.size()];
        for(int i = 0 ; i < inventory.size() ; i++)
            inv[i] = inventory.get(i).itemType;
        return inv;
    }
    
    public static ArrayList<Hazards> getDamages() {return damages;}
    
    public static void resetPlayer() {
        health = MAX_HEALTH;
        moves = 0;
        location = Regions.outside;
        inventory = new ArrayList<AbstractItem>();
        damages = new ArrayList<Hazards>();
    }
}
