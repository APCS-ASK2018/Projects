package Program.Items;


/**
 * Collectable item
 * If player possesses this item when approaching the upHall window
 * the player may escape safely
 * Doing so without a rope item will lead to death
 */
public class ItemRope extends AbstractItem
{
    public ItemRope(int rarity) {
        super("Rope",rarity,true);
    }
    
    public ItemRope() {
        this(1);
    }
}
