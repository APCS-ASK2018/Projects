package Program.Items;

import Helper.*;

/**
 * Write a description of class Loot here.
 *
 * rarity = Weight of random roll (1-100)
 * collectable = if item can be stored in inventory or used up instantly
 */
public abstract class AbstractItem
{
    public static final String[] validTypes = {"Key","Rope","Band Aid", "Toxin"};
    
    public final String itemType;
    public final int rarity;
    public final boolean collectable;
    
    public AbstractItem(String type, int rarity, boolean collectable) {
        if(rarity < 1 || rarity > 500)
            throw new RuntimeException("Item rarity must be 1-500");
        if(!Util.arrayContains(AbstractItem.validTypes,type))
            throw new RuntimeException("Invalid item type!");
        itemType = type;
        this.rarity = rarity;
        this.collectable = collectable;
    }
    
    public static AbstractItem pickRandItem(AbstractItem[] itemPool) {
        int poolSize = 0;
        int[] poolWeight = new int[itemPool.length];
        for(int i = 0 ; i < itemPool.length ; i++) {
            poolWeight[i] = itemPool[i].rarity;
            poolSize += poolWeight[i];
        }
        int randInt = (int) (Math.random() * poolSize);
        for(int i = 0 ; i < poolWeight.length ; i++) {
            if(randInt >= poolWeight[i])
                randInt -= poolWeight[i];
            else
                return itemPool[i];
        }
        throw new RuntimeException("Random item picker execution broken!");
    }
}
