public abstract class Champion
{
    private String name;
    private String nickName;
    private int level;
    
    public Champion(String nm, String nick, int lv)
    {
        name = nm;
        nickName = nick;
        level = lv;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getNickName()
    {
        return nickName;
    }
    
    public int getLevels()
    {
        return level;
    }
    
    public String toString()
    {
        String l1 = name + ", " + nickName + "\n";
        String l2 = "Level = " + level + "\n";
        String l3 = "Mana = " + mana() + "\n";
        String l4 = "Armor = " + armor() + "\n";
        String l5 = "Magic Resis = " + magicresist() + "\n";
        String l6 = "Movement Speed = " + movementspeed() + "\n";
        return l1 + l2 + l3 + l4 + l5 + l6;
    }
    
    public abstract double health();
    public abstract double mana();
    public abstract double armor();
    public abstract double magicresist();
    public abstract int movementspeed();
}