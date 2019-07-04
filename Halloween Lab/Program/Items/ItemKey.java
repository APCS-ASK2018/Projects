package Program.Items;

import Program.*;
import Program.Locations.*;

/**
 * Write a description of class ItemKey here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ItemKey extends AbstractItem
{
    public ItemKey(int rarity) {
        super("Key",rarity,true);
    }
    
    public ItemKey() {
        this(1);
    }
}
