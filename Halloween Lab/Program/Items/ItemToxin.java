package Program.Items;

import Program.*;

/**
 * Toxic fumes that are found in random loots
 * Effective immediately upon "collecting"
 */
public class ItemToxin extends AbstractItem implements UsableItem
{
    public final int duration;
    public final int strength;
    
    public ItemToxin(int duration, int strength, int rarity)
    {
        super("Toxin", rarity, false);
        this.duration = duration;
        this.strength = strength;
    }
    
    public ItemToxin(int duration, int strength) {
        this(duration, strength, 1);
    }
    
    @Override
    public void useItem() {
        Player.takeDmg(new Hazards(duration, strength, "poison"));
    }
}
