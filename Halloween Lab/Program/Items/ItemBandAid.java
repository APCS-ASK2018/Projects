package Program.Items;

import Program.*;

/**
 * Healing item that can be used on demand
 */
public class ItemBandAid extends AbstractItem implements UsableItem
{
    public final int strength;
    
    public ItemBandAid(int strength, int rarity) {
        super("Band Aid" , rarity, true);
        this.strength = strength;
    }
    
    public ItemBandAid(int strength) {
        this(strength, 1);
    }
    
    @Override
    public void useItem() {
        Player.heal(strength);
    }
}
